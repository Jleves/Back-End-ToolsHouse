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

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/Categorias")

public class CategoriaContoller {
    private CategoriaService categoriaService;
    private static final Logger logger = Logger.getLogger(HerramientaController.class);


    public CategoriaContoller(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }



    //USER, ADMIN            **********************************************



    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Categoria>> buscarCategoria(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Categoria> buscarcategoria = categoriaService.buscarPorId(id);
        if (buscarcategoria.isPresent()) {
            return ResponseEntity.ok(buscarcategoria);
        } else {
            throw new ResourceNotFoundException("No se encontró la categoria con el ID: " + id);
        }
    }
    @CrossOrigin(origins = "*")
    //USER, ADMIN   ****************************************************
    @GetMapping("/list")
    public ResponseEntity<List<Categoria>>listarCategorias(){
        return ResponseEntity.ok(categoriaService.listarTodos());
    }



    //ADMIN         +++++++++++++++++++


    @PostMapping("/create")
    public ResponseEntity<Categoria>guardarCategoria(@RequestBody Categoria categoria){

        Categoria newCategoria = categoriaService.guardarCategoria(categoria);

        return ResponseEntity.ok(categoria);
    }


    //ADMIN   *********************************



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Categoria>buscarCategoria = categoriaService.buscarPorId(id);
        if(buscarCategoria.isPresent()){
            categoriaService.eliminarCategoria(id);
            return ResponseEntity.ok("Caragoría eliminada");
        } else {
            throw new ResourceNotFoundException("No se encontró la caracteristica con el ID: " + id);
        }
    }



    //ADMIN ********************************************



    @PutMapping("/update")
    public ResponseEntity<String>actualizarCategoria(@RequestBody Categoria categoria) throws ResourceNotFoundException{
        Optional<Categoria> categoriaRequest = categoriaService.buscarPorId(categoria.getId());

        if(categoriaRequest.isPresent()){

            categoriaService.actualizarCategoria(categoria);

            return ResponseEntity.ok("La categoria: " + categoria.getId() + " ha sido actualizada correctamente");
        }
        else {
            throw new ResourceNotFoundException("No se encontró la herramienta con el ID: " + categoria.getId());
        }
    }
}