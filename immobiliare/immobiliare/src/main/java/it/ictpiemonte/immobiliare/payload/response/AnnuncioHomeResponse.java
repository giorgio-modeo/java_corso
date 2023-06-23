package it.ictpiemonte.immobiliare.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AnnuncioHomeResponse {

    private int id;
    private String titoloAnnuncio;
    private float prezzo;
    private String indirizzo;
    private String comune;
    private short metratura;

}
