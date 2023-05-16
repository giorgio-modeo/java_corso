package it.ictpiemonte.immobiliare.service;

import it.ictpiemonte.immobiliare.entity.Comune;
import it.ictpiemonte.immobiliare.entity.Provincia;
import it.ictpiemonte.immobiliare.payload.ComuneRequest;
import it.ictpiemonte.immobiliare.repository.ComuneRepository;
import it.ictpiemonte.immobiliare.repository.ProvinciaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComuneService {
    private final ComuneRepository comuneRepository;
    private final ProvinciaRepository provinciaRepository;


    public ComuneService(ComuneRepository comuneRepository,ProvinciaRepository provinciaRepository ) {
        this.comuneRepository = comuneRepository;
        this.provinciaRepository = provinciaRepository;

    }
    public ResponseEntity<?> addComune(ComuneRequest request){
        Comune comune = formRequestToEntity(request);
        if (comune == null)
            return new ResponseEntity("inpossibile salvare il comune", HttpStatus.BAD_REQUEST);
        else {
            if (comuneRepository.existsByComuneAndProvincia(request.getComune(),comune.getProvincia()))
            return new ResponseEntity("comune gia censito", HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity(comuneRepository.save(comune),HttpStatus.CREATED);
    }
    public Comune formRequestToEntity(ComuneRequest request){
        Comune comune = null;
        Optional<Provincia> provincia = provinciaRepository.findById(request.getSiglaProvincia());
        if (provincia.isPresent()) {
            comune = new Comune();
            comune.setCap(request.getCap());
            comune.setComune(request.getComune());
            comune.setProvincia(provincia.get());
        }
        return  comune;
    }
}
