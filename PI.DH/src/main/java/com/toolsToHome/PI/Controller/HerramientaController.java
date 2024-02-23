package com.toolsToHome.PI.Controller;

import com.toolsToHome.PI.Exceptions.ResourceNotFoundException;
import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Service.HerramientaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Herramientas")
public class HerramientaController {
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
    public ResponseEntity<Herramienta> guardarHerramienta(@RequestBody Herramienta herramienta) {
        Herramienta herramientaGuardada = herramientaService.guardarHerramienta(herramienta);
        if (herramientaGuardada != null) {
            return ResponseEntity.ok(herramientaGuardada);
        } else {
            return ResponseEntity.badRequest().build();
        }
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
        Optional<Herramienta>herramientaBuscada= herramientaService.buscarPorId(herramienta.getId());
        if(herramientaBuscada.isPresent()){
            herramientaService.actualizarHerramienta(herramienta);
            return ResponseEntity.ok("Herramienta actualizada");

        }else {
            throw new ResourceNotFoundException("No se encontró la herramienta con el ID: " + herramienta.getId());
        }

    }


}
