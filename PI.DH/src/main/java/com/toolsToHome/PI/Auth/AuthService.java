package com.toolsToHome.PI.Auth;

import com.toolsToHome.PI.Model.Usuario;
import com.toolsToHome.PI.Model.UsuarioRole;
import com.toolsToHome.PI.Repository.UsuarioRepository;
import com.toolsToHome.PI.Security.JwtUtil;
import com.toolsToHome.PI.Security.PasswordEncoder;
import com.toolsToHome.PI.email.Confirmation;
import com.toolsToHome.PI.email.EmailServices.EmailServiceImpl;
import com.toolsToHome.PI.email.repositoryEmail.ConfirmationRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor

public class AuthService {

    private final UsuarioRepository usuarioRepository;  //Para buscar el usuario
    private final JwtUtil jwtUtil;  //Para generar el token
    private final PasswordEncoder passwordEncoder; //Encriptar el TOKEN
    private final ConfirmationRepository confirmationRepository;
    private final EmailServiceImpl emailService;


    @Autowired
    private final AuthenticationManager authenticationManager; // Para que se autentique
    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        Usuario usuario = usuarioRepository.findByEmail(loginRequest.getUsername()).orElseThrow();
        String token = jwtUtil.generateToken(usuario);
        return AuthResponse.builder()
                .token(token)
                .build();
    }


    public AuthResponse register(RegisterRequest registerRequest) {
        Usuario user = Usuario.builder()
                .nombre(registerRequest.getNombre())
                .apellido(registerRequest.getApellido())
                .password(passwordEncoder.bCryptPasswordEncoder().encode(registerRequest.getPassword()))
                .email(registerRequest.getEmail())
                .ciudad(registerRequest.getCiudad())
                .usuarioRole(UsuarioRole.USER)
                .confirmacion(false)
                .build();

        String token = jwtUtil.generateToken(user);
        Confirmation confirmation = new Confirmation(user,token);

        emailService.sendHtmlEmail(user.getNombre(),user.getEmail(),confirmation.getToken());
        usuarioRepository.save(user);
        confirmationRepository.save(confirmation);
        return AuthResponse.builder()
                .token(token)   //Tenemos que devolver el token que se genera en jwtUtil
                .build();
    }
}
