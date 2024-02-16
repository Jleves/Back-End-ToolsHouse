package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.Model.Herramienta;
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
    public Optional <Herramienta> buscarPorId(Long id){
        Optional<Herramienta>herramientaBuscada= herramientaRepository.findById(id);
        if(herramientaBuscada.isPresent()){
            return Optional.of(herramientaBuscada.get());
        }else return Optional.empty();
    }
    public Herramienta guardarHerramienta (Herramienta herramienta){
       return herramientaRepository.save(herramienta);
    }

    public void eliminarHerramienta (Long id){
        Optional<Herramienta> buscarHerramienta = herramientaRepository.findById(id);
        if(buscarHerramienta.isPresent()){
            herramientaRepository.deleteById(id);
        }
    }

    public void actualizarHerramienta (Herramienta herramienta){
        Optional<Herramienta> buscarHerramienta = herramientaRepository.findById(herramienta.getId());
        if(buscarHerramienta.isPresent()){
            herramientaRepository.save(herramienta);
        }

    }

    public List<Herramienta> listarTodos(){
        return herramientaRepository.findAll();
    }
}
