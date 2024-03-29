package com.toolsToHome.PI.Repository;

import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository  extends JpaRepository<Reserva, Long> {

    List<Reserva> findByFechaAlquilerBetweenAndFechaDevolucionBetween(
            LocalDate fechaAlquilerInicio, LocalDate fechaAlquilerFin,
            LocalDate fechaDevolucionInicio, LocalDate fechaDevolucionFin);

}
