package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.DTO.UserDTO;
import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Model.Usuario;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServiceTest {
    @Autowired
    private UsuarioService usuarioService;


    @Test
    @Order(1)
    public void guardarUsuario(){
        Usuario usuarioAGuardar= new Usuario(7L,"Juan","Martinez");
        usuarioService.guardarUsuario(usuarioAGuardar);
        assertEquals(1L,usuarioAGuardar.getId());
    }



    @Test
    @Order(2)
    public void buscarPorIdTest(){
        Long idAbuscar= 1L;
        Optional<UserDTO> usuarioABuscado= usuarioService.buscarPorId(idAbuscar);
        assertNotNull(usuarioABuscado);
    }
    @Test
    @Order(3)
    public void listarTodos(){
        List<Usuario> listaUsuario= usuarioService.listarTodos();
        assertEquals(1,listaUsuario.size());
    }


    @Test
    @Order(4)
    public void actualizarUsuario(){
        Long idABuscar= 1L;
        Optional<UserDTO> usuario= usuarioService.buscarPorId(idABuscar);
        if(usuario.isPresent()){
            Usuario usuarioAGuardar= new Usuario(idABuscar);
            usuarioService.actualizarUsuario(usuarioAGuardar);
            Optional<UserDTO> usuarioActualizado= usuarioService.buscarPorId(1L);
            assertEquals("Martin",usuarioActualizado.get().getNombre());

        }
    }

    @Test
    @Order(5)
    public void eliminarUsuario(){
        Long idEliminar= 1L;
        usuarioService.eliminarUsuario(idEliminar);
        Optional<UserDTO> usuarioEliminado= usuarioService.buscarPorId(idEliminar);
        assertFalse(usuarioEliminado.isPresent());
    }

}
