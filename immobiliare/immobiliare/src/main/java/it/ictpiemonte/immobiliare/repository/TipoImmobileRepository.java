package it.ictpiemonte.immobiliare.repository;

import it.ictpiemonte.immobiliare.entity.TipoImmobile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoImmobileRepository extends JpaRepository<TipoImmobile, Integer> {

    Optional<TipoImmobile> findByTipoImmobile(String tipoImmobile);

    boolean existsByTipoImmobile(String tipoImmobile);

}
