package it.ictpiemonte.immobiliare.service;

import it.ictpiemonte.immobiliare.entity.Provincia;
import it.ictpiemonte.immobiliare.repository.ProvinciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvinciaService {

    private final ProvinciaRepository provinciaRepository;

    public ResponseEntity<?> findAll(){
        List<Provincia> list = provinciaRepository.findAllByOrderByProvinciaAsc();
        if(list.isEmpty())
            return new ResponseEntity("Nessuna provincia trovata", HttpStatus.NOT_FOUND);
        return new ResponseEntity(list, HttpStatus.OK);
    }




}
