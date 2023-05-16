package it.ictpiemonte.immobiliare.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @EqualsAndHashCode @NoArgsConstructor
public class Comune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private int cap;

    @Column(length = 34,nullable = false)
    private String comune;

    @ManyToOne
    @JoinColumn(name = "provincia")
    private Provincia provincia;

    public Comune(int cap, String comune, Provincia provincia) {
        this.cap = cap;
        this.comune = comune;
        this.provincia = provincia;
    }
}
