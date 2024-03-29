package it.ictpiemonte.immobiliare.controller;

import it.ictpiemonte.immobiliare.service.ContrattoService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contratto")
@RequiredArgsConstructor
@Validated
public class ContrattoController {

    private final ContrattoService contrattoService;

    @PostMapping
    public ResponseEntity<?> addContratto(@RequestParam @NotBlank @Size(max=50, min=5) String tipoContratto){
        return contrattoService.addContratto(tipoContratto);
    }
}
