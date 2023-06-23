package it.ictpiemonte.immobiliare.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
public class TokenService {

    public static final String TOKEN_SECRET = "ItsIctPiemonte2023";
    public static final int EXPIRE_AFTER = 36000; // TEMPO ESPRESSO IN SECONDI

    public String createToken(int userId, String role){
        try{
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            String token = JWT.create()
                    .withClaim("userId", userId) // Claim personalizzato
                    .withClaim("role", role) // Claim personalizzato
                    .withIssuedAt(Instant.now()) // Claim iat
                    .withExpiresAt(Instant.now().plus(EXPIRE_AFTER, ChronoUnit.SECONDS)) // Claim exp
                    .sign(algorithm);
            return token;
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    public UserToken getUserIdFromToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            UserToken ut = new UserToken(jwt.getClaim("userId").asInt(), jwt.getClaim("role").asString());
            return ut;
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

}
