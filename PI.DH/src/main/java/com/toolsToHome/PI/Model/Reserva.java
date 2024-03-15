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
    @JsonIgnore
    @OneToOne(mappedBy = "reserva")
    private Herramienta herramientaId;
    @Column
    private LocalDate fechaAlquiler;
    @Column
    private LocalDate fechaDevolucion;
}
