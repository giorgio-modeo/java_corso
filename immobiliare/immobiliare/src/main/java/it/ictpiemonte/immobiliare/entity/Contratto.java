package it.ictpiemonte.immobiliare.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode
public class Contratto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(length = 50, nullable = false, unique = true)
    private String tipoContratto;

    public Contratto(String tipoContratto) {
        this.tipoContratto = tipoContratto;
    }

    public Contratto(int id) {
        this.id = id;
    }
}
