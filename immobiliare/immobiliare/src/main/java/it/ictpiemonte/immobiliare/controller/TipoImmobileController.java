package it.ictpiemonte.immobiliare.controller;

import it.ictpiemonte.immobiliare.service.TipoImmobileService;
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
@RequestMapping("tipo-immobile")
@Validated
@RequiredArgsConstructor
public class TipoImmobileController {

    private final TipoImmobileService tipoImmobileService;

    @PostMapping
    public ResponseEntity<?> addTipoImmobile(@RequestParam @NotBlank(message="Tipo Immobile o è vuoto o è null") @Size(min=3, max=25) String tipoImmobile){
        return tipoImmobileService.addTipoImmobile(tipoImmobile);
    }
}
