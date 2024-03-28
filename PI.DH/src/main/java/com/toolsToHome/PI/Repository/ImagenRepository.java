package com.toolsToHome.PI.Repository;

import com.toolsToHome.PI.Model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long> {

    //Por el momento creo que podríamos poner para buscar por ID únicamente

}
