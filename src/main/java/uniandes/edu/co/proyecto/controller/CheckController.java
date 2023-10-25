package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


import uniandes.edu.co.proyecto.modelo.Check;
import uniandes.edu.co.proyecto.repositorio.CheckRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaHabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;


@Controller
public class CheckController {

    @Autowired
    private CheckRepository checkRepository;

    @Autowired
    private ReservaHabitacionRepository reservaHabitacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //id 
    //llegada:bool para saber si es llegada o salida
    //fecha
    //idReserva
    //idUsuario
    @GetMapping("/checks")
    public String checks(Model model,Integer id) {
        if(id != null && !id.equals("")){
            model.addAttribute("checks", checkRepository.mostrarCheckPorId(id));
        }
        else{
            model.addAttribute("checks", checkRepository.mostrarChecks());
        }
        return "checks";
  
    }

    @GetMapping("/checksLlegada")
    public String checksLlegada(Model model, String llegada, String fecha, String idReserva, String idUsuario) {
        model.addAttribute("checks", checkRepository.mostrarChecksLlegada());
        model.addAttribute("reservasHabitacion", reservaHabitacionRepository.mostrarReservasHabitacion());
        model.addAttribute("usuarios", usuarioRepository.mostrarUsuarios());
        return "checks";
  
    }

    @GetMapping("/checksSalida")
    public String checksSalida(Model model, String llegada, String fecha, String idReserva, String idUsuario) {
        model.addAttribute("checks", checkRepository.mostrarChecksSalida());
        model.addAttribute("reservasHabitacion", reservaHabitacionRepository.mostrarReservasHabitacion());
        model.addAttribute("usuarios", usuarioRepository.mostrarUsuarios());
        return "checks";
  
    }

    @GetMapping("/checks/new")
    public String checkForm(Model model) {
        model.addAttribute("check", new Check());
        model.addAttribute("reservas", reservaHabitacionRepository.mostrarReservasHabitacion());
        model.addAttribute("usuarios", usuarioRepository.mostrarUsuarios());
        return "checksNuevo";
    }

    @PostMapping("/checks/new/save")
    public String checkSave(@ModelAttribute Check check) {
        checkRepository.insertarCheck(check.getLlegada(), check.getFecha(),check.getIdReserva().getId(), check.getIdUsuario().getId());
        return "redirect:/checks";
    }

    @GetMapping("/checks/{id}/edit")
    public String checksForm(@PathVariable Integer id, Model model) {
        Check check = checkRepository.mostrarCheckPorId(id);

        if (check != null) {
            model.addAttribute("check", check);
            model.addAttribute("reservas", reservaHabitacionRepository.mostrarReservasHabitacion());
            model.addAttribute("usuarios", usuarioRepository.mostrarUsuarios());
            return "checksEditar";
        } 
        else 
        {
            return "redirect:/checks";
        }

    }

    @GetMapping("/checks/{id}/edit/save")
    public String checkEditarSave(@PathVariable Integer id, Check check) {
        checkRepository.actualizarCheck(id, check.getLlegada(), check.getFecha(), 
        check.getIdReserva().getId(), check.getIdUsuario().getId());
        return "redirect:/checks";
    }

    @GetMapping("/checks/{id}/delete")
    public String checkDelete(@PathVariable Integer id) {
        checkRepository.eliminarCheck(id);
        return "redirect:/checks";
    }
    
}
