package com.toolsToHome.PI.Controller;

import com.toolsToHome.PI.Exceptions.ResourceNotFoundException;
import com.toolsToHome.PI.Model.Reserva;
import com.toolsToHome.PI.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Reservas")
public class ReservaController {

    private ReservaService reservaService;
    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }


    @PostMapping
    public ResponseEntity<Reserva> guardarReserva(@RequestBody Reserva reserva)throws ResourceNotFoundException{
        Optional<Reserva>buscarReserva = reservaService.buscarReserva(reserva.getId());
        if(buscarReserva.isEmpty()){
            return ResponseEntity.ok(reservaService.guardarReserva(reserva));
        }else throw new ResourceNotFoundException("No pudo guardarse la reserva");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reserva>>buscarReserva(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Reserva>buscarReserva= reservaService.buscarReserva(id);
        if(buscarReserva.isPresent()){
            return ResponseEntity.ok(buscarReserva);
        }else throw new ResourceNotFoundException("No se encontro la reserva con ID :  "+ id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminarReserva(@PathVariable Long id)throws ResourceNotFoundException{
        Optional<Reserva>buscarReserva = reservaService.buscarReserva(id);
        if(buscarReserva.isPresent()){
            reservaService.eliminarReserva(id);
            return ResponseEntity.ok("Reserva con id: "+ id +" eliminada");
        }else throw  new ResourceNotFoundException("No se encontro Reserva con id: "+id);








    }



}
