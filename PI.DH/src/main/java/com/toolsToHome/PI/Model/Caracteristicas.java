package com.toolsToHome.PI.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
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

    public Caracteristicas(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Caracteristicas(Long id) {
        this.id = id;
    }
}
