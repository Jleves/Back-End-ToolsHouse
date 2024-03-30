package com.toolsToHome.PI.email;

import com.toolsToHome.PI.Model.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;



@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name  = "confirmations")
public class Confirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private LocalDateTime createdDate;

    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private Usuario user;

    public Confirmation(Usuario user, String token) {
        this.user = user;
        this.createdDate = LocalDateTime.now();
        this.token = token;
    }
}
