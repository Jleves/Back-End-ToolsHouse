package com.toolsToHome.PI.Service;


import com.toolsToHome.PI.Model.Herramienta;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest

public class HerramientaServiceTest {

    @Autowired
    private HerramientaService herramientaService;


    @Test
    @Order(1)
    public void guardarHerramienta(){
        Herramienta herramientaAGuardar= new Herramienta(5L,5L,"Sierra");
        herramientaService.guardarHerramienta(herramientaAGuardar);
        assertEquals(1L,herramientaAGuardar.getId());
    }

    @Test
    @Order(2)
    public void buscarPorIdTest(){
        Long idAbuscar= 1L;
        Optional<Herramienta> herramientaABuscado= herramientaService.buscarPorId(idAbuscar);
        assertNotNull(herramientaABuscado);
    }

    @Test
    @Order(3)
    public void buscarPorNombreTest(){
        String nombreABuscar= "Sierra";
        Optional<Herramienta> herramientaABuscado= herramientaService.buscarPorNombre(nombreABuscar);
        assertNotNull(herramientaABuscado);
    }

    @Test
    @Order(4)
    public void eliminarHerramienta(){
        Long idEliminar= 1L;
        herramientaService.eliminarHerramienta(idEliminar);
        Optional<Herramienta> herramientaEliminado= herramientaService.buscarPorId(idEliminar);
        assertFalse(herramientaEliminado.isPresent());
    }

    @Test
    @Order(5)
    public void actualizarHerramienta(){
        Long idABuscar= 1L;
        Optional<Herramienta> herramienta= herramientaService.buscarPorId(idABuscar);
        if(herramienta.isPresent()){
            Herramienta herramientaAGuardar=  herramienta;
            herramientaService.actualizarHerramienta(herramientaAGuardar);
            Optional<Herramienta> herramientaActualizado= herramientaService.buscarPorId(1L);
            assertEquals("Martillo",herramientaActualizado.get().getNombre());

        }
    }

    @Test
    @Order(6)
    public void listarTodos(){
        List<Herramienta> listaHerramienta= herramientaService.listarTodos();
        assertEquals(1,listaHerramienta.size());
    }

}
