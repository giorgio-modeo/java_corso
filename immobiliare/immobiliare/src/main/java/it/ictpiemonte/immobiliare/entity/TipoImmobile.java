package it.ictpiemonte.immobiliare.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class TipoImmobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    public TipoImmobile(String tipoImmobile) {
        this.tipoImmobile = tipoImmobile;
    }

    @Column(length = 30,nullable = false,unique = true)
    private String tipoImmobile;


}
