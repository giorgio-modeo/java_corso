package it.ictpiemonte.immobiliare.repository;

import it.ictpiemonte.immobiliare.entity.Comune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComuneRepository extends JpaRepository<Comune, Integer> {

}
