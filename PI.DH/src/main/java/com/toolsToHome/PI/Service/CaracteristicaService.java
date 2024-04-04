package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.Model.Caracteristicas;

import com.toolsToHome.PI.Model.Herramienta;
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

    public void eliminarCaracteristicas(Long id){
        Optional<Caracteristicas>caracteristica = buscarPorId(id);
        if (caracteristica.isPresent()){
            // Desasociar todas las herramientas asociadas a esta característica
            for (Herramienta herramienta : caracteristica.get().getHerramientas()) {
                herramienta.getCaracteristicas().remove(caracteristica);
            }}
            // Eliminar la característica
        caracteristicaRepository.deleteById(id);
        }





    public void actualizarCaracteristicas(Caracteristicas caracteristicas){
        caracteristicaRepository.save(caracteristicas);
    }
    public List<Caracteristicas> listarTodos(){
        return caracteristicaRepository.findAll();
    }

}
