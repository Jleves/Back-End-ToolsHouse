package com.toolsToHome.PI.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "HerramientaId")
    private Herramienta herramientaId;


    @Column
    private LocalDate fechaAlquiler;
    @Column
    private LocalDate fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "UsuarioID", referencedColumnName = "id")
    private Usuario usuarioId;



    public Reserva(Long id) {
        this.id = id;
    }

    public Reserva(LocalDate fechaAlquiler, LocalDate fechaDevolucion, Usuario usuarioId) {
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.usuarioId = usuarioId;
    }


}
