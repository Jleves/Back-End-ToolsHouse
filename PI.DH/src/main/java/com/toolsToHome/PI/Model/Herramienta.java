package com.toolsToHome.PI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Herramientas")
public class Herramienta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private Long stock;
    @Column(nullable = false)
    private Long precio;
    @Column(nullable = false)
    private boolean disponibilidad;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "herramienta", cascade = CascadeType.ALL)
    private List<Imagen> imagenes = new ArrayList<>();

}
