package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.TipoHabitacion;
import com.example.demo.repositorio.TipoHabitacionRepository;

@Controller
public class TipoHabitacionController {
    
    @Autowired
    private TipoHabitacionRepository tipohabitacionRepository;


    @GetMapping("/tipohabitacion")
    public String tipoHabitacion(Model model){
        model.addAttribute("tiposHabitacion", tipohabitacionRepository.findAll());
        return "tipohabitacion";
    }

    @GetMapping("/tipohabitacion/new")
    public String tipoHabitacionForm(Model model) {
        model.addAttribute("tipoNuevo", new TipoHabitacion());
        return "tipoHabitacionForm";
    }

    @PostMapping("/tipohabitacion/new/save")
    public String tipoHabitacionSave(@ModelAttribute("tipoNuevo") TipoHabitacion tipoNuevo){
        TipoHabitacion nuevo = new TipoHabitacion(tipoNuevo.getTipo(),tipoNuevo.getDotacion());
        tipohabitacionRepository.save(nuevo);
        return "redirect:/tipohabitacion";
    }

    @GetMapping("/tipohabitacion/{id}/edit")
    public String tipoHabitacionEdit(Model model, @ModelAttribute("id") String id){
        TipoHabitacion tipo =  tipohabitacionRepository.findById(id).get();
        if(tipo != null){
            model.addAttribute("tipo", tipo);
            return "tipoHabitacionFormEditar";
        }
        return "redirect:/tipohabitacion";
    }

     @PostMapping("/tipohabitacion/{id}/edit/save")
    public String tipoHabitacionEditSave(@ModelAttribute("tipo") TipoHabitacion tipoNuevo, @ModelAttribute("id") String id){
        TipoHabitacion nuevo = new TipoHabitacion(tipoNuevo.getTipo(),tipoNuevo.getDotacion());
        nuevo.setId(id);
        tipohabitacionRepository.save(nuevo);
        return "redirect:/tipohabitacion";
    }

    @GetMapping("/tipohabitacion/{id}/delete")
    public String tipoHabitacionDelete(@ModelAttribute("id")String id) {
        tipohabitacionRepository.deleteById(id);
        return "redirect:/tipohabitacion";
    }

}
