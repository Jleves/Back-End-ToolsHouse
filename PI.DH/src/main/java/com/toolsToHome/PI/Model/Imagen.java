package com.toolsToHome.PI.Model;
import com.toolsToHome.PI.Model.Herramienta;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "herramienta_id")
    private Herramienta herramienta;
}
