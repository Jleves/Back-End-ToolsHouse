package com.toolsToHome.PI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reseñas")
public class Reseña {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
@ManyToOne
@JoinColumn(name = "herramienta_id")
private Herramienta herramienta_idReseña;
@OneToOne
@JoinColumn(name = "reserva_id")
private Reserva reserva_id;
@Column
private Double raitng;
@Column
private String comentario;
@Column
private LocalDate fecha;

}
