package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Model.Imagen;
import com.toolsToHome.PI.Repository.HerramientaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HerramientaService {
    private HerramientaRepository herramientaRepository;
    @Autowired
    public HerramientaService(HerramientaRepository herramientaRepository) {
        this.herramientaRepository = herramientaRepository;
    }
    public Herramienta guardarHerramienta(Herramienta herramienta) {
        for (Imagen imagen : herramienta.getImagenes()) {
            imagen.setHerramienta(herramienta);
        }
        return herramientaRepository.save(herramienta);
    }
    public Optional<Herramienta> buscarPorId(Long id){
        return herramientaRepository.findById(id);
    }
    /*
    public Optional<Herramienta> findHerramientaByMarca(String marca) {
        return herramientaRepository.findHerramientaByMarca(marca);
    }*/
    public void eliminarHerramienta(Long id){
        herramientaRepository.deleteById(id);
    }
    public void actualizarHerramienta(Herramienta herramienta){
        herramientaRepository.save(herramienta);
    }
    public List<Herramienta> listarTodos(){
        return herramientaRepository.findAll();
    }

}
