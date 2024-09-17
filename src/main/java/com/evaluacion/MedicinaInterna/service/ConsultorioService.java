
package com.evaluacion.MedicinaInterna.service;

import com.evaluacion.MedicinaInterna.model.Consultorio;
import com.evaluacion.MedicinaInterna.repository.IConsultorioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultorioService implements IConsultorioService{

    @Autowired
    private IConsultorioRepository consulRepo;
    
    @Override
    public void postConsultorio(Consultorio consul) {
        consulRepo.save(consul);
    }

    @Override
    public List<Consultorio> getConsultorios() {
        return consulRepo.findAll();
    }

    @Override
    public void deleteConsultorio(Long id) {
        consulRepo.deleteById(id);
    }
    
}
