package com.toolsToHome.PI.Repository;

import com.toolsToHome.PI.Model.Reseña;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReseñaRepository extends JpaRepository<Reseña, Long> {
}
