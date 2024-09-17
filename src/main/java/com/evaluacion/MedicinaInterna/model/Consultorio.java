
package com.evaluacion.MedicinaInterna.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consultorio {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long IdConsultorio;
    private int numeroConsul;
    private int piso;
    
  
}
