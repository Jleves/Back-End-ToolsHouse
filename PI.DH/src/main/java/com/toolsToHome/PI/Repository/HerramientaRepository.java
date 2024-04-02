package com.toolsToHome.PI.Repository;

import com.toolsToHome.PI.Model.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {
    List<Herramienta> findByNombreContainingIgnoreCase(String nombre);
    List<Herramienta> findByNombreAndDisponibilidad(String nombre, boolean disponibilidad);

    List<Herramienta> findByNombreContainingIgnoreCaseAndDisponibilidad(String nombre, boolean b);
}