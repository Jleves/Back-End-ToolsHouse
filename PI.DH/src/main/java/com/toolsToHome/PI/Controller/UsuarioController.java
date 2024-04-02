package com.toolsToHome.PI.Controller;

import com.toolsToHome.PI.DTO.UserDTO;
import com.toolsToHome.PI.Exceptions.ResourceNotFoundException;
import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Model.Usuario;
import com.toolsToHome.PI.Model.UsuarioRole;
import com.toolsToHome.PI.Service.UsuarioService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/User")
public class UsuarioController {
    private static final Logger logger = Logger.getLogger(HerramientaController.class);
    private UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> listarHerramientas(){
        logger.info("Get Usuario");
        return ResponseEntity.ok(usuarioService.listarTodos());
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

    @PutMapping("/updateRole/{id}/usuarioRole")
    public ResponseEntity<?> updateRole(@PathVariable Long id,@RequestBody Usuario usuarioRole) {
        try {
            logger.info("id usuario:  "+ id+ "Rol:  "+ usuarioRole);
            usuarioService.updateRole(id, usuarioRole);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<UserDTO> buscarUsuario = usuarioService.buscarPorId(id);
        if(buscarUsuario.isPresent()){
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.ok("Usuario Eliminada");
        } else {
            throw new ResourceNotFoundException("No se encontró el usuario con el ID: " + id);
        }
    }




    /* ANGEL */





    /* FAVS */

    @PostMapping("/{id}/favs/{herramientaId}")
    public ResponseEntity<String> agregarHerramientaFavorita(@PathVariable Long id, @PathVariable Long herramientaId) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String email = userDetails.getUsername();

                if (usuarioService.isUsuarioCorreo(email, id)) {
                    usuarioService.agregarHerramientaFavorita(id, herramientaId);
                    return ResponseEntity.ok("Herramienta agregada a favoritos");
                } else {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acceso denegado");
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no autenticado");
            }
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/{id}/favs/{herramientaId}")
    public ResponseEntity<String> eliminarHerramientaFavorita(@PathVariable Long id, @PathVariable Long herramientaId)
    {
        try
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String email = userDetails.getUsername();

                if (usuarioService.isUsuarioCorreo(email, id)) {
                    usuarioService.eliminarHerramientaFavorita(id, herramientaId);
                    return ResponseEntity.ok("Herramienta eliminada de favoritos");
                } else {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acceso no permitido");
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autenticado");
            }
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}/favs")
    public ResponseEntity<List<Herramienta>> listarHerramientasFavoritas(@PathVariable Long id) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String email = userDetails.getUsername();

                if (usuarioService.isUsuarioCorreo(email, id)) {
                    List<Herramienta> herramientasFavoritas = usuarioService.getHerramientasFavoritas(id);
                    return ResponseEntity.ok(herramientasFavoritas);
                } else {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}