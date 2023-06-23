package it.ictpiemonte.immobiliare.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AuthResponse {

    private int id;
    private String username;
    private String role;
    private String token;
}
