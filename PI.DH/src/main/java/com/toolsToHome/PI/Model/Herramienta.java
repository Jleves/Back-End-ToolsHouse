package com.toolsToHome.PI.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    @ManyToOne
    @JoinColumn(name = "Categoria_id", referencedColumnName= "id")
    private Categoria categoria;

    @Column(nullable = false)
    private Long stock;

    @Column(nullable = false)
    private Long precio;


    @JsonIgnore
    @OneToMany(mappedBy = "herramientaId") // Puede ser un tipo REFRESH...debatirlo
    private Set<Reserva> reserva = new HashSet<>();


    @Column(nullable = false)
    private boolean disponibilidad;


    @Column(nullable = false)
    private String nombre;



    @ManyToMany
    @JoinTable(name = "MuchosAMuchos",
            joinColumns = @JoinColumn(name = "herramienta_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristica_id"))
    private List<Caracteristicas> caracteristicas = new ArrayList<>();

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "herramienta", cascade = CascadeType.ALL)
    private List<Imagen> imagenes = new ArrayList<>();

}
