package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.repositorio.PlanConsumoRepository;

@Controller
public class PlanConsumoController {
    
    @Autowired
    private PlanConsumoRepository planconsumoRepository;

    @GetMapping("/planesconsumo")
    public String planesconsumo(Model model) {
        model.addAttribute("planesconsumo", planconsumoRepository.mostrarPlanesConsumo());
        return "planesconsumo";
    }

    @GetMapping("/planesconsumo/new")
    public String planconsumoForm(Model model) {
        model.addAttribute("planconsumo", new PlanConsumo());
        return "planesconsumo/new";
    }

    @PostMapping("/planesconsumo/new/save")
    public String planconsumoSubmit(@ModelAttribute PlanConsumo planconsumo) {
        planconsumoRepository.insertarPlanConsumo(planconsumo.getNombre(), planconsumo.getDescuento());
        return "redirect:/planesconsumo";
    }

    @GetMapping("/planesconsumo/{id}/edit")
    public String planconsumoEdit(Model model, @PathVariable Integer id) {
        PlanConsumo planconsumo = planconsumoRepository.mostrarPlanConsumoporId(id);
        if (planconsumo != null) {
            model.addAttribute("planconsumo", planconsumo);
            return "planesconsumo/edit";
        }
        return "redirect:/planesconsumo";
    }

    @PostMapping("/planesconsumo/{id}/edit/save")
    public String planconsumoEditSubmit(@ModelAttribute PlanConsumo planconsumo, @PathVariable Integer id) {
        planconsumoRepository.actualizarPlanConsumo(id, planconsumo.getNombre(), planconsumo.getDescuento());
        return "redirect:/planesconsumo";
    }

    @PostMapping("/planesconsumo/{id}/delete")
    public String planconsumoDelete(@PathVariable Integer id) {
        planconsumoRepository.eliminarPlanConsumo(id);
        return "redirect:/planesconsumo";
    }   
}
