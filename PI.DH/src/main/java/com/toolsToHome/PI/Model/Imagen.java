package com.toolsToHome.PI.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 3000)
    private String url;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "herramienta_id", referencedColumnName= "id")
    private Herramienta herramienta;


    public Imagen(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public Imagen(Long id) {
        this.id = id;
    }
}