package it.ictpiemonte.immobiliare.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode
public class TipoImmobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(length = 25, nullable = false, unique = true)
    private String tipoImmobile;

    public TipoImmobile(String tipoImmobile) {
        this.tipoImmobile = tipoImmobile;
    }

    public TipoImmobile(int id) {
        this.id = id;
    }
}
