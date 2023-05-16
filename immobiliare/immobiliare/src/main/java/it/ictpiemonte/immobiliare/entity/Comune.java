package it.ictpiemonte.immobiliare.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
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
}
