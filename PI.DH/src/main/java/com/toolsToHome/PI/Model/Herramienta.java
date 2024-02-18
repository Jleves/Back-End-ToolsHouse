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
    @Column(name = "categoria",nullable = false)
    private Long categoria;
    @Column(name = "stock")
    private Long stock;
    @Column(name = "precio")
    private Long precio;
    @Column(name = "disponibilidad")
    private boolean disponibilidad;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "marca",nullable = false)
    private String marca;

    @OneToMany(mappedBy = "herramienta", cascade = CascadeType.ALL)
    private List<Imagen> imagenes = new ArrayList<>();

}
