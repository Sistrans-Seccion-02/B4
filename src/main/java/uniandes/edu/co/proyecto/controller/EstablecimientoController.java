package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uniandes.edu.co.proyecto.modelo.Establecimiento;
import uniandes.edu.co.proyecto.repositorio.EstablecimientoRepository;

@Controller
public class EstablecimientoController {
    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    @GetMapping("/establecimientos")
    public String establecimientos(Model model, String nombre, Integer capacidad ){
        model.addAttribute("establecimientos", establecimientoRepository.mostrarEstablecimientos());
        return "establecimientos";
    }

    @GetMapping("/establecimientos/new")
    public String establecimientosForm(Model model){
        model.addAttribute("establecimiento", new Establecimiento());
        return "establecimientoNuevo";
    }

    @GetMapping("/establecimientos/new/save")
    public String establecimientoSave(Establecimiento establecimiento){
        establecimientoRepository.insertarEstablecimiento(establecimiento.getNombre(),establecimiento.getCapacidad());
        return "redirect:/establecimientos";
    }
    
    @GetMapping("/establecimientos/{id}/edit")
    public String establecimientoEditarForm(@PathVariable Integer id, Model model){
        Establecimiento establecimiento = establecimientoRepository.mostrarEstablecimientoPorId(id);

        if(establecimiento != null){
            model.addAttribute("establecimiento", establecimiento);
            return "establecimientoEditar";
        }
        else return "redirect:/establecimientos";
    }

    @GetMapping("/establecimientos/{id}/edit/save")
    public String establecimientoEditarSave(@PathVariable Integer id, Establecimiento establecimiento){
        establecimientoRepository.actualizarEstablecimiento(id, establecimiento.getNombre(), establecimiento.getCapacidad());
        return "redirect:/establecimientos";

    }

    @GetMapping("/establecimientos/{id}/delete")
    public String establecimientoDelete(@PathVariable Integer id){
        establecimientoRepository.eliminarEstablecimiento(id);
        return "redirect:/establecimientos";
    }




}
