package it.ictpiemonte.immobiliare.repository;

import it.ictpiemonte.immobiliare.entity.Immobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImmobileRepository extends JpaRepository<Immobile,Integer> {
}
