
package com.evaluacion.MedicinaInterna.repository;
 
import com.evaluacion.MedicinaInterna.model.Cita;
import com.evaluacion.MedicinaInterna.model.Consultorio;
import com.evaluacion.MedicinaInterna.model.Doctor;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaRepository  extends JpaRepository<Cita, Long>{
   List<Cita> findByDoctorAndHorarioBetween(Doctor doctor, LocalDateTime start, LocalDateTime end);
   List<Cita> findByConsultorioAndHorario(Consultorio consultorio, LocalDateTime horario);
   List<Cita> findByNombrePacienteAndHorarioBetween(String nombrePaciente, LocalDateTime start, LocalDateTime end);
   List<Cita> findByHorarioBetween(LocalDateTime start, LocalDateTime end);
}

