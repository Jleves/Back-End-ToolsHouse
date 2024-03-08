package com.toolsToHome.PI.Controller;

import com.toolsToHome.PI.DTO.UserDTO;
import com.toolsToHome.PI.Exceptions.ResourceNotFoundException;
import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Model.Usuario;
import com.toolsToHome.PI.Model.UsuarioRole;
import com.toolsToHome.PI.Repository.UsuarioRepository;
import com.toolsToHome.PI.Service.UsuarioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UsuarioController {
    private static final Logger logger = Logger.getLogger(HerramientaController.class);
    private UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioService usuarioService,
                             UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listarUsuarios(){
        logger.info("Get Usuario");
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<UserDTO> usuarioRequest = usuarioService.findUserById(id);
        if (usuarioRequest.isPresent()) {
            UserDTO userDTO = usuarioRequest.get();
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /* VER */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRole(@PathVariable Long id, @RequestBody UsuarioRole newRole) {
        try {
            usuarioService.updateRole(id, newRole);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<UserDTO> buscarUsuario = usuarioService.findUserById(id);
        if(buscarUsuario.isPresent()){
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.ok("Usuario Eliminada");
        } else {
            throw new ResourceNotFoundException("No se encontró el usuario con el ID: " + id);
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUserProfile(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        Optional<UserDTO> userDTOOptional = usuarioService.findUserByEmail(username);
        if (userDTOOptional.isPresent()) {
            return ResponseEntity.ok(userDTOOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /* Así funciona:
    1. El método getUserProfile maneja las solicitudes GET para obtener los datos del perfil del usuario autenticado
    2. El @AuthenticationPrincipal obtiene los detalles del usuario autenticado directamente del Security Context
    3. Se obtiene el nombre de usuario del usuario autenticado y se usa el mismo para buscar qué usuario es según
    el nombre de usuario (correo) proporcionado, usando el UserService
    4. Se devuelve el perfil del usuario encontrado (pero un DTO del mismo, para ocultar detalles como la contraseña)
    */


}
