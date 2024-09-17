
package com.evaluacion.MedicinaInterna.repository;

import com.evaluacion.MedicinaInterna.model.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsultorioRepository extends JpaRepository<Consultorio, Long>{
    
}
