package com.toolsToHome.PI.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="Herramientas")
public class Herramienta {
    private Long id;
    private Long categoria;
    private Long cantidad;
    private Long costo;
    private boolean diponibilidad;
    private String nombra;
    private String marca;
    private String imagen;

    public Herramienta(Long categoria, Long cantidad, Long costo, boolean diponibilidad, String nombra, String marca, String imagen) {
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.costo = costo;
        this.diponibilidad = diponibilidad;
        this.nombra = nombra;
        this.marca = marca;
        this.imagen = imagen;
    }
}
