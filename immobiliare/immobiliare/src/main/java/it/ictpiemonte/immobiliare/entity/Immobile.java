package it.ictpiemonte.immobiliare.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode
public class Immobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @ManyToOne
    @JoinColumn(name = "tipo_immobile", nullable = false)
    private TipoImmobile tipoImmobile;

    private short metratura;

    private byte numeroBagni;

    private byte numeroStanze;

    @Column(length = 3)
    private String classeEnergetica;

    private boolean box;

    @ManyToOne
    @JoinColumn(name="comune", nullable = false)
    private Comune comune;

    @ManyToOne
    @JoinColumn(name="contratto", nullable = false)
    private Contratto contratto;

    private float prezzo;

    @Column(nullable = false)
    private String indirizzo;

    public Immobile(TipoImmobile tipoImmobile, short metratura, byte numeroBagni, byte numeroStanze, String classeEnergetica, boolean box, Comune comune, Contratto contratto, float prezzo, String indirizzo) {
        this.tipoImmobile = tipoImmobile;
        this.metratura = metratura;
        this.numeroBagni = numeroBagni;
        this.numeroStanze = numeroStanze;
        this.classeEnergetica = classeEnergetica;
        this.box = box;
        this.comune = comune;
        this.contratto = contratto;
        this.prezzo = prezzo;
        this.indirizzo = indirizzo;
    }
}
