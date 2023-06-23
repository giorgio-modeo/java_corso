package it.ictpiemonte.immobiliare.config;

import it.ictpiemonte.immobiliare.service.TokenService;
import it.ictpiemonte.immobiliare.service.UserToken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

@Configuration
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {

    TokenService tokenService = new TokenService();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        String token = request.getHeader("Authorization");
        log.info("INSIDE PRE handle interceptor: "+request+" | "+request.getMethod()+" | "+request.getRequestURI());

        try{
            UserToken ut = tokenService.getUserIdFromToken(token);
            if(ut != null){
                request.setAttribute("USER-ID", Integer.toString(ut.getId()));
                request.setAttribute("USER-ROLE", ut.getRole());
                return true;
            }
        } catch(Exception e){
            log.error("An error occurred while decoding token: "+e.getMessage());
        }
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return false;
    }
}
