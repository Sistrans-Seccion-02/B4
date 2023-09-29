package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

@Controller
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicios")
    public String servicios(Model model) {
        model.addAttribute("servicios", servicioRepository.mostrarServicios());
        return "servicios";
    }

    @GetMapping("/servicios/new")
    public String servicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicios/new";
    }

    @PostMapping("/servicios/new/save")
    public String servicioSubmit(@ModelAttribute Servicio servicio) {
        servicioRepository.insertarServicio(servicio.getNombre(), servicio.getCosto(), servicio.getDescripcion());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/edit")
    public String servicioEdit(Model model, @PathVariable Integer id) {
        Servicio servicio = servicioRepository.mostrarServicioPorId(id);
        if (servicio != null) {
            model.addAttribute("servicio", servicio);
            return "servicios/edit";
        }
        return "redirect:/servicios";
    }

    @PostMapping("/servicios/{id}/edit/save")
    public String servicioEditSubmit(@ModelAttribute Servicio servicio, @PathVariable Integer id) {
        servicioRepository.actualizarServicio(id, servicio.getNombre(), servicio.getCosto(), servicio.getDescripcion());
        return "redirect:/servicios";
    }

    @PostMapping("/servicios/{id}/delete")
    public String servicioDelete(@PathVariable Integer id) {
        servicioRepository.eliminarServicio(id);
        return "redirect:/servicios";
    }
}
