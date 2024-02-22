package com.toolsToHome.PI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Herramientas")
public class Herramienta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoria",nullable = false)
    private String categoria;
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
    @Column(nullable = false)
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "herramienta",cascade = CascadeType.ALL)
    private List<Imagen> imagenes = new ArrayList<>();
    @Autowired
    public Herramienta(String categoria, Long stock, Long precio, boolean disponibilidad, String nombre, String marca, List<Imagen> imagenes) {
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.nombre = nombre;
        this.marca = marca;
        this.imagenes = imagenes;
    }

}
