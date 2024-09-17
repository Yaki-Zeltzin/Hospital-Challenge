
package com.evaluacion.MedicinaInterna.service;

import com.evaluacion.MedicinaInterna.model.Doctor;
import java.util.List;


public interface IDoctorService {
    
    //Crear
    public void postDoctor(Doctor doc);
    
    //Lectura
    public List<Doctor> getDoctores();
    
    //Eliminar
    public void deleteDoctor(Long id);
    
}
