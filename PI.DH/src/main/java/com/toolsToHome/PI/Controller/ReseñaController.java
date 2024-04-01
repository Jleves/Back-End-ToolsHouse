package com.toolsToHome.PI.Controller;

import com.toolsToHome.PI.Exceptions.ResourceNotFoundException;
import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Model.Reseña;
import com.toolsToHome.PI.Service.HerramientaService;
import com.toolsToHome.PI.Service.ReservaService;
import com.toolsToHome.PI.Service.ReseñaService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Reseñas")
public class ReseñaController {

    private static final Logger logger = Logger.getLogger(Reseña.class);
    private ReseñaService reseñaService;
    private HerramientaService herramientaService;
    @Autowired
    public ReseñaController(ReseñaService reseñaService, HerramientaService herramientaService) {
        this.reseñaService = reseñaService;
        this.herramientaService = herramientaService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Reseña>>listarReseñas(){
    return ResponseEntity.ok( reseñaService.listarReseñas());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Reseña>>buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Reseña>buscarReseña= reseñaService.BuscarPorId(id);
        if(buscarReseña.isPresent()){
            return ResponseEntity.ok(buscarReseña);
        }else throw new ResourceNotFoundException("No se encontro reserva con id: " + id);
    }


    @PostMapping("/create")
    public ResponseEntity<Reseña>guardarReseña(@RequestBody Reseña reseña)throws ResourceNotFoundException{


            Reseña reseñaGuardada=reseñaService.guardarReseña(reseña);

            return ResponseEntity.ok(reseñaGuardada);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarReseña(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Reseña>buscarReseña= reseñaService.BuscarPorId(id);
        if(buscarReseña.isPresent()){
            reseñaService.eliminarReseña(id);
            return ResponseEntity.ok("Reseña con id: "+ id + " eliminada");
        }else throw new ResourceNotFoundException("No se encontro la reseña con id: "+id);
    }
    @GetMapping("/herramienta/{herramienta_idReseña}")
    public ResponseEntity<Set<Reseña>>buscarHerramienta( @PathVariable Long herramienta_idReseña) throws ResourceNotFoundException {
        Optional<Herramienta>buscarHerramienta = herramientaService.buscarPorId(herramienta_idReseña);
        if (buscarHerramienta.isPresent()){
            logger.info("herramienta encontrada :  "  + buscarHerramienta + "Reseñas de la herramienta : "+ buscarHerramienta.get().getReseñas() );
            return ResponseEntity.ok(buscarHerramienta.get().getReseñas());
        }else {
            throw new ResourceNotFoundException("No se encontró la herramienta con el ID: " + herramienta_idReseña);
        }
    }



}
