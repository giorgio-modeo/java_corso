package it.ictpiemonte.immobiliare.service;

import it.ictpiemonte.immobiliare.entity.Comune;
import it.ictpiemonte.immobiliare.entity.Contratto;
import it.ictpiemonte.immobiliare.entity.Immobile;
import it.ictpiemonte.immobiliare.entity.TipoImmobile;
import it.ictpiemonte.immobiliare.payload.request.ImmobileRequest;
import it.ictpiemonte.immobiliare.repository.ComuneRepository;
import it.ictpiemonte.immobiliare.repository.ContrattoRepository;
import it.ictpiemonte.immobiliare.repository.ImmobileRepository;
import it.ictpiemonte.immobiliare.repository.TipoImmobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImmobileService {

    private final ImmobileRepository immobileRepository;
    private final ContrattoRepository contrattoRepository;
    private final TipoImmobileRepository tipoImmobileRepository;
    private final ComuneRepository comuneRepository;

    public ResponseEntity<?> addImmobile(ImmobileRequest request){
        Immobile i = fromRequestToEntity(request);
        if(i == null)
            return new ResponseEntity("Parametri sbagliati o mancanti", HttpStatus.BAD_REQUEST);
        immobileRepository.save(i);
        return new ResponseEntity("Immobile salvato correttamente", HttpStatus.CREATED);
    }

    public Immobile fromRequestToEntity(ImmobileRequest request) {
        Immobile i = null;
        // controllo esistenza di contratto, tipo immobile e comune
        if (contrattoRepository.existsById(request.getContratto()) &&
                tipoImmobileRepository.existsById(request.getTipoImmobile()) &&
                comuneRepository.existsById(request.getComune())) {
            i = new Immobile(
                    new TipoImmobile(request.getTipoImmobile()),
                    request.getMetratura(),
                    request.getNumeroBagni(),
                    request.getNumeroStanze(),
                    request.getClasseEnergetica(),
                    request.isBox(),
                    new Comune(request.getComune()),
                    new Contratto(request.getContratto()),
                    request.getPrezzo(),
                    request.getIndirizzo()
            );
        }
        return i;
    }

    public Immobile findById(int immobileId){
        Optional<Immobile> i = immobileRepository.findById(immobileId);
        if(i.isPresent())
            return i.get();
        return null;
    }
}
