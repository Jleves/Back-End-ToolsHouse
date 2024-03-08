package com.toolsToHome.PI.Controller;

import com.toolsToHome.PI.Exceptions.ResourceNotFoundException;
import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Service.HerramientaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/Herramientas")
public class HerramientaController {
    private static final Logger logger = Logger.getLogger(HerramientaController.class);
    private HerramientaService herramientaService;
    @Autowired
    public HerramientaController(HerramientaService herramientaService) {
        this.herramientaService = herramientaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Herramienta>>buscarHerramienta(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Herramienta>buscarHerramienta = herramientaService.buscarPorId(id);
        if (buscarHerramienta.isPresent()){
            return ResponseEntity.ok(buscarHerramienta);
        }else {
            throw new ResourceNotFoundException("No se encontró la herramienta con el ID: " + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<Herramienta>>listarHerramientas(){
        return ResponseEntity.ok(herramientaService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Herramienta>guardarHerramienta(@RequestBody Herramienta herramienta)throws ResourceNotFoundException{
        Optional<Herramienta>buscarHerramienta= herramientaService.buscarPorNombre(herramienta.getNombre());
        if(buscarHerramienta.isEmpty()){
            Herramienta herramientaGuardada = herramientaService.guardarHerramienta(herramienta);

            logger.info("Herramienta pasa por controller");
            return ResponseEntity.ok(herramientaGuardada);

        }else throw new ResourceNotFoundException("La Herramienta ya existe");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarHerramienta(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Herramienta>buscarHerramienta = herramientaService.buscarPorId(id);
        if(buscarHerramienta.isPresent()){
            herramientaService.eliminarHerramienta(id);
            return ResponseEntity.ok("Herramienta Eliminada");
        } else {
            throw new ResourceNotFoundException("No se encontró la herramienta con el ID: " + id);
        }
    }

    @PutMapping
    public ResponseEntity<String>actualizarHerramienta(@RequestBody Herramienta herramienta) throws ResourceNotFoundException{
        Optional<Herramienta> herramientaRequest = herramientaService.buscarPorId(herramienta.getId());

        if(herramientaRequest.isPresent()){
            Herramienta updatedHerramienta = herramientaRequest.get();
            updatedHerramienta.setStock(herramienta.getStock());
            updatedHerramienta.setDisponibilidad(herramienta.isDisponibilidad());
            updatedHerramienta.setPrecio(herramienta.getPrecio());
            herramientaService.actualizarHerramienta(updatedHerramienta);
            return ResponseEntity.ok("La herramienta con el ID: " + updatedHerramienta.getId() + " ha sido actualizada correctamente");
        }

        else {
            throw new ResourceNotFoundException("No se encontró la herramienta con el ID: " + herramienta.getId());
        }
    }


}