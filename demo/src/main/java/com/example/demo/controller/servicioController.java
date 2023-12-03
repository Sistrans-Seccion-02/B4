package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.servicio;
import com.example.demo.repositorio.servicioRepository;


@Controller
public class servicioController {

    @Autowired
    private servicioRepository servicioRepository;

    @GetMapping("/servicios")
    public String obtenerTodasLasBebidasTipos(Model model){
        model.addAttribute("servicios", servicioRepository.findAll());
        return "servicios";
    }

    @GetMapping("/servicios/new")
    public String serviciosForm(Model model) {
        model.addAttribute("nuevoservicio", new servicio());
        return "serviciosForm";
    }

    @PostMapping("/servicios/new/save")
    public String serviciosSave(@ModelAttribute("nuevoservicio") servicio nuevoservicio){
        servicio nuevo = new servicio(nuevoservicio.getNombre(),nuevoservicio.getInicio_Servicio(),
        nuevoservicio.getFin_Servicio(),nuevoservicio.getCosto(),nuevoservicio.getProductos());
        servicioRepository.save(nuevo);
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/edit")
    public String serviciosEdit(Model model, @ModelAttribute("id") String id){
        servicio servicio =  servicioRepository.findById(id).get();
        if(servicio != null){
            model.addAttribute("servicios", servicio);
            return "serviciosFormEditar";
        }
        return "redirect:/servicios";
    }

     @PostMapping("/servicios/{id}/edit/save")
    public String serviciosEditSave(@ModelAttribute("servicio") servicio nuevoservicio, @ModelAttribute("id") String id){
        servicio nuevo = new servicio(nuevoservicio.getNombre(),nuevoservicio.getInicio_Servicio(),
        nuevoservicio.getFin_Servicio(),nuevoservicio.getCosto(),nuevoservicio.getProductos());
        servicioRepository.save(nuevo);
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/delete")
    public String serviciosDelete(@ModelAttribute("id")String id) {
        servicioRepository.deleteById(id);
        return "redirect:/servicios";
    }


}