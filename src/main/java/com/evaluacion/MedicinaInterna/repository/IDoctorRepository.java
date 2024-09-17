
package com.evaluacion.MedicinaInterna.repository;

import com.evaluacion.MedicinaInterna.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Long>{
    
}
