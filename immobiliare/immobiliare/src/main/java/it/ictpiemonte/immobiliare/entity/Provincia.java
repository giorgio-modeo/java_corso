package it.ictpiemonte.immobiliare.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @AllArgsConstructor
public class Provincia {
    /*
        @nome_annotazzioni
     */
    @Id
    @Column(length = 3)
    private String id;

    @Column(length = 50,nullable = false,unique = true)
    private String provincia;

}
