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
    private String nombre;
    private String descripcion;
    private Long categoria;
    private Long precio;
    private Long cantidad;
    private String imagen;
    private String marca;



    public Herramienta(Long categoria, Long cantidad, Long costo, boolean diponibilidad, String nombra, String marca, String imagen) {
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = costo;
        this.nombre = nombra;
        this.marca = marca;
        this.imagen = imagen;
    }
}
