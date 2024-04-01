package com.toolsToHome.PI.Auth;

import com.toolsToHome.PI.Exceptions.ResourceNotFoundException;
import com.toolsToHome.PI.Repository.UsuarioRepository;
import com.toolsToHome.PI.Security.JwtUtil;
import com.toolsToHome.PI.Service.UsuarioService;
import com.toolsToHome.PI.email.HttpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){

        return ResponseEntity.ok(authService.login(loginRequest));
    }
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){

        return ResponseEntity.ok(authService.register(registerRequest));

    }

    @GetMapping("/check")
    public ModelAndView confirmUserAccount(@RequestParam("token") String token) throws ResourceNotFoundException {
        String username = jwtUtil.extractUserName(token);
        UserDetails userDetails = usuarioService.loadUserByUsername(username);
        boolean verificar = false;
        if (jwtUtil.validateToken(token, userDetails))
            verificar = true;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Confirmacion"); // Nombre de la plantilla HTML
        modelAndView.addObject("verificar", verificar); // Pasar datos a la plantilla si es necesario
        modelAndView.addObject("timeStamp", LocalDateTime.now().toString()); // Ejemplo de pasar datos a la plantilla

        return modelAndView;
    }
}
