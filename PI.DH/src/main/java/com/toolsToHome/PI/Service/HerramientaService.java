package com.toolsToHome.PI.Service;

import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Model.Imagen;
import com.toolsToHome.PI.Model.Reserva;
import com.toolsToHome.PI.Repository.HerramientaRepository;
import com.toolsToHome.PI.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HerramientaService {
    private HerramientaRepository herramientaRepository;
    private ReservaRepository reservaRepository;
    @Autowired
    public HerramientaService(HerramientaRepository herramientaRepository, ReservaRepository reservaRepository) {
        this.herramientaRepository = herramientaRepository;
        this.reservaRepository = reservaRepository;
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
    public Optional<Herramienta>buscarPorNombre(String nombre){
        return herramientaRepository.findByNombre(nombre);
    }

    public void eliminarHerramienta(Long id){
        herramientaRepository.deleteById(id);
    }
    public void actualizarHerramienta(Herramienta herramienta){
        herramientaRepository.save(herramienta);
    }
    public List<Herramienta> listarTodos(){
        return herramientaRepository.findAll();
    }


    public List<Herramienta> buscarPorNombreYDisponibilidad(String nombre, LocalDate fechaAlquiler, LocalDate fechaDevolucion) {
        List<Herramienta> herramientas = herramientaRepository.findByNombreContainingIgnoreCaseAndDisponibilidad(nombre, true);
        List<Reserva> reservas = reservaRepository.findByFechaAlquilerBetweenAndFechaDevolucionBetween(fechaAlquiler, fechaDevolucion, fechaAlquiler, fechaDevolucion);

        List<Herramienta> herramientasDisponibles = new ArrayList<>();

        for (Herramienta herramienta : herramientas) {
            boolean disponible = true;
            for (Reserva reserva : reservas) {
                if (reserva.getHerramientaId().equals(herramienta)) {
                    disponible = false;
                    break;
                }
            }
            if (disponible) {
                herramientasDisponibles.add(herramienta);
            }
        }

        return herramientasDisponibles;
    }

}