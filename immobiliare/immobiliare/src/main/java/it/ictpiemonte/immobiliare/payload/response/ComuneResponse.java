package it.ictpiemonte.immobiliare.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ComuneResponse {

    private int id;
    private String comune;
}
