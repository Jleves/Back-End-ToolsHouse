package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.DTO.UserDTO;
import com.toolsToHome.PI.Model.Reserva;
import com.toolsToHome.PI.Model.Usuario;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaServiceTest {
    @Autowired
    private ReservaService reservaService;


    @Test
    @Order(1)
    public void guardarReserva(){
        Reserva reservaAGuardar= new Reserva(7L,"Juan",2L);
        reservaService.guardarReserva(reservaAGuardar);
        assertEquals(1L,reservaAGuardar.getId());
    }



    @Test
    @Order(2)
    public void BuscarPorId(){
        Long idAbuscar= 1L;
        Optional<Reserva> reservaABuscado= reservaService.BuscarPorId(idAbuscar);
        assertNotNull(reservaABuscado);
    }
    @Test
    @Order(3)
    public void listarReservas(){
        List<Reserva> listarReservas= reservaService.listarReservas();
        assertEquals(1,listarReservas.size());
    }


    @Test
    @Order(4)
    public void actualizarReserva(){
        Long idABuscar= 1L;
        Optional<Reserva> reserva= reservaService.BuscarPorId(idABuscar);
        if(reserva.isPresent()){
            Reserva reservaAGuardar= new Reserva(idABuscar);
            reservaService.actualizarReserva(reservaAGuardar);
            Optional<Reserva> reservaActualizado= reservaService.BuscarPorId(1L);
            assertEquals("fecha",reservaActualizado.get().getId());

        }
    }

    @Test
    @Order(5)
    public void eliminarReserva(){
        Long idEliminar= 1L;
        reservaService.eliminarReserva(idEliminar);
        Optional<Reserva> reservaEliminado= reservaService.BuscarPorId(idEliminar);
        assertFalse(reservaEliminado.isPresent());
    }

}
