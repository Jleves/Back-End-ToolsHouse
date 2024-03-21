package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.Model.Caracteristicas;
import com.toolsToHome.PI.Model.Categoria;
import com.toolsToHome.PI.Model.Herramienta;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriaServiceTest {
    @Autowired
    private CategoriaService categoriaService;

    @Test
    @Order(1)
    public void guardarCatergoria(){
        Categoria categoriaAGuardar= new Categoria();
        categoriaService.guardarCategoria(categoriaAGuardar);
        assertEquals(1L,categoriaAGuardar.getId());
    }

    @Test
    @Order(2)
    public void buscarPorIdTest(){
        Long idAbuscar= 1L;
        Optional<Categoria> categoriaABuscado= categoriaService.buscarPorId(idAbuscar);
        assertNotNull(categoriaABuscado);
    }

    @Test
    @Order(3)
    public void buscarPorCategoriaTest(){
        String categoriaAbuscar= "string";
        Optional<Categoria> categoriaABuscado= categoriaService.buscarPorCategoria(categoriaAbuscar);
        assertNotNull(categoriaABuscado);
    }

    @Test
    @Order(4)
    public void eliminarCategoria(){
        Long idEliminar= 1L;
        categoriaService.eliminarCategoria(idEliminar);
        Optional<Categoria> categoriaEliminado= categoriaService.buscarPorId(idEliminar);
        assertFalse(categoriaEliminado.isPresent());
    }

    @Test
    @Order(5)
    public void actualizarCategoria(){
        Long idABuscar= 1L;
        Optional<Categoria> categoria= categoriaService.buscarPorId(idABuscar);
        if(categoria.isPresent()){
            Categoria categoriaAGuardar= new Categoria(idABuscar);
            categoriaService.actualizarCategoria(categoriaAGuardar);
            Optional<Categoria> categoriaActualizado= categoriaService.buscarPorId(1L);
            assertEquals("categoria",categoriaActualizado.get().getId());

        }
    }

    @Test
    @Order(6)
    public void listarTodos(){
        List<Categoria> listaCategoria= categoriaService.listarTodos();
        assertEquals(1,listaCategoria.size());
    }

}
