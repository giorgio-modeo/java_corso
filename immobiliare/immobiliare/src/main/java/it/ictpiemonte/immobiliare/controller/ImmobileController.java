package it.ictpiemonte.immobiliare.controller;

import it.ictpiemonte.immobiliare.payload.request.ImmobileRequest;
import it.ictpiemonte.immobiliare.service.ImmobileService;
import it.ictpiemonte.immobiliare.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("immobile")
@RequiredArgsConstructor
public class ImmobileController {

    private final ImmobileService immobileService;
    private final UserService userService;


    @PostMapping
    public ResponseEntity<?> addImmobile(@RequestBody @Valid ImmobileRequest request){
        return immobileService.addImmobile(request);
    }
}
