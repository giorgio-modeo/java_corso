package it.ictpiemonte.immobiliare.controller;

import it.ictpiemonte.immobiliare.entity.Provincia;
import it.ictpiemonte.immobiliare.service.ProvinciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("provincia")
@RequiredArgsConstructor
public class ProvinciaController {

    private final ProvinciaService provinciaService;

    @GetMapping("/all") //localhost:8090/provincia/all
    public List<Provincia> findAll(){
        return provinciaService.findAll();
    }
}
