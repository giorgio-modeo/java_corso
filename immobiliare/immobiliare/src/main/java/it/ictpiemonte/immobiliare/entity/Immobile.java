package it.ictpiemonte.immobiliare.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @EqualsAndHashCode
@Entity
public class Immobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @ManyToOne@JoinColumn(name="tipo_immobile",nullable = false)
    private TipoImmobile tipoImmobile;

    private byte numeroBagni;

    private byte numeroStanze;

    private short metratura;

    private boolean box;

    @Column(length = 3)
    private String classeEnergetica;

    @ManyToOne@JoinColumn(name="comune",nullable = false)
    private Comune comune;

    @ManyToOne@JoinColumn(name="contratto",nullable = false)
    private Contratto contratto;

    private float prezzo;

    @Column(nullable = false)
    private String indirizzo;
}
