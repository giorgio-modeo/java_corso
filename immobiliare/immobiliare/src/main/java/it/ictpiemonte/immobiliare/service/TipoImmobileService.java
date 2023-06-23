package it.ictpiemonte.immobiliare.service;

import it.ictpiemonte.immobiliare.entity.TipoImmobile;
import it.ictpiemonte.immobiliare.repository.TipoImmobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoImmobileService {

    private final TipoImmobileRepository tipoImmobileRepository;

    public ResponseEntity<?> addTipoImmobile(String tipoImmobile){
        if(tipoImmobileRepository.existsByTipoImmobile(tipoImmobile))
            return new ResponseEntity("Tipo immobile già censito", HttpStatus.BAD_REQUEST);
        return new ResponseEntity(tipoImmobileRepository.save(new TipoImmobile(tipoImmobile)), HttpStatus.CREATED);
    }
}
