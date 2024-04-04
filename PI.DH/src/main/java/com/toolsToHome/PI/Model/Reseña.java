package com.toolsToHome.PI.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reseñas")
public class Reseña {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;


 @JsonBackReference("reseñasReference")
 @JsonIgnoreProperties("reseñas")
 @ManyToOne(cascade = CascadeType.DETACH)
 @JoinColumn(name = "herramienta_id")
 private Herramienta herramienta_idReseña;



 @JsonBackReference
 @OneToOne(cascade = CascadeType.DETACH)
 @JoinColumn(name = "reserva_id",referencedColumnName = "id")
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

