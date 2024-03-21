package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Model.Imagen;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ImagenServiceTest {
    @Autowired
    private ImagenService imagenService;

    @Test
    @Order(1)
    public void guardarImagen(){
        Imagen imagenAGuardar= new Imagen();
        imagenService.guardarImagen(imagenAGuardar);
        assertEquals(1L,imagenAGuardar.getId());
    }

    @Test
    @Order(2)
    public void buscarPorIdTest(){
        Long idAbuscar= 1L;
        Optional<Imagen> imagenABuscado= imagenService.buscarPorId(idAbuscar);
        assertNotNull(imagenABuscado);
    }

    @Test
    @Order(3)
    public void actualizarImagen(){
        Long idABuscar= 1L;
        Optional<Imagen> imagen= imagenService.buscarPorId(idABuscar);
        if(imagen.isPresent()){
            Imagen imagenAGuardar= new Imagen(idABuscar);
            imagenService.actualizarImagen(imagenAGuardar);
            Optional<Imagen> imagenActualizado= imagenService.buscarPorId(1L);
            assertEquals("Ima",imagenActualizado.get().getId());

        }
    }

    @Test
    @Order(4)
    public void eliminarImagen(){
        Long idEliminar= 1L;
        imagenService.eliminarImagen(idEliminar);
        Optional<Imagen> imagenEliminado= imagenService.buscarPorId(idEliminar);
        assertFalse(imagenEliminado.isPresent());
    }

}
//actualizar