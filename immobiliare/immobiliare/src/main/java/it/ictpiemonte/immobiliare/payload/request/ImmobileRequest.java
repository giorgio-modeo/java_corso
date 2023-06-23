package it.ictpiemonte.immobiliare.payload.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ImmobileRequest {

    @Min(1)
    private int tipoImmobile;

    @Min(1)
    private short metratura;

    private byte numeroBagni;

    @Min(1)
    private byte numeroStanze;

    private String classeEnergetica;

    private boolean box;

    @Min(1)
    private int comune;

    private float prezzo;

    @NotBlank @Size(max=255)
    private String indirizzo;

    @Min(1)
    private int contratto;

}
