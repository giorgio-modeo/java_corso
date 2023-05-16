package it.ictpiemonte.immobiliare.service;

import it.ictpiemonte.immobiliare.repository.ComuneRepository;
import org.springframework.stereotype.Service;

@Service
public class ComuneService {
    private final ComuneRepository comuneRepository;

    public ComuneService(ComuneRepository comuneRepository) {
        this.comuneRepository = comuneRepository;
    }


}
