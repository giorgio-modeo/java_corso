package it.ictpiemonte.immobiliare.service;

import it.ictpiemonte.immobiliare.entity.Comune;
import it.ictpiemonte.immobiliare.entity.Provincia;
import it.ictpiemonte.immobiliare.payload.request.ComuneRequest;
import it.ictpiemonte.immobiliare.payload.response.ComuneResponse;
import it.ictpiemonte.immobiliare.repository.ComuneRepository;
import it.ictpiemonte.immobiliare.repository.ProvinciaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ComuneService {

    // Dependency injection by cosnstructor
    private final ComuneRepository comuneRepository;
    private final ProvinciaRepository provinciaRepository;

    public ComuneService(ComuneRepository comuneRepository, ProvinciaRepository provinciaRepository) {
        this.comuneRepository = comuneRepository;
        this.provinciaRepository = provinciaRepository;

    }

    @CacheEvict(cacheNames="elencoComuniPerProvincia", allEntries=true)
    public ResponseEntity<?> addComune(ComuneRequest request){
        log.info("Il metodo addComune ha eliminato la cache elencoComuniPerProvincia");
        Comune comune = fromRequestToEntity(request);
        if(comune == null)
            return new ResponseEntity("Impossibile salvare il comune", HttpStatus.BAD_REQUEST);
        else {
            if(comuneRepository.existsByComuneAndProvincia(request.getComune(), comune.getProvincia()))
                return new ResponseEntity("Comune già censito", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(comuneRepository.save(comune), HttpStatus.CREATED);
    }

    public Comune fromRequestToEntity(ComuneRequest request){
        Comune comune = null;
        Optional<Provincia> provincia = provinciaRepository.findById(request.getSiglaProvincia());
        if(provincia.isPresent()){
            comune = new Comune();
            comune.setCap(request.getCap());
            comune.setComune(request.getComune());
            comune.setProvincia(provincia.get());
        }
            return comune;
    }

    @Cacheable("elencoComuniPerProvincia")
    public ResponseEntity<List<ComuneResponse>> getComuniByProvincia(String provinciaId){
        log.info("Il metodo getComuniByProvincia finirà in cache");
        return new ResponseEntity(comuneRepository.getComuni(provinciaId), HttpStatus.OK);
    }

    @CacheEvict(cacheNames="elencoComuniPerProvincia", allEntries=true)
    public ResponseEntity<?> updateComune(int comuneId, ComuneRequest request){
        log.info("Il metodo updateComune ha eliminato la cache elencoComuniPerProvincia");
        boolean nomeComune = comuneRepository.existsByProvinciaIdAndComuneAndIdNot(request.getSiglaProvincia(), request.getComune(),comuneId);
        if(nomeComune)
            return new ResponseEntity("Comune già presente per la provincia selezionata", HttpStatus.BAD_REQUEST);
        else {
            Comune c = fromRequestToEntity(request);
            c.setId(comuneId);
            comuneRepository.save(c);
        }
    return new ResponseEntity("Comune aggiornato", HttpStatus.OK);
    }

}
