
package com.evaluacion.MedicinaInterna.controller;

import com.evaluacion.MedicinaInterna.model.Consultorio;
import com.evaluacion.MedicinaInterna.service.IConsultorioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultorios")
public class ConsultorioController {
    
    @Autowired
    private IConsultorioService consulServ;
     
    @GetMapping("/traer")
    public List<Consultorio> getConsultorio(){
        return consulServ.getConsultorios();
    }
    
    @PostMapping("/crear")
    public String postConsultorio(@RequestBody Consultorio consul){
        consulServ.postConsultorio(consul);
        return "Consultorio creado";
    }
    
    @DeleteMapping("/eliminar/{id}")
    public String deleteDoctor(@PathVariable Long id){
        consulServ.deleteConsultorio(id);
        return "Consultorio eliminado correctamente";
    }
}
