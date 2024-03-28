package com.toolsToHome.PI.Repository;

import com.toolsToHome.PI.Model.Caracteristicas;
import com.toolsToHome.PI.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristicas, Long> {

    Optional<Caracteristicas> findByTitulo(String string);
}
