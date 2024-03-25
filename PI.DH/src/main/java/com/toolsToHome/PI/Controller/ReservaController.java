package com.toolsToHome.PI.Controller;

import com.toolsToHome.PI.Exceptions.ResourceNotFoundException;
import com.toolsToHome.PI.Model.Reserva;
import com.toolsToHome.PI.Service.ReservaService;
import io.swagger.annotations.Api;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private ReservaService reservaService;
    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas()
    {
        return ResponseEntity.ok(reservaService.listarReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reserva>>buscarReserva(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Reserva>buscarReserva= reservaService.buscarReserva(id);
        if(buscarReserva.isPresent()){
            return ResponseEntity.ok(buscarReserva);
        }else throw new ResourceNotFoundException("No se encontro la reserva con ID :  "+ id);
    }

    @PostMapping("/create")
    public ResponseEntity<Reserva> guardarReserva(@RequestBody Reserva reserva)throws ResourceNotFoundException{
        Optional<Reserva>buscarReserva = reservaService.buscarReserva(reserva.getId());
        if(buscarReserva.isEmpty()){
            return ResponseEntity.ok(reservaService.guardarReserva(reserva));
        }else throw new ResourceNotFoundException("No pudo guardarse la reserva");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>eliminarReserva(@PathVariable Long id)throws ResourceNotFoundException{
        Optional<Reserva>buscarReserva = reservaService.buscarReserva(id);
        if(buscarReserva.isPresent()){
            reservaService.eliminarReserva(id);
            return ResponseEntity.ok("Reserva con id: "+ id +" eliminada");
        }else throw  new ResourceNotFoundException("No se encontro Reserva con id: "+id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> actualizarReserva(@RequestBody Reserva reserva) throws ResourceNotFoundException
    {
        Optional<Reserva> reservaRequest = reservaService.buscarReserva(reserva.getId());
        if(reservaRequest.isPresent())
        {
            reservaService.actualizarReserva(reserva);
            return ResponseEntity.ok("Se actualizó la reserva con el ID: "+ reserva.getId());
        } else {
            throw new ResourceNotFoundException("No se encontró la reserva con el ID: "+reserva.getId());
        }
    }
}
