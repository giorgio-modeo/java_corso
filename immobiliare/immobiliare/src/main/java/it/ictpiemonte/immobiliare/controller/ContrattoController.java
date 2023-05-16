package it.ictpiemonte.immobiliare.controller;

import it.ictpiemonte.immobiliare.service.ContrattoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controller")
@RequiredArgsConstructor
@Validated
public class ContrattoController {
    private final ContrattoService contrattoService;

    @PostMapping
    public ResponseEntity<?>.addContratto(@RequestParam @NotBlank String tipoContratto)

}
