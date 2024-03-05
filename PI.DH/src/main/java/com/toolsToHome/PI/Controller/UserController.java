package com.toolsToHome.PI.Controller;

import com.toolsToHome.PI.DTO.UserDTO;
import com.toolsToHome.PI.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUserProfile(@AuthenticationPrincipal UserDetails userDetails)
    {
        String username = userDetails.getUsername();
        UserDTO userDTO = userService.getUserByUsername(username);
        return ResponseEntity.ok(userDTO);
    }

    /* Así funciona:
    1. El método getUserProfile maneja las solicitudes GET para obtener los datos del perfil del usuario autenticado
    2. El @AuthenticationPrincipal obtiene los detalles del usuario autenticado directamente del Security Context
    3. Se obtiene el nombre de usuario del usuario autenticado y se usa el mismo para buscar qué usuario es según
    el nombre de usuario (correo) proporcionado, usando el UserService
    4. Se devuelve el perfil del usuario encontrado (pero un DTO del mismo, para ocultar detalles como la contraseña)
    */
}
