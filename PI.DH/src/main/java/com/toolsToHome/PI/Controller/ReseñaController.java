package com.toolsToHome.PI.Controller;

import com.toolsToHome.PI.Exceptions.ResourceNotFoundException;
import com.toolsToHome.PI.Model.Reseña;
import com.toolsToHome.PI.Service.ReservaService;
import com.toolsToHome.PI.Service.ReseñaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Reseñas")
public class ReseñaController {

    private static final Logger logger = Logger.getLogger(Reseña.class);
    private ReseñaService reseñaService;
    @Autowired
    public ReseñaController(ReseñaService reseñaService) {
        this.reseñaService = reseñaService;
    }

    @GetMapping
    public ResponseEntity<List<Reseña>>listarReseñas(){
    return ResponseEntity.ok( reseñaService.listarReseñas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reseña>>buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Reseña>buscarReseña= reseñaService.BuscarPorId(id);
        if(buscarReseña.isPresent()){
            return ResponseEntity.ok(buscarReseña);
        }else throw new ResourceNotFoundException("No se encontro reserva con id: " + id);
    }
    @PostMapping
    public ResponseEntity<Reseña>guardarReseña(@RequestBody Reseña reseña)throws ResourceNotFoundException{


            Reseña reseñaGuardada=reseñaService.guardarReseña(reseña);

            return ResponseEntity.ok(reseñaGuardada);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarReseña(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Reseña>buscarReseña= reseñaService.BuscarPorId(id);
        if(buscarReseña.isPresent()){
            reseñaService.eliminarReseña(id);
            return ResponseEntity.ok("Reseña con id: "+ id + " eliminada");
        }else throw new ResourceNotFoundException("No se encontro la reseña con id: "+id);
    }



}
