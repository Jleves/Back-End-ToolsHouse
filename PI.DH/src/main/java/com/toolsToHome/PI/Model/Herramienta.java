package com.toolsToHome.PI.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Herramientas")
public class Herramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "Categoria_id", referencedColumnName= "id")
    private Categoria categoria;

    @Column(nullable = false)
    private Long stock;

    @Column(nullable = false)
    private Long precio;


    @Column(nullable = false)
    private boolean disponibilidad;


    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;



    @JsonIgnore
    @ManyToMany(mappedBy = "herramientasFavoritas")
    private List<Usuario>  usuariosFavoritos = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "MuchosAMuchos",
            joinColumns = @JoinColumn(name = "herramienta_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristica_id"))
    private List<Caracteristicas> caracteristicas = new ArrayList<>();



    @OneToMany(mappedBy = "herramienta", cascade = CascadeType.ALL)
    private List<Imagen> imagenes = new ArrayList<>();


    @OneToMany(mappedBy = "herramienta_idReseña",cascade = CascadeType.ALL)
    private Set<Reseña>reseñas=new HashSet<>();

}
/*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long stock;
    @Column(nullable = false)
    private Long precio;
    @Column(nullable = false)
    private boolean disponibilidad;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "Categoria_id", referencedColumnName= "id")
    private Categoria categoria;

    @OneToMany(mappedBy = "herramientaId",cascade = CascadeType.MERGE)
    private Set<Reserva> reserva = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "herramienta_caracteristica",
            joinColumns = @JoinColumn(name = "herramienta_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristica_id"))
    private List<Caracteristicas> caracteristicas = new ArrayList<>();

    @OneToMany(mappedBy = "herramienta", cascade = CascadeType.ALL)
    private List<Imagen> imagenes = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "herramientasFavoritas")
    private List<Usuario>  usuariosFavoritos = new ArrayList<>();*/