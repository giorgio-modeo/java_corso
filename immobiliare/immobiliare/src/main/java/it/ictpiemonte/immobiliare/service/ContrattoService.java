package it.ictpiemonte.immobiliare.service;

import it.ictpiemonte.immobiliare.entity.Contratto;
import it.ictpiemonte.immobiliare.repository.ContrattoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContrattoService {

    private final ContrattoRepository contrattoRepository;

    public ResponseEntity<?> addContratto(String tipoContratto){
        if(contrattoRepository.existsByTipoContratto(tipoContratto))
            return new ResponseEntity("Tipo contratto già esistente", HttpStatus.BAD_REQUEST);
        return new ResponseEntity(contrattoRepository.save(new Contratto(tipoContratto)), HttpStatus.CREATED);
    }

}
