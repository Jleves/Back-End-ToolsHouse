package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.Model.Reserva;
import com.toolsToHome.PI.Model.Reseña;
import com.toolsToHome.PI.Repository.ReseñaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReseñaService {
    private ReseñaRepository reseñaRepository;
    @Autowired
    public ReseñaService(ReseñaRepository reseñaRepository) {
        this.reseñaRepository = reseñaRepository;
    }


    public Reseña guardarReseña(Reseña reseña){
        return reseñaRepository.save(reseña);
    }

    public void actualizarReseña(Reseña reseña){
        reseñaRepository.save(reseña);
    }

    public void eliminarReseña(Long id){reseñaRepository.deleteById(id);}

    public List<Reseña>listarReseñas(){return reseñaRepository.findAll();}


    public Optional<Reseña> BuscarPorId(Long id){
        return reseñaRepository.findById(id);
    }
}
