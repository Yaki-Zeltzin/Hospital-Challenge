
package com.evaluacion.MedicinaInterna.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cita {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long IdConsultorio;
     @ManyToOne
    @JoinColumn(name = "consultorio_id")
    private Consultorio consultorio;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private LocalDateTime horario;
    private String nombrePaciente;
    
}
