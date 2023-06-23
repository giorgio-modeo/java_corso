package it.ictpiemonte.immobiliare.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @AllArgsConstructor
public class Provincia {

    @Id
    @Column(length = 2)
    @EqualsAndHashCode.Include
    private String id;

    @Column(length = 50, nullable = false, unique = true)
    private String provincia;
}
