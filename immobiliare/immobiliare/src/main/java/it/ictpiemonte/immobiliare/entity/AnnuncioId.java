package it.ictpiemonte.immobiliare.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.io.Serializable;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
@Embeddable
public class AnnuncioId implements Serializable {
    @OneToOne
    @JoinColumn(name = "id")
    @EqualsAndHashCode.Include
    private Immobile immobile;



}
