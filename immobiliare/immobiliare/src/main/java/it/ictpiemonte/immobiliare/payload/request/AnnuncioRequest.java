package it.ictpiemonte.immobiliare.payload.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AnnuncioRequest {

    @Min(1)
    private int immobileId;
    @NotBlank @Size(max=45, min=5)
    private String title;
    @NotBlank @Size(max=255, min=10)
    private String annuncio;
}
