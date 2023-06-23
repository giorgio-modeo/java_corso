package it.ictpiemonte.immobiliare.repository;

import it.ictpiemonte.immobiliare.entity.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinciaRepository extends JpaRepository<Provincia, String> {

    List<Provincia> findAllByOrderByProvinciaAsc(); // select * from provincia order by provincia ASC

}
