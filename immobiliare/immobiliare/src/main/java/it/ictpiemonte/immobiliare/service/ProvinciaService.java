package it.ictpiemonte.immobiliare.service;

import it.ictpiemonte.immobiliare.entity.Provincia;
import it.ictpiemonte.immobiliare.repository.ProvinciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvinciaService {
    private final ProvinciaRepository provinciaRepository;
    public List<Provincia> findAll(){
        return provinciaRepository.findAllByOrderByProvinciaAsc();

    }

}
