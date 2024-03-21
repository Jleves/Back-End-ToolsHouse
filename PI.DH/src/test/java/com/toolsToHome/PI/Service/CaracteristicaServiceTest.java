package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.Model.Caracteristicas;
import com.toolsToHome.PI.Model.Herramienta;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CaracteristicaServiceTest {
    @Autowired
    private CaracteristicaService caracteristicaService;

    @Test
    @Order(1)
    public void guardarCaracteristica(){
        Caracteristicas caracteristicaAGuardar= new Caracteristicas();
        caracteristicaService.guardarCaracteristica(caracteristicaAGuardar);
        assertEquals(1L,caracteristicaAGuardar.getId());
    }

    @Test
    @Order(2)
    public void buscarPorIdTest(){
        Long idAbuscar= 1L;
        Optional<Caracteristicas> caracteristicaABuscado= caracteristicaService.buscarPorId(idAbuscar);
        assertNotNull(caracteristicaABuscado);
    }

    @Test
    @Order(2)
    public void buscarPorCaracteristicasTest(){
        String caracteristicasAbuscar= "string";
        Optional<Caracteristicas> caracteristicaABuscado= caracteristicaService.buscarPorCaracteristicas(caracteristicasAbuscar);
        assertNotNull(caracteristicaABuscado);
    }

    @Test
    @Order(4)
    public void eliminarCaracteristicas(){
        Long idEliminar= 1L;
        caracteristicaService.eliminarCaracteristicas(idEliminar);
        Optional<Caracteristicas> caracteristicaEliminado= caracteristicaService.buscarPorId(idEliminar);
        assertFalse(caracteristicaEliminado.isPresent());
    }

    @Test
    @Order(5)
    public void actualizarCaracteristicas(){
        Long idABuscar= 1L;
        Optional<Caracteristicas> caracteristicas= caracteristicaService.buscarPorId(idABuscar);
        if(caracteristicas.isPresent()){
            Caracteristicas caracteristicasAGuardar= new Caracteristicas(idABuscar);
            caracteristicaService.actualizarCaracteristicas(caracteristicasAGuardar);
            Optional<Caracteristicas> caracteristicaActualizado= caracteristicaService.buscarPorId(1L);
            assertEquals("caract",caracteristicaActualizado.get().getId());

        }
    }

    @Test
    @Order(6)
    public void listarTodos(){
        List<Caracteristicas> listaCaracteristica= caracteristicaService.listarTodos();
        assertEquals(1,listaCaracteristica.size());
    }

}
