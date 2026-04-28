package fr.baptouk.pokerixe.backend.auth;

import fr.baptouk.pokerixe.backend.auth.dto.SignInRequest;
import fr.baptouk.pokerixe.backend.auth.dto.SignUpRequest;
import fr.baptouk.pokerixe.backend.user.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<User> signIn(@RequestBody SignInRequest request,
                                       HttpServletResponse response) {
        return ResponseEntity.ok(authService.signIn(request, response));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authService.signUp(request));
    }

    @PostMapping("/signout")
    public ResponseEntity<Void> signOut(HttpServletResponse response) {
        authService.signOut(response);
        return ResponseEntity.ok().build();
    }
}