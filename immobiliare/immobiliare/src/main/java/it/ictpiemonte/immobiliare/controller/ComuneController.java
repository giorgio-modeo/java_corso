package it.ictpiemonte.immobiliare.controller;

import it.ictpiemonte.immobiliare.payload.request.ComuneRequest;
import it.ictpiemonte.immobiliare.service.ComuneService;
import it.ictpiemonte.immobiliare.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comune")
@RequiredArgsConstructor
@Slf4j
public class ComuneController {

    private final ComuneService comuneService;
    private final UserService userService;

    @PostMapping // localhost:8090/comune
    public ResponseEntity<?> addComune(@RequestBody @Valid ComuneRequest request, HttpServletRequest httpRequest){
        log.info("--------- "+httpRequest.getAttribute("USER-ROLE"));
        return comuneService.addComune(request);
    }

    @GetMapping("/{provinciaId}")
    public ResponseEntity<?> getComuniByProvincia(@PathVariable String provinciaId){
        return comuneService.getComuniByProvincia(provinciaId);
    }

    @PutMapping("/{comuneId}")
    public ResponseEntity<?> updateComune(@PathVariable int comuneId, @RequestBody ComuneRequest request, HttpServletRequest httpRequest) {
            return comuneService.updateComune(comuneId, request);
    }
}
