package it.ictpiemonte.immobiliare.controller;

import it.ictpiemonte.immobiliare.payload.request.AnnuncioRequest;
import it.ictpiemonte.immobiliare.service.AnnuncioService;
import it.ictpiemonte.immobiliare.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("annuncio")
@RequiredArgsConstructor
public class AnnuncioController {

    private final AnnuncioService annuncioService;
    private final UserService userService;

    @Value("${annuncio.image.size}")
    private long imageSize;
    @Value("${annuncio.image.width}")
    private int imageWidth;
    @Value("${annuncio.image.height}")
    private int imageHeight;
    @Value("${annuncio.image.extensions}")
    private String[] extensions;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid AnnuncioRequest request) {
        return annuncioService.saveAnnuncio(request);
    }

    @GetMapping("/home")
    public ResponseEntity<?> annunciInHomePage(@RequestParam(defaultValue = "TO") @NotBlank @Size(min = 2, max = 2) String provinciaId,
                                               @RequestParam(defaultValue = "0") int pageNumber, //numero della pagina da cui partire
                                               @RequestParam(defaultValue = "3") int pageSize, // numero di elementi per pagina
                                               @RequestParam(defaultValue = "DESC") String direction, // ordinamento ASC o DESC
                                               @RequestParam(defaultValue = "id") String sortBy) { // la colonna su cui effettuare l'ordinamento
        return annuncioService.getAnnunciHomePage(provinciaId, pageNumber, pageSize, direction, sortBy);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnnuncioDetail(@PathVariable int id) {
        return annuncioService.getAnnuncioDetail(id);
    }

    @PostMapping("/add-image/{id}")
    public ResponseEntity<?> addImage(@PathVariable int id, @RequestParam MultipartFile file) {
        return annuncioService.addImage(file, imageHeight, imageWidth, imageSize, extensions);
    }

}