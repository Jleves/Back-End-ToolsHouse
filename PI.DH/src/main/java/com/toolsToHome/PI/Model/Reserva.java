package com.toolsToHome.PI.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate fechaAlquiler;
    @Column
    private LocalDate fechaDevolucion;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Herramienta_id", referencedColumnName= "id")
    private Herramienta herramientaId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "UsuarioID", referencedColumnName = "id", nullable = false)
    private Usuario usuarioId;
}
