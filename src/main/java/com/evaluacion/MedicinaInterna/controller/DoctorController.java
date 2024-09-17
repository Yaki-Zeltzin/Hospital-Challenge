
package com.evaluacion.MedicinaInterna.controller;

import com.evaluacion.MedicinaInterna.model.Doctor;
import com.evaluacion.MedicinaInterna.service.IDoctorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctores")
public class DoctorController {
    
    @Autowired
    private IDoctorService docServ;
    
    @GetMapping("/traer")
    public List<Doctor> getDoctores(){
        return docServ.getDoctores();
    }
    
    @PostMapping("/crear")
    public String postDoctor(@RequestBody Doctor doc){
        docServ.postDoctor(doc);
        return "Doctor creado";
    }
    
    
    @DeleteMapping("/eliminar/{id}")
    public String deleteDoctor(@PathVariable Long id){
        docServ.deleteDoctor(id);
        return "Doctor eliminado correctamente";
    }
    
    
}
