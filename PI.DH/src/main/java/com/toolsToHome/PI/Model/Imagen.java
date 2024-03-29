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

<<<<<<< HEAD
    public Imagen(Long id, String url) {
        this.id = id;
        this.url = url;
    }
=======
>>>>>>> 170a6db611478c52f6694a7574cfa9a45c89c966

    public Imagen(Long id) {
        this.id = id;
    }
}