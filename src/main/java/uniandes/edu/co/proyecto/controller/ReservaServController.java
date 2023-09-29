package uniandes.edu.co.proyecto.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uniandes.edu.co.proyecto.modelo.ReservaServ;
import uniandes.edu.co.proyecto.repositorio.ReservaServRepository;

@Controller
public class ReservaServController {
    @Autowired
    private ReservaServRepository reservaServRepository;

    @GetMapping("/reservaservicios")
    public String reservaservicios(Model model, Date fechaInicio, Date fechaFin, Float pago){
        model.addAttribute("reservaservicios", reservaServRepository.mostrarReservasServicios());
        return "reservaservicios";
    }

    @GetMapping("/reservaservicios/new")
    public String reservaserviciosForm(Model model){
        model.addAttribute("reservaservicios", new ReservaServ());
        return "reservaserviciosNuevo";
    }

    @GetMapping("/reservaservicios/new/save")
    public String reservaserviciosSave(ReservaServ reservaServ){
        reservaServRepository.insertarReservaServicio(reservaServ.getFechaInicio(), reservaServ.getFechaFin(), reservaServ.getPago());
        return "redirect:/reservaservicios";
    }

    @GetMapping("/reservaservicios/{id}/edit")
    public String reservaserviciosEditarForm(@PathVariable Integer id, Model model){
        ReservaServ reservaServ = reservaServRepository.mostrarReservaServicioPorId(id);

        if (reservaServ != null){
            model.addAttribute("reservaServ", reservaServ);
            return "reservaserviciosEditar";
        }
        else return "redirect:/reservaservicios";
    }

    @GetMapping("/reservaservicios/{id}/edit/save")
    public String reservaserviciosEditarSave(@PathVariable Integer id, ReservaServ reservaServ){
        reservaServRepository.actualizarReservaServicio(id, reservaServ.getFechaInicio(), reservaServ.getFechaFin());
        return "redirect:/reservaservicios";
    }

    @GetMapping("/reservaservicios/{id}/delete")
    public String reservaserviciosDelete(@PathVariable Integer id){
        reservaServRepository.eliminarReservaServicio(id);
        return "redirect:/reservaservicios";
    }
    
}
