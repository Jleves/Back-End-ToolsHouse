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
    public ResponseEntity<Herramienta>guardarHerramienta(@RequestBody Herramienta herramienta){
        Herramienta herramientaGuardada = herramientaService.guardarHerramienta(herramienta);
        /* Aquí no sé si sea necesaria la verificación de que no manden algo vacío, desde el front
           se podría controlar esto, pero no está mal igualmente */
        if(herramienta != null){
            return ResponseEntity.ok(herramientaGuardada);
        }else return ResponseEntity.badRequest().build();
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

    /* A este último de actualizar lo había pensado así:

    @PutMapping("/{id}")
    public ResponseEntity<String> updateHerramienta(@PathVariable Long id, @RequestBody Herramienta herramienta) throws ResourceNotFoundException{
        Optional<Herramienta> herramientaRequest = herramientaService.buscarPorId(id);

        if(herramientaRequest.isPresent()){
            Herramienta updatedHerramienta = herramientaRequest.get();
            updatedHerramienta.setCantidad(herramienta.getCantidad());
            updatedHerramienta.setDisponibilidad(herramienta.isDisponibilidad());
            updatedHerramienta.setCosto(herramienta.getCosto());


            ✧ La diferencia sería que aquí se le marca qué campos son los que se
            pueden actualizar, en este caso solo se le podría cambiar la cantidad,
            la disponibilidad y el costo. Es más que nada para evitar modificar
             campos que quizás no deben ser modificados ✧

            herramientaService.actualizarHerramienta(updatedHerramienta);
            return ResponseEntity.ok("La herramienta con el ID: " + id + " ha sido actualizada correctamente");
        } else {
            throw new ResourceNotFoundException("No se encontró la herramienta con el ID: " + id);
        }

        */

}
