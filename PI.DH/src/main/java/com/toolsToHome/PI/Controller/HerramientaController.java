package com.toolsToHome.PI.Controller;

import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Service.HerramientaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Optional<Herramienta>>buscarHerramienta(@PathVariable Long id){
    Optional<Herramienta>buscarHerramienta = herramientaService.buscarPorId(id);
    if (buscarHerramienta.isPresent()){
        return ResponseEntity.ok(buscarHerramienta);
    }else return ResponseEntity.notFound().build();  //Revisar excepciones...se debe crear excepciones para estos tipos de casos
    }

    @GetMapping
    public ResponseEntity<List<Herramienta>>listarHerramientas(){
        return ResponseEntity.ok(herramientaService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Herramienta>guardarHerramienta(@RequestBody Herramienta herramienta){
        Herramienta herramientaGuardada = herramientaService.guardarHerramienta(herramienta);
        if(herramienta != null){
            return ResponseEntity.ok(herramientaGuardada);
        }else return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarHerramienta(@PathVariable Long id){
        Optional<Herramienta>buscarHerramienta = herramientaService.buscarPorId(id);
        if(buscarHerramienta.isPresent()){
            herramientaService.eliminarHerramienta(id);
           return ResponseEntity.ok("Herramienta Eliminada");
        }else return ResponseEntity.notFound().build(); //Revisar excepcion..se debe crear excepciones para estos tipos de casos
    }

    @PutMapping
    public ResponseEntity<String>actualizarHerramienta(@RequestBody Herramienta herramienta){
        Optional<Herramienta>herramientaBuscada= herramientaService.buscarPorId(herramienta.getId());
        if(herramientaBuscada.isPresent()){
            herramientaService.actualizarHerramienta(herramienta);
            return ResponseEntity.ok("Herramienta actualizada");

        }else return new ResponseEntity<>("Herramienta no encontrada", HttpStatus.BAD_REQUEST);

    }

}
