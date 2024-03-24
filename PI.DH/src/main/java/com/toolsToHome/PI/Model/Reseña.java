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
private Long raiting;
@Column
private String comentario;
@Column
private LocalDate fecha;

 public Reseña(Reserva reserva_id, Long raiting, String comentario, LocalDate fecha) {
  this.reserva_id = reserva_id;
  this.raiting = raiting;
  this.comentario = comentario;
  this.fecha = fecha;
 }

 public Reseña(Long id) {
  this.id = id;
 }
}
