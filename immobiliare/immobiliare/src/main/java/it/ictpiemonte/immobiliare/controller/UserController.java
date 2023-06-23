package it.ictpiemonte.immobiliare.controller;

import it.ictpiemonte.immobiliare.payload.request.SigninRequest;
import it.ictpiemonte.immobiliare.payload.request.SignupRequest;
import it.ictpiemonte.immobiliare.repository.UserRepository;
import it.ictpiemonte.immobiliare.service.TokenService;
import it.ictpiemonte.immobiliare.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository repo;

    @PostMapping("/signup")
    public ResponseEntity<?> save(@RequestBody @Valid SignupRequest request){
        return userService.save(request);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody @Valid SigninRequest request, HttpSession session){
        return userService.signin(request, session);
    }
}
