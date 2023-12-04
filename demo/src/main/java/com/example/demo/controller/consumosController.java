package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.consumo;
import com.example.demo.repositorio.consumoRepository;

@Controller
public class consumosController {

    @Autowired
    private consumoRepository consumoRepository;

    @GetMapping("/consumos")
    public String obtenerTodosLosConsumos(Model model) {
        model.addAttribute("consumos", consumoRepository.findAll());
        return "consumos";
    }

    @GetMapping("/consumos/new")
    public String consumoForm(Model model) {
        model.addAttribute("nuevoconsumo", new consumo());
        return "consumosForm";
    }

    @PostMapping("/consumos/new/save")
    public String consumoSave(@ModelAttribute("nuevoconsumo") consumo nuevoconsumo) {
        consumoRepository.save(nuevoconsumo);
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{id}/edit")
    public String consumoEdit(Model model, @ModelAttribute("id") String id) {
        consumo consumo = consumoRepository.findById(id);
        if (consumo != null) {
            model.addAttribute("consumos", consumo);
            return "consumosFormEditar";
        }
        return "redirect:/consumos";
    }

    @PostMapping("/consumos/{id}/edit/save")
    public String consumoEditSave(@ModelAttribute("consumos") consumo nuevoconsumo, @ModelAttribute("id") String id) {
        nuevoconsumo.setId(id);
        consumoRepository.save(nuevoconsumo);
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{id}/delete")
    public String consumoDelete(@ModelAttribute("id") String id) {
        consumoRepository.deleteById(id);
        return "redirect:/consumos";
    }
}
