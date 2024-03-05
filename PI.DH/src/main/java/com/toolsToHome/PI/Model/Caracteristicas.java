package com.toolsToHome.PI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="Caracteristicas")
public class Caracteristicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    @Column
    private String descripcion;
    @Column
    private String icono;
    @Column
    private boolean isprincipal;
    @ManyToOne
    @JoinColumn(name = "herramienta_id", referencedColumnName= "id")
    private Herramienta herramienta;

}
