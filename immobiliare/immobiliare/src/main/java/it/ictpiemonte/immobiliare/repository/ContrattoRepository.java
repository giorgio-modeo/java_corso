package it.ictpiemonte.immobiliare.repository;

import it.ictpiemonte.immobiliare.entity.Contratto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContrattoRepository extends JpaRepository<Contratto, Integer> {
}
