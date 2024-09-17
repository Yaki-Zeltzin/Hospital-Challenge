
package com.evaluacion.MedicinaInterna.service;

import com.evaluacion.MedicinaInterna.model.Doctor;
import com.evaluacion.MedicinaInterna.repository.IDoctorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService implements IDoctorService{
    
    @Autowired
    private IDoctorRepository docRepo;

    @Override
    public void postDoctor(Doctor doc) {
        docRepo.save(doc);
    }

    @Override
    public List<Doctor> getDoctores() {
        return docRepo.findAll();
    }

    @Override
    public void deleteDoctor(Long id) {
        docRepo.deleteById(id);
    }

    
    
}
