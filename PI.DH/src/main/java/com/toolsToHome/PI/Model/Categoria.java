package com.toolsToHome.PI.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Herramienta> herramienta= new ArrayList<>();
    @Column
    private String titulo;
    @Column
    private String descripcion;
    @Column
    private String icono;
}
