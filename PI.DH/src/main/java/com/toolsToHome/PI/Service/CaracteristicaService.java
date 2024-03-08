package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.Model.Caracteristicas;

import com.toolsToHome.PI.Repository.CaracteristicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CaracteristicaService {


    private CaracteristicaRepository caracteristicaRepository;
    @Autowired
    public CaracteristicaService(CaracteristicaRepository caracteristicaRepository) {
        this.caracteristicaRepository = caracteristicaRepository;
    }

    public Caracteristicas guardarCaracteristica(Caracteristicas caracteristicas) {
        return caracteristicaRepository.save(caracteristicas);
    }
    public Optional<Caracteristicas> buscarPorId(Long id){
        return caracteristicaRepository.findById(id);
    }
    public Optional<Caracteristicas>buscarPorCaracteristicas(String categoria){
        return caracteristicaRepository.findByTitulo(categoria);
    }

    public void eliminarCaracteristicas(Long id){caracteristicaRepository.deleteById(id);
    }
    public void actualizarCaracteristicas(Caracteristicas caracteristicas){
        caracteristicaRepository.save(caracteristicas);
    }
    public List<Caracteristicas> listarTodos(){
        return caracteristicaRepository.findAll();
    }

}
