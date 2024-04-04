package com.toolsToHome.PI.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JsonIgnoreProperties("reserva")
    @JoinColumn(name = "HerramientaId")
    private Herramienta herramientaId;


    @Column
    private LocalDate fechaAlquiler;
    @Column
    private LocalDate fechaDevolucion;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "UsuarioID", referencedColumnName = "id")
    private Usuario usuarioId;
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "reserva_id")
    private Reseña reseña;



    public Reserva(Long id) {
        this.id = id;
    }

    public Reserva(LocalDate fechaAlquiler, LocalDate fechaDevolucion, Usuario usuarioId) {
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.usuarioId = usuarioId;
    }

}
