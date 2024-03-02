package com.toolsToHome.PI.Repository;

import com.toolsToHome.PI.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario>findByEmail(String email);
}
