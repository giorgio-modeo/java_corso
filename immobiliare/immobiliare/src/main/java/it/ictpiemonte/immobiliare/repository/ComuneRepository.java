package it.ictpiemonte.immobiliare.repository;

import it.ictpiemonte.immobiliare.entity.Comune;
import it.ictpiemonte.immobiliare.entity.Provincia;
import it.ictpiemonte.immobiliare.payload.response.ComuneResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ComuneRepository extends JpaRepository<Comune, Integer> {

    boolean existsByComuneAndProvincia(String comune, Provincia provincia);

    // JPQL = Javax/Jakarta Persistent Query Language
    @Query(value="SELECT new it.ictpiemonte.immobiliare.payload.response.ComuneResponse(" +
            "c.id, " +
            "c.comune) " +
            "FROM Comune c " +
            "WHERE c.provincia.id = :provinciaId " +
            "ORDER BY comune"
    )
    List<ComuneResponse> getComuni(@Param("provinciaId") String provinciaId);


    boolean existsByProvinciaIdAndComuneAndIdNot(String provinciaId, String nomeComune, int comuneId);
}
