package it.ictpiemonte.immobiliare.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignupRequest {

    @NotBlank @Size(min=4, max=20)
    private String username;

    @NotBlank @Size(min=6)
    private String password;

    @NotBlank @Email
    private String email;
}
