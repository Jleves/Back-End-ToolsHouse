package com.toolsToHome.PI.DH.Repository;

import com.toolsToHome.PI.DH.Model.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {


}
