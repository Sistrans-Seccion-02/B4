package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.repositorio.DotacionRepository;
import uniandes.edu.co.proyecto.modelo.Dotacion;

@Controller
public class DotacionController {

    @Autowired
    private DotacionRepository dotacionRepository;

    //mostrar todas las dotaciones
    @GetMapping("/dotaciones")
    public String dotaciones(Model model) {
        model.addAttribute("dotaciones", dotacionRepository.mostrarDotaciones());
        return "dotaciones";
    }

    @GetMapping("/dotaciones/new")
    public String dotacionForm(Model model) {
        model.addAttribute("dotacion", new Dotacion());
        return "dotaciones/new";
    }


    @PostMapping("/dotaciones/new/save")
    public String dotacionSubmit(@ModelAttribute Dotacion dotacion) {
        dotacionRepository.insertarDotacion(dotacion.getNombre());
        return "redirect:/dotaciones";
    }

    @GetMapping("/dotaciones/{id}/edit")
    public String dotacionEdit(Model model, @PathVariable Integer id) {
        Dotacion dotacion = dotacionRepository.mostrarDotacionPorId(id);
        if (dotacion != null) {
            model.addAttribute("dotacion", dotacion);
            return "dotaciones/edit";
        }
        return "redirect:/dotaciones";
    }

    @PostMapping("/dotaciones/{id}/edit/save")
    public String dotacionEditSubmit(@ModelAttribute Dotacion dotacion, @PathVariable Integer id) {
        dotacionRepository.actualizarDotacion(id, dotacion.getNombre());
        return "redirect:/dotaciones";
    }

    @PostMapping("/dotaciones/{id}/delete")
    public String dotacionDelete(@PathVariable Integer id) {
        dotacionRepository.eliminarDotacion(id);
        return "redirect:/dotaciones";
    }


    
}
