package com.toolsToHome.PI.Controller;

import com.toolsToHome.PI.Exceptions.ResourceNotFoundException;
import com.toolsToHome.PI.Model.Categoria;
import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Service.CategoriaService;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Categorias")
public class CategoriaContoller {
    private CategoriaService categoriaService;
    private static final Logger logger = Logger.getLogger(HerramientaController.class);


    public CategoriaContoller(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> buscarCategoria(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Categoria> buscarcategoria = categoriaService.buscarPorId(id);
        if (buscarcategoria.isPresent()) {
            return ResponseEntity.ok(buscarcategoria);
        } else {
            throw new ResourceNotFoundException("No se encontró la categoria con el ID: " + id);
        }
    }
        @GetMapping
        public ResponseEntity<List<Categoria>>listarHerramientas(){
            return ResponseEntity.ok(categoriaService.listarTodos());
        }






        @PostMapping
        public ResponseEntity<Categoria>guardarCategoria(@RequestBody Categoria categoria)throws ResourceNotFoundException{
            Optional<Categoria>buscarCategoria= categoriaService.buscarPorCategoria(categoria.getTitulo());
            if(buscarCategoria.isEmpty()){
                Categoria categoriaGuardada = categoriaService.guardarCategoria(categoria);

                logger.info("Categoria pasa por controller");
                return ResponseEntity.ok(categoriaGuardada);

            }else throw new ResourceNotFoundException("La Categoria ya existe");
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> eliminarCategoria(@PathVariable Long id) throws ResourceNotFoundException{
            Optional<Categoria>buscarCategoria = categoriaService.buscarPorId(id);
            if(buscarCategoria.isPresent()){
                categoriaService.eliminarCategoria(id);
                return ResponseEntity.ok("Herramienta Eliminada");
            } else {
                throw new ResourceNotFoundException("No se encontró la herramienta con el ID: " + id);
            }
        }

        @PutMapping
        public ResponseEntity<String>actualizarCategoria(@RequestBody Categoria categoria) throws ResourceNotFoundException{
            Optional<Categoria> categoriaRequest = categoriaService.buscarPorId(categoria.getId());

            if(categoriaRequest.isPresent()){
                Categoria updatedCategoria = categoriaRequest.get();
                updatedCategoria.setTitulo(categoria.getTitulo());
                updatedCategoria.setHerramienta(categoria.getHerramienta());

                return ResponseEntity.ok("La categoria: " + categoria.getTitulo() + " ha sido actualizada correctamente");
            }

            else {
                throw new ResourceNotFoundException("No se encontró la herramienta con el ID: " + categoria.getId());
            }
        }

    }

