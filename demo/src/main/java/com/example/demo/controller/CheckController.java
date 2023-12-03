package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Check;
import com.example.demo.repositorio.CheckRepository;

@Controller
public class CheckController {
    @Autowired
    private CheckRepository checkRepository;

    @GetMapping("/checks")
    public String checks(Model model){
        model.addAttribute("checks", checkRepository.findAll());
        return "checks";
    }

    @GetMapping("/checks/new")
    public String checkForm(Model model) {
        model.addAttribute("tipoNuevo", new Check());
        return "checksNuevo";
    }

    @PostMapping("/checks/new/save")
    public String checkSave(@ModelAttribute("tipoNuevo") Check tipoNuevo){
        Check nuevo = new Check(tipoNuevo.getllegada(),tipoNuevo.getIdReserva(), tipoNuevo.getIdUsuario());
        checkRepository.save(nuevo);
        return "redirect:/checks";
    }

    @GetMapping("/checks/{id}/edit")
    public String checkEdit(Model model, @ModelAttribute("id") String id){
        Check tipo =  checkRepository.findById(id).get();
        if(tipo != null){
            model.addAttribute("tipo", tipo);
            return "checksEditar";
        }
        return "redirect:/checks";
    }

     @PostMapping("/checks/{id}/edit/save")
    public String checkEditSave(@ModelAttribute("tipo") Check tipoNuevo, @ModelAttribute("id") String id){
        Check nuevo = new Check(tipoNuevo.getllegada(),tipoNuevo.getIdReserva(), tipoNuevo.getIdUsuario());
        nuevo.setId(id);
        checkRepository.save(nuevo);
        return "redirect:/checks";
    }

    @GetMapping("/checks/{id}/delete")
    public String checkDelete(@ModelAttribute("id")String id) {
        checkRepository.deleteById(id);
        return "redirect:/checks";
    }
}
