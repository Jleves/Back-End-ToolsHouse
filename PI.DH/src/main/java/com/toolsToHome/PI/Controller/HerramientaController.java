package com.toolsToHome.PI.Controller;

import com.toolsToHome.PI.Exceptions.ResourceNotFoundException;
import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Service.CategoriaService;
import com.toolsToHome.PI.Service.HerramientaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Api(value = "Herramienta")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/herramientas")
public class HerramientaController {
    private static final Logger logger = Logger.getLogger(HerramientaController.class);
    private HerramientaService herramientaService;
    private CategoriaService categoriaService;
    @Autowired
    public HerramientaController(HerramientaService herramientaService, CategoriaService categoriaService) {
        this.herramientaService = herramientaService;
        this.categoriaService = categoriaService;
    }

    @ApiOperation(value = "Listar todas las herramientas")
    @GetMapping
    public ResponseEntity<List<Herramienta>>listarHerramientas(){
        logger.info("Get Herramienta");
        return ResponseEntity.ok(herramientaService.listarTodos());
    }

    @ApiOperation(value = "Obtener una herramienta por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Herramienta>>buscarHerramienta(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Herramienta>buscarHerramienta = herramientaService.buscarPorId(id);
        if (buscarHerramienta.isPresent()){
            return ResponseEntity.ok(buscarHerramienta);
        }else {
            throw new ResourceNotFoundException("No se encontró la herramienta con el ID: " + id);
        }
    }

    @ApiOperation(value = "Obtener una herramienta por nombre")
    @GetMapping ("/{nombre}")
    public ResponseEntity<Optional<Herramienta>>buscarPorNombre (@PathVariable String nombre)throws ResourceNotFoundException{
        Optional<Herramienta>herramientaBuscada = herramientaService.buscarPorNombre(nombre);
        if(herramientaBuscada.isPresent()){
            return ResponseEntity.ok(herramientaBuscada);
        }else throw new ResourceNotFoundException("No se encontro la herramienta especificada con el nombre:  "+ nombre);
    }

    @ApiOperation(value = "Crear una herramienta")
    @PostMapping("/create")
    public ResponseEntity<Herramienta>guardarHerramienta(@RequestBody Herramienta herramienta)throws ResourceNotFoundException{
        Optional<Herramienta>buscarHerramienta= herramientaService.buscarPorNombre(herramienta.getNombre());
        if(buscarHerramienta.isEmpty()){
            Herramienta herramientaGuardada = herramientaService.guardarHerramienta(herramienta);

            logger.info("Herramienta pasa por controller");
            return ResponseEntity.ok(herramientaGuardada);

        }else throw new ResourceNotFoundException("La Herramienta ya existe");
    }

    @ApiOperation(value = "Eliminar una herramienta por ID")
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

    @ApiOperation(value = "Actualizar una herramienta")
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

   /* private Herramienta getHerramienta(Herramienta herramienta, Optional<Herramienta> herramientaRequest) {
        Herramienta updatedHerramienta = herramientaRequest.get();
        updatedHerramienta.setCaracteristicas(herramienta.getCaracteristicas());
        updatedHerramienta.setCategoria(categoriaService.guardarCategoria(herramienta.getCategoria()));
        updatedHerramienta.setReserva(herramienta.getReserva());
        updatedHerramienta.setImagenes(herramienta.getImagenes());
        updatedHerramienta.setDescripcion(herramienta.getDescripcion());
        updatedHerramienta.setStock(herramienta.getStock());
        updatedHerramienta.setDisponibilidad(herramienta.isDisponibilidad());
        updatedHerramienta.setPrecio(herramienta.getPrecio());
        return updatedHerramienta;
    } */


}