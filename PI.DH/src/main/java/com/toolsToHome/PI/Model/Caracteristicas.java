package com.toolsToHome.PI.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name ="Caracteristicas")
public class Caracteristicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;

    @Column
    private String icono;
    @JsonIgnore
    @ManyToMany(mappedBy = "caracteristicas")
    private List<Herramienta> herramientas = new ArrayList<>();


}
/*
    @ManyToOne
    @JoinColumn(name = "herramienta_id", referencedColumnName= "id")
    private Herramienta herramienta;*/
