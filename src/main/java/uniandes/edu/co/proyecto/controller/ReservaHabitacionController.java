package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.repositorio.ReservaHabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;
import uniandes.edu.co.proyecto.modelo.ReservaHabitacion;
import uniandes.edu.co.proyecto.repositorio.OfertaHabitacionRepository;

@Controller
public class ReservaHabitacionController {

    //id
    //fechaInicio
    //fechaFin
    //pago
    //idHabitacion
    //idCliente

    @Autowired
    private ReservaHabitacionRepository reservaHabitacionRepository;

    @Autowired
    private OfertaHabitacionRepository ofertaHabitacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //mostrar todas las reservas de habitacion
    @GetMapping("/reservasHabitacion")
    public String reservasHabitacion(Model model,Integer id) {
        if (id != null && !id.equals("")) {
            model.addAttribute("reservasHabitacion", reservaHabitacionRepository.mostrarReservaHabitacionPorId(id));
        } else {
            model.addAttribute("reservasHabitacion", reservaHabitacionRepository.mostrarReservasHabitacion());
        }
        return "reservasHabitacion";
    }

    @GetMapping("/reservasHabitacion/new")
    public String reservaHabitacionForm(Model model) {
        model.addAttribute("reservaHabitacion", new ReservaHabitacion());
        model.addAttribute("ofertasHabitacion", ofertaHabitacionRepository.mostrarOfertasHabitacion());
        model.addAttribute("usuarios", usuarioRepository.mostrarUsuarios());
        return "reservasHabitacionNuevo";
    }

    @PostMapping("/reservasHabitacion/new/save")
    public String reservaHabitacionSubmit(@ModelAttribute ReservaHabitacion reservaHabitacion) {
        reservaHabitacionRepository.insertarReservaHabitacion(reservaHabitacion.getFechaInicio(), 
        reservaHabitacion.getFechaFin(), reservaHabitacion.getPago(), reservaHabitacion.getplanesconsumo_id().getId(), 
        reservaHabitacion.getIdHabitacion().getId(), reservaHabitacion.getIdCliente().getId());
        return "redirect:/reservasHabitacion";
    }

    @GetMapping("/reservasHabitacion/{id}/edit")
    public String reservaHabitacionEdit(Model model, @ModelAttribute("id")int id) {
        ReservaHabitacion reservaHabitacion = reservaHabitacionRepository.mostrarReservaHabitacionPorId(id);
        if (reservaHabitacion != null) {
            model.addAttribute("reservaHabitacion", reservaHabitacion);
            model.addAttribute("ofertasHabitacion", ofertaHabitacionRepository.mostrarOfertasHabitacion());
            model.addAttribute("usuarios", usuarioRepository.mostrarUsuarios());
            return "reservasHabitacionEditar";
        }
        return "redirect:/reservasHabitacion";
    }

    @PostMapping("/reservasHabitacion/{id}/edit/save")
    public String reservaHabitacionEditSubmit(@ModelAttribute ReservaHabitacion reservaHabitacion, @PathVariable Integer id) {
        reservaHabitacionRepository.actualizarReservaHabitacion(id, reservaHabitacion.getFechaInicio(), 
        reservaHabitacion.getFechaFin(), reservaHabitacion.getPago(),reservaHabitacion.getplanesconsumo_id().getId(),
        reservaHabitacion.getIdHabitacion().getId(), reservaHabitacion.getIdCliente().getId());
        return "redirect:/reservasHabitacion";
    }

    @PostMapping("/reservasHabitacion/{id}/delete")
    public String reservaHabitacionDelete(@ModelAttribute("id")int id) {
        reservaHabitacionRepository.eliminarReservaHabitacion(id);
        return "redirect:/reservasHabitacion";
    }
    
    
}
