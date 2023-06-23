package it.ictpiemonte.immobiliare.service;

import it.ictpiemonte.immobiliare.entity.Role;
import it.ictpiemonte.immobiliare.entity.User;
import it.ictpiemonte.immobiliare.payload.request.SigninRequest;
import it.ictpiemonte.immobiliare.payload.request.SignupRequest;
import it.ictpiemonte.immobiliare.payload.response.AuthResponse;
import it.ictpiemonte.immobiliare.repository.RoleRepository;
import it.ictpiemonte.immobiliare.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final ApplicationContext context;

    public ResponseEntity<?> save(SignupRequest request){
        return new ResponseEntity(userRepository.save(fromRequestToEntity(request)), HttpStatus.CREATED);
    }

    private User fromRequestToEntity(SignupRequest request){
        User u = new User();
        Optional<Role> role = roleRepository.findByRole("ROLE_USER");
        if(role.isPresent()) {
            String encryptedPassword = new DigestUtils("SHA3-256").digestAsHex(request.getPassword());
            return new User(request.getUsername(), encryptedPassword, request.getEmail(), role.get());
        }
        return u;
    }


    public ResponseEntity<?> signin(SigninRequest request, HttpSession session){
        Optional<User> u = userRepository.findByUsernameAndPassword(request.getUsername(), new DigestUtils("SHA3-256").digestAsHex(request.getPassword()));
        if(u.isPresent())
            if(!u.get().isEnabled())
                return new ResponseEntity("User disabled", HttpStatus.UNAUTHORIZED);
            else {
                String token = tokenService.createToken(u.get().getId(), u.get().getRole().getRole());
                AuthResponse authenticadedUser = new AuthResponse(u.get().getId(), u.get().getUsername(), u.get().getRole().getRole(), token);
                session.setAttribute("userRole", u.get().getRole().getRole());
                return new ResponseEntity(authenticadedUser, HttpStatus.OK);
            }
        else
            return new ResponseEntity("Username o password errati", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> changePassword(int userId, String newPassword, String newPasswordConfirm){
        if(!newPassword.equals(newPasswordConfirm))
            return new ResponseEntity("Le due password non coincidono", HttpStatus.BAD_REQUEST);

        userRepository.aggiornaPassword(userId, new DigestUtils("SHA3-256").digestAsHex(newPassword));
        return new ResponseEntity("Password aggiornata", HttpStatus.OK);

    }


}
