package com.toolsToHome.PI.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Herramienta> herramienta= new ArrayList<>();
    @Column
    private String titulo;
    @Column
    private String icono;

<<<<<<< HEAD
    public Categoria(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

=======
>>>>>>> 170a6db611478c52f6694a7574cfa9a45c89c966
    public Categoria(Long id) {
        this.id = id;
    }
}
