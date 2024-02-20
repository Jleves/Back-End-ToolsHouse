package com.toolsToHome.PI.Model;
import com.toolsToHome.PI.Model.Herramienta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "herramienta_id",referencedColumnName = "id")
    private Herramienta herramienta;
}
