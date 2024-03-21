package com.toolsToHome.PI.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "HerramientaId", referencedColumnName= "id")
    private Herramienta herramientaId;


    @Column
    private LocalDate fechaAlquiler;
    @Column
    private LocalDate fechaDevolucion;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "UsuarioID", referencedColumnName = "id")
    private Usuario usuarioId;
}
