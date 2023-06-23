package it.ictpiemonte.immobiliare.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AnnuncioDetailResponse {

    private int id;
    private String titoloAnnuncio;
    private String testoAnnuncio;
    private LocalDateTime dataAggiornamento;

    private short metratura;
    private byte numeroBagni;
    private byte numeroStanze;
    private String classeEnergetica;
    private boolean box;
    private String nomeComune;
    private String siglaProvincia;
    private String indirizzo;
    private String tipoContratto;
    private float prezzo;
}
