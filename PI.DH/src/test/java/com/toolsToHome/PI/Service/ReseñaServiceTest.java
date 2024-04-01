package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.DTO.UserDTO;
import com.toolsToHome.PI.Model.Reseña;
import com.toolsToHome.PI.Model.Usuario;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ReseñaServiceTest {
    @Autowired
    private ReseñaService reseñaService;


    @Test
    @Order(1)
    public void guardarReseña(){
        Reseña reseñaAGuardar= new Reseña();
        reseñaService.guardarReseña(reseñaAGuardar);
        assertEquals(1L,reseñaAGuardar.getId());
    }


    @Test
    @Order(2)
    public void BuscarPorId(){
        Long idAbuscar= 1L;
        Optional<Reseña> reseñaABuscado= reseñaService.BuscarPorId(idAbuscar);
        assertNotNull(reseñaABuscado);
    }
    @Test
    @Order(3)
    public void listarReseñas(){
        List<Reseña> listarReseñas= reseñaService.listarReseñas();
        assertEquals(1,listarReseñas.size());
    }


    @Test
    @Order(4)
    public void actualizarReseña(){
        Long idABuscar= 1L;
        Optional<Reseña> reseña= reseñaService.BuscarPorId(idABuscar);
        if(reseña.isPresent()){
            Reseña reseñaAGuardar= new Reseña(idABuscar);
            reseñaService.actualizarReseña(reseñaAGuardar);
            Optional<Reseña> reseñaActualizado= reseñaService.BuscarPorId(1L);
            assertEquals("Bueno producto",reseñaActualizado.get().getId());

        }
    }

    @Test
    @Order(5)
    public void eliminarReseña(){
        Long idEliminar= 1L;
        reseñaService.eliminarReseña(idEliminar);
        Optional<Reseña> reseñaEliminado= reseñaService.BuscarPorId(idEliminar);
        assertFalse(reseñaEliminado.isPresent());
    }

}
