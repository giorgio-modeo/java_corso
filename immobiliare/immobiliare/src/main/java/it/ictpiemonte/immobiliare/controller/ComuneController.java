package it.ictpiemonte.immobiliare.controller;

import it.ictpiemonte.immobiliare.payload.ComuneRequest;
import it.ictpiemonte.immobiliare.service.ComuneService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comune")
@RequiredArgsConstructor
public class ComuneController {
    private final ComuneService comuneService;
    @PostMapping // localhost:8090/comune
    public ResponseEntity<?> addComune(@RequestBody @Valid ComuneRequest request){
    return comuneService.addComune(request);

    }
}
