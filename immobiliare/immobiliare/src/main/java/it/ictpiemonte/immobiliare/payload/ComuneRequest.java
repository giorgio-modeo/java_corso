package it.ictpiemonte.immobiliare.payload;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ComuneRequest {

    @Digits(integer = 5,fraction = 0)
    private  int cap;

    @NotBlank @Size(min = 2,max = 50)
    private String comune; //nome

    @NotBlank @Size(min = 2,max = 2)
    private String siglaProvincia;
}
