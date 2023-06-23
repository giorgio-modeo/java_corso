package it.ictpiemonte.immobiliare.controller;

import it.ictpiemonte.immobiliare.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/change-pwd/{userId}")
    public ResponseEntity<?> changePassword(@PathVariable int userId, @RequestParam String newPassword, @RequestParam String newPasswordConfirm){
        return userService.changePassword(userId, newPassword, newPasswordConfirm);
    }
}
