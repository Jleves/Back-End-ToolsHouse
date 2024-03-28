package com.toolsToHome.PI.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Tag(name = "caracteristicas", description = "Endpoint de características")
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


}
