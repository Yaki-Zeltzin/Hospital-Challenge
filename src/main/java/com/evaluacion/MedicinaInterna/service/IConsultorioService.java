
package com.evaluacion.MedicinaInterna.service;

import com.evaluacion.MedicinaInterna.model.Consultorio;
import java.util.List;

public interface IConsultorioService {
    
    //Crear
    public void postConsultorio(Consultorio consul);
    
    //Lectura
    public List<Consultorio> getConsultorios();
    
    //Eliminar
    public void deleteConsultorio(Long id);
}
