package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


import uniandes.edu.co.proyecto.repositorio.HabitacionDotacionRepository;
import uniandes.edu.co.proyecto.modelo.HabitacionDotacion;
import uniandes.edu.co.proyecto.modelo.HabitacionDotacionPK;
import uniandes.edu.co.proyecto.modelo.OfertaHabitacion;
import uniandes.edu.co.proyecto.repositorio.OfertaHabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.DotacionRepository;
import uniandes.edu.co.proyecto.modelo.Dotacion;




@Controller
public class HabitacionDotacionController {
    
        @Autowired
        private HabitacionDotacionRepository habitacionDotacionRepository;

        @Autowired
        private DotacionRepository dotacionesRepository;

        @Autowired
        private OfertaHabitacionRepository ofertaHabitacionRepository;
    
        //mostrar todas las habitacionDotaciones
        @GetMapping("/habitacionDotaciones")
        public String habitacionDotaciones(Model model) {
            model.addAttribute("habitacionDotaciones", habitacionDotacionRepository.mostrarHabitacionesDotaciones());
            return "habitacionDotaciones";
        }
    
        @GetMapping("/habitacionDotaciones/new")
        public String habitacionDotacionForm(Model model) {
            model.addAttribute("habitaciones", ofertaHabitacionRepository.mostrarOfertasHabitacion());
            model.addAttribute("dotaciones", dotacionesRepository.mostrarDotaciones());
            return "habitacionDotaciones/new";
        }

        @PostMapping("/habitacionDotaciones/new/save")
        public String habitacionDotacionSubmit(@ModelAttribute("idOfertaHabitacion")int idOfertaHabitacion, @ModelAttribute("idDotacion")int idDotacion) {
            
            OfertaHabitacion ofertaHabitacion = ofertaHabitacionRepository.mostrarOfertaHabitacionPorId(idOfertaHabitacion);
            Dotacion dotacion = dotacionesRepository.mostrarDotacionPorId(idDotacion);

            HabitacionDotacionPK pk = new HabitacionDotacionPK(ofertaHabitacion, dotacion);
            HabitacionDotacion habitacionDotacion = new HabitacionDotacion();
            habitacionDotacion.setPk(pk);
            habitacionDotacionRepository.insertarHabitacionDotacion(habitacionDotacion.getPk().getIdOfertaHabitacion().getId(), 
            habitacionDotacion.getPk().getIdDotacion().getId());
            
            return "redirect:/habitacionDotaciones";
        }



}
