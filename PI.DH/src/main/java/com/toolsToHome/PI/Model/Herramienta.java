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

<<<<<<< HEAD
    @Column(name = "categoria",nullable = false)
    private String categoria;
    @Column(name = "stock")
=======
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
>>>>>>> JorgeLeves
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
<<<<<<< HEAD
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
=======
>>>>>>> JorgeLeves

}
