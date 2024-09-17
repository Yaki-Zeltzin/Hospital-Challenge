
package com.evaluacion.MedicinaInterna.service;

import com.evaluacion.MedicinaInterna.model.Cita;
import com.evaluacion.MedicinaInterna.repository.ICitaRepository;
import com.evaluacion.MedicinaInterna.repository.IConsultorioRepository;
import com.evaluacion.MedicinaInterna.repository.IDoctorRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {
    @Autowired
    private ICitaRepository citaRepository;

    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private IConsultorioRepository consultorioRepository;

    @Transactional
    public Cita crearCita(Cita cita) {
        validarCita(cita);
        return citaRepository.save(cita);
    }

    private void validarCita(Cita cita) {
        // Validar que el consultorio no esté ocupado a esa hora
        if (!citaRepository.findByConsultorioAndHorario(cita.getConsultorio(), cita.getHorario()).isEmpty()) {
            throw new IllegalArgumentException("El consultorio ya tiene una cita a esta hora.");
        }

        // Validar que el doctor no esté ocupado a esa hora
        if (!citaRepository.findByDoctorAndHorarioBetween(cita.getDoctor(), cita.getHorario().minusHours(1), cita.getHorario().plusHours(1)).isEmpty()) {
            throw new IllegalArgumentException("El doctor ya tiene una cita a esta hora.");
        }

        // Validar que el paciente no tenga más de una cita en el mismo día con menos de 2 horas de diferencia
        if (!citaRepository.findByNombrePacienteAndHorarioBetween(cita.getNombrePaciente(), cita.getHorario().toLocalDate().atStartOfDay(), cita.getHorario().toLocalDate().plusDays(1).atStartOfDay()).isEmpty()) {
            throw new IllegalArgumentException("El paciente ya tiene una cita en el mismo día con menos de 2 horas de diferencia.");
        }

        // Validar que el doctor no tenga más de 8 citas en el día
        long citasDelDia = citaRepository.findByDoctorAndHorarioBetween(cita.getDoctor(), cita.getHorario().toLocalDate().atStartOfDay(), cita.getHorario().toLocalDate().plusDays(1).atStartOfDay()).size();
        if (citasDelDia >= 8) {
            throw new IllegalArgumentException("El doctor ya tiene 8 citas en el día.");
        }
    }

    public List<Cita> buscarCitas(LocalDateTime start, LocalDateTime end, Long doctorId, Long consultorioId) {
        if (doctorId != null && consultorioId != null) {
            return citaRepository.findByDoctorAndHorarioBetween(doctorRepository.findById(doctorId).orElseThrow(), start, end);
        }
        if (doctorId != null) {
            return citaRepository.findByDoctorAndHorarioBetween(doctorRepository.findById(doctorId).orElseThrow(), start, end);
        }
        if (consultorioId != null) {
            return citaRepository.findByConsultorioAndHorario(consultorioRepository.findById(consultorioId).orElseThrow(), start);
        }
        return citaRepository.findByHorarioBetween(start, end);
    }

    public void cancelarCita(Long citaId) {
        citaRepository.deleteById(citaId);
    }
    
}
