package com.toolsToHome.PI.email.repositoryEmail;


import com.toolsToHome.PI.email.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Long> {
    Confirmation findByToken(String token);
}