package it.ictpiemonte.immobiliare.repository;

import it.ictpiemonte.immobiliare.entity.Annuncio;
import it.ictpiemonte.immobiliare.entity.AnnuncioId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnuncioRepository extends JpaRepository<Annuncio, AnnuncioId> {

}
