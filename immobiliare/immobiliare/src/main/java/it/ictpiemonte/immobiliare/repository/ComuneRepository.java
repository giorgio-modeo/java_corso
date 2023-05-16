package it.ictpiemonte.immobiliare.repository;

import it.ictpiemonte.immobiliare.entity.Comune;
import it.ictpiemonte.immobiliare.entity.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComuneRepository extends JpaRepository<Comune, Integer> {
    boolean existsByComuneAndProvincia(String comune, Provincia provincia);
}