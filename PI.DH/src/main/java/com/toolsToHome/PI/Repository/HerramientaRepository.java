package com.toolsToHome.PI.Repository;

import com.toolsToHome.PI.Model.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {
    // Filtrar por marca
    Optional<Herramienta> findHerramientaByMarca (String marca);

}
