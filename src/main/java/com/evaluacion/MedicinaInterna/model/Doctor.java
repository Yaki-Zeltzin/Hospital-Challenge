
package com.evaluacion.MedicinaInterna.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idDoctor;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String especialidad;
    
    @OneToMany
    private List<Consultorio> listaConsultorios;
    
}
