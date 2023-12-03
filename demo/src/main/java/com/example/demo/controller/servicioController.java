package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.BebidaEmbedded;
import com.example.demo.modelo.BebidaTipos;
import com.example.demo.modelo.Servicio;
import com.example.demo.repositorio.ServicioRepository;


@Controller
public class servicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicios")
    public String obtenerTodasLasBebidasTipos(Model model){
        model.addAttribute("servicios", servicioRepository.findAll());
        return "servicios";
    }

    @GetMapping("/servicios/new")
    public String serviciosForm(Model model) {
        model.addAttribute("nuevoServicio", new Servicio());
        return "serviciosForm";
    }

    @PostMapping("/servicios/new/save")
    public String serviciosSave(@ModelAttribute("nuevoServicio") Servicio nuevoServicio){
        Servicio nuevo = new Servicio(nuevoServicio.getNombre(),nuevoServicio.getPrecio());
        servicioRepository.save(nuevo);
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/edit")
    public String serviciosEdit(Model model, @ModelAttribute("id") String id){
        Servicio servicio =  servicioRepository.findById(id).get();
        if(servicio != null){
            model.addAttribute("servicios", servicio);
            return "serviciosFormEditar";
        }
        return "redirect:/servicios";
    }

     @PostMapping("/servicios/{id}/edit/save")
    public String serviciosEditSave(@ModelAttribute("servicio") Servicio nuevoServicio, @ModelAttribute("id") String id){
        Servicio nuevo = new Servicio(nuevoServicio.getNombre(),nuevoServicio.getPrecio());
        nuevo.setId(id);
        servicioRepository.save(nuevo);
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/delete")
    public String serviciosDelete(@ModelAttribute("id")String id) {
        servicioRepository.deleteById(id);
        return "redirect:/servicios";
    }


}