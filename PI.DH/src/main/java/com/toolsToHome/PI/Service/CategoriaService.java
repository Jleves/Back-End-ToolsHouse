package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.Model.Categoria;
import com.toolsToHome.PI.Model.Herramienta;

import com.toolsToHome.PI.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;
    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    public Optional<Categoria> buscarPorId(Long id){
        return categoriaRepository.findById(id);
    }
    public Optional<Categoria>buscarPorCategoria(String categoria){
        return categoriaRepository.findByTitulo(categoria);
    }

    public void eliminarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
    public void actualizarCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }
    public List<Categoria> listarTodos(){
        return categoriaRepository.findAll();
    }

}
