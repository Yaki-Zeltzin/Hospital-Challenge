
package com.evaluacion.MedicinaInterna.controller;

import com.evaluacion.MedicinaInterna.model.Cita;
import com.evaluacion.MedicinaInterna.repository.IConsultorioRepository;
import com.evaluacion.MedicinaInterna.repository.IDoctorRepository;
import com.evaluacion.MedicinaInterna.service.CitaService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citas")
public class CitaController {
   @Autowired
    private CitaService citaService;

    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private IConsultorioRepository consultorioRepository;

    @GetMapping("/alta")
    public String mostrarFormularioAlta(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("doctores", doctorRepository.findAll());
        model.addAttribute("consultorios", consultorioRepository.findAll());
        return "alta-cita";
    }

    @PostMapping("/alta")
    public String crearCita(@ModelAttribute Cita cita, Model model) {
        try {
            citaService.crearCita(cita);
            model.addAttribute("mensaje", "Cita creada exitosamente.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "resultado";
    }

    @GetMapping("/consulta")
    public String consultarCitas(@RequestParam(required = false) Long doctorId,
                                 @RequestParam(required = false) Long consultorioId,
                                 @RequestParam(required = false) String fecha,
                                 Model model) {
        LocalDateTime start = LocalDateTime.now(); // Default to now
        LocalDateTime end = LocalDateTime.now().plusDays(1); // Default to one day

        if (fecha != null) {
            start = LocalDateTime.parse(fecha + "T00:00:00");
            end = start.plusDays(1);
        }

        List<Cita> citas = citaService.buscarCitas(start, end, doctorId, consultorioId);
        model.addAttribute("citas", citas);
        return "consulta-citas";
    }

    @PostMapping("/cancelar/{id}")
    public String cancelarCita(@PathVariable Long id, Model model) {
        citaService.cancelarCita(id);
        model.addAttribute("mensaje", "Cita cancelada exitosamente.");
        return "resultado";
    }

}
