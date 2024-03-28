package com.toolsToHome.PI.Controller;

import com.toolsToHome.PI.Exceptions.ResourceNotFoundException;
import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Service.CategoriaService;
import com.toolsToHome.PI.Service.HerramientaService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Herramientas")
public class HerramientaController {

    private static final Logger logger = Logger.getLogger(HerramientaController.class);
    private HerramientaService herramientaService;
    private CategoriaService categoriaService;
    @Autowired
    public HerramientaController(HerramientaService herramientaService, CategoriaService categoriaService) {
        this.herramientaService = herramientaService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Herramienta>>buscarHerramienta(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Herramienta>buscarHerramienta = herramientaService.buscarPorId(id);
        if (buscarHerramienta.isPresent()){
            return ResponseEntity.ok(buscarHerramienta);
        }else {
            throw new ResourceNotFoundException("No se encontró la herramienta con el ID: " + id);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Herramienta>>listarHerramientas(){
        logger.info("Get Herramienta");
        return ResponseEntity.ok(herramientaService.listarTodos());
    }

    @PostMapping("/create")
    public ResponseEntity<Herramienta>guardarHerramienta(@RequestBody Herramienta herramienta)throws ResourceNotFoundException{
        Optional<Herramienta>buscarHerramienta= herramientaService.buscarPorNombre(herramienta.getNombre());
        if(buscarHerramienta.isEmpty()){
            Herramienta herramientaGuardada = herramientaService.guardarHerramienta(herramienta);

            logger.info("Herramienta pasa por controller");
            return ResponseEntity.ok(herramientaGuardada);

        }else throw new ResourceNotFoundException("La Herramienta ya existe");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarHerramienta(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Herramienta>buscarHerramienta = herramientaService.buscarPorId(id);
        if(buscarHerramienta.isPresent()){
            herramientaService.eliminarHerramienta(id);
            return ResponseEntity.ok("Herramienta Eliminada");
        } else {
            throw new ResourceNotFoundException("No se encontró la herramienta con el ID: " + id);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String>actualizarHerramienta(@RequestBody Herramienta herramienta) throws ResourceNotFoundException{
        Optional<Herramienta> herramientaRequest = herramientaService.buscarPorId(herramienta.getId());

        if(herramientaRequest.isPresent()){
            herramientaService.actualizarHerramienta(herramienta);
            return ResponseEntity.ok("La herramienta con el ID: " + herramienta.getId() + " ha sido actualizada correctamente");
        }
        else {
            throw new ResourceNotFoundException("No se encontró la herramienta con el ID: " + herramienta.getId());
        }
    }



    @GetMapping ("/list/{nombre}")
    public ResponseEntity<Optional<Herramienta>>buscarPorNombre (@PathVariable String nombre)throws ResourceNotFoundException{
        Optional<Herramienta>herramientaBuscada = herramientaService.buscarPorNombre(nombre);
                if(herramientaBuscada.isPresent()){
                    return ResponseEntity.ok(herramientaBuscada);
                }else throw new ResourceNotFoundException("No se encontro la herramienta especificada con el nombre:  "+ nombre);
    }


}