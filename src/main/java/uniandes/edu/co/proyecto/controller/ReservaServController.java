package uniandes.edu.co.proyecto.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ReservaServ;
import uniandes.edu.co.proyecto.nuevasClases.fechas;
import uniandes.edu.co.proyecto.repositorio.ReservaServRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

@Controller
public class ReservaServController {
    @Autowired
    private ReservaServRepository reservaServRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/reservaservicios")
    public String reservaservicios(Model model, Integer id){
        if(id != null && !id.equals("")){
            model.addAttribute("reservaservicios", reservaServRepository.mostrarReservaServicioPorId(id));
        }
        else{
            model.addAttribute("reservaservicios", reservaServRepository.mostrarReservasServicios());
        }
        
        return "reservaservicios";
    }

    @GetMapping("/reservaservicios/new")
    public String reservaserviciosForm(Model model){
        model.addAttribute("reservaservicios", new ReservaServ());
        model.addAttribute("servicios", servicioRepository.mostrarServicios());
        return "reservaserviciosNuevo";
    }

    @PostMapping("/reservaservicios/new/save")
    public String reservaserviciosSave(@ModelAttribute ReservaServ reservaServ){
        reservaServRepository.insertarReservaServicio(reservaServ.getfechaInicio(),
        reservaServ.getfechaFin(), 
        reservaServ.getPago(), 
        reservaServ.getid_servicio().getId(),
        reservaServ.getHabitacion_id().getId(),
        reservaServ.getid_servicio().getNombre());
        return "redirect:/reservaservicios";
    }

    @GetMapping("/reservaservicios/{id}/edit")
    public String reservaserviciosEditarForm(@PathVariable Integer id, Model model){
        ReservaServ reservaServ = reservaServRepository.mostrarReservaServicioPorId(id);

        if (reservaServ != null){
            model.addAttribute("reservaServ", reservaServ);
            model.addAttribute("servicios", servicioRepository.mostrarServicios());
            return "reservaserviciosEditar";
        }
        else return "redirect:/reservaservicios";
    }

    @PostMapping("/reservaservicios/{id}/edit/save")
    public String reservaserviciosEditarSave(@PathVariable Integer id, ReservaServ reservaServ){
        reservaServRepository.actualizarReservaServicio(id, reservaServ.getfechaInicio(), reservaServ.getfechaFin(), reservaServ.getPago(), reservaServ.getid_servicio().getId());
        return "redirect:/reservaservicios";
    }

    @GetMapping("/reservaservicios/{id}/delete")
    public String reservaserviciosDelete(@PathVariable Integer id){
        reservaServRepository.eliminarReservaServicio(id);
        return "redirect:/reservaservicios";
    }

    @GetMapping("/reservaservicios/habitaciones")
    public String reservaserviciosHabitaciones(Model model){
        model.addAttribute("reservaservicios",  reservaServRepository.mostrarReservasHabitacion());
        return "reservaserviciosHabitaciones";
    }

    @GetMapping("/reservaservicios/populares")
    public String reservaserviciosPopulares(Model model){
        model.addAttribute("fechas", new fechas());
        return "reservaServiciosPopularesNuevo";
    }
    
    @GetMapping("reservaservicios/fechas")
    public String reservaserviciosPopularesInsertarFecha(@ModelAttribute fechas fechas, Model model){ 
        model.addAttribute("reservaservicios", reservaServRepository.mostrarServiciosPopulares(fechas.getFecha2(), fechas.getFecha1() ));
        return "reservaServiciosPopulares";
    }


}
