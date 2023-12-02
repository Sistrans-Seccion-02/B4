package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Habitacion;
import com.example.demo.repositorio.HabitacionRepository;
import com.example.demo.repositorio.TipoHabitacionRepository;

@Controller
public class HabitacionController {
    @Autowired
    private TipoHabitacionRepository tipohabitacionRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;


     @GetMapping("/habitaciones")
    public String habitaciones(Model model){
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        return "habitaciones";
    }

    @GetMapping("/habitaciones/new")
    public String habitacionesForm(Model model) {
        model.addAttribute("tiposHabitacion", tipohabitacionRepository.findAll());
        model.addAttribute("habitacionNueva", new Habitacion());
        return "habitacionesForm";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionesSave(@ModelAttribute("habitacionNueva") Habitacion habitacionNueva){
        Habitacion nueva = new Habitacion(habitacionNueva.getCapacidad(),habitacionNueva.getIdTipoHabitacion(),habitacionNueva.getFechaInicioOferta(),habitacionNueva.getFechaFinOferta());
        habitacionRepository.save(nueva);
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/edit")
    public String habitacionesEdit(Model model, @ModelAttribute("id") String id){
        Habitacion habitacion =  habitacionRepository.findById(id).get();
        if(habitacion != null){
            model.addAttribute("habitacionNueva", habitacion);
            model.addAttribute("tiposHabitacion", tipohabitacionRepository.findAll());
            return "habitacionFormEditar";
        }
        return "redirect:/tipohabitacion";
    }

     @PostMapping("/habitaciones/{id}/edit/save")
    public String habitacionesEditSave(@ModelAttribute("habitacion") Habitacion habitacionNueva, @ModelAttribute("id") String id){
        Habitacion nueva = new Habitacion(habitacionNueva.getCapacidad(),habitacionNueva.getIdTipoHabitacion(),habitacionNueva.getFechaInicioOferta(),habitacionNueva.getFechaFinOferta());
        nueva.setId(id);
        habitacionRepository.save(nueva);
        return "redirect:/habitaciones";
    }


    @GetMapping("/habitaciones/{id}/delete")
    public String habitacionesDelete(@ModelAttribute("id")String id) {
        habitacionRepository.deleteById(id);
        return "redirect:/habitaciones";
    }
}
