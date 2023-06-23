package it.ictpiemonte.immobiliare.repository;

import it.ictpiemonte.immobiliare.entity.Annuncio;
import it.ictpiemonte.immobiliare.entity.AnnuncioId;
import it.ictpiemonte.immobiliare.payload.response.AnnuncioDetailResponse;
import it.ictpiemonte.immobiliare.payload.response.AnnuncioHomeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnnuncioRepository extends JpaRepository<Annuncio, AnnuncioId> {

    @Query(value="SELECT new it.ictpiemonte.immobiliare.payload.response.AnnuncioHomeResponse(" +
            "a.annuncioId.immobile.id AS id, " +
            "a.titoloAnnuncio, " +
            "a.annuncioId.immobile.prezzo AS prezzo, " +
            "a.annuncioId.immobile.indirizzo AS indirizzo, " +
            "a.annuncioId.immobile.comune.comune AS comune, " +
            "a.annuncioId.immobile.metratura as metratura" +
            ") FROM Annuncio a " +
            "WHERE a.annuncioId.immobile.comune.provincia.id = :provinciaId " +
            "ORDER BY a.dataAggiornamento DESC")
    Page<AnnuncioHomeResponse> getAnnunciHomePage(Pageable pageable, @Param("provinciaId") String provinciaId);

    @Query(value="SELECT new it.ictpiemonte.immobiliare.payload.response.AnnuncioDetailResponse(" +
            "a.annuncioId.immobile.id, " +
            "a.titoloAnnuncio, " +
            "a.testoAnnuncio, " +
            "a.dataAggiornamento," +
            "a.annuncioId.immobile.metratura, " +
            "a.annuncioId.immobile.numeroBagni, " +
            "a.annuncioId.immobile.numeroStanze, " +
            "a.annuncioId.immobile.classeEnergetica, " +
            "a.annuncioId.immobile.box, " +
            "a.annuncioId.immobile.comune.comune, " +
            "a.annuncioId.immobile.comune.provincia.id, " +
            "a.annuncioId.immobile.indirizzo, " +
            "a.annuncioId.immobile.contratto.tipoContratto, " +
            "a.annuncioId.immobile.prezzo" +
            ") FROM Annuncio a WHERE a.annuncioId.immobile.id = :id AND a.visible = true")
    AnnuncioDetailResponse getAnnuncioDetail(@Param("id") int id);
}
