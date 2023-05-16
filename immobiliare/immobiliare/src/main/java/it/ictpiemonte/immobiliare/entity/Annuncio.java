package it.ictpiemonte.immobiliare.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class Annuncio {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private AnnuncioId annuncioId;
    @Column(nullable = false)
    private  String testoAnnuncio;

    @Column(nullable = false,length = 45)
    private  String titoloAnnuncio;

    private  boolean visibile = true;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCreazione;

    @UpdateTimestamp //funziona solo utilizzando il metodo 'save' di JPA
    private LocalDateTime dataAggiornamento;


    public Annuncio(AnnuncioId annuncioId, String testoAnnuncio, String titoloAnnuncio) {
        this.annuncioId = annuncioId;
        this.testoAnnuncio = testoAnnuncio;
        this.titoloAnnuncio = titoloAnnuncio;
    }
}
