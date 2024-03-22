package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Model.Reserva;
import com.toolsToHome.PI.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaService {
    private ReservaRepository reservaRepository;
    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva guardarReserva(Reserva reserva){
       return reservaRepository.save(reserva);
    }

    public void actualizarReserva(Reserva reserva){
        reservaRepository.save(reserva);
    }

    public void eliminarReserva(Long id){reservaRepository.deleteById(id);}



    public Optional<Reserva> BuscarPorId(Long id){
        return reservaRepository.findById(id);
    }

}
