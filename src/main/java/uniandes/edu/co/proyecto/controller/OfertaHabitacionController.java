package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.OfertaHabitacion;
import uniandes.edu.co.proyecto.repositorio.HotelRepository;
import uniandes.edu.co.proyecto.repositorio.OfertaHabitacionRepository;

@Controller
public class OfertaHabitacionController {

    //id
    //capacidad
    //fechaInicio
    //fechaFin
    //costo
    //tipoHabitacion
    //idHotel
    @Autowired
    private OfertaHabitacionRepository ofertaHabitacionRepository;

    @Autowired
    private HotelRepository hotelRepository;

    //mostrar todas las ofertas de habitacion
    @GetMapping("/ofertasHabitacion")
    public String ofertasHabitacion(Model model) {
        model.addAttribute("ofertasHabitacion", ofertaHabitacionRepository.mostrarOfertasHabitacion());
        return "ofertasHabitacion";
    }

    @GetMapping("/ofertasHabitacion/new")
    public String ofertaHabitacionForm(Model model) {
        model.addAttribute("ofertaHabitacion", new OfertaHabitacion());
        model.addAttribute("hoteles", hotelRepository.mostrarHoteles());
        return "ofertasHabitacionNuevo";
    }

    @PostMapping("/ofertasHabitacion/new/save")
    public String ofertaHabitacionSubmit(@ModelAttribute OfertaHabitacion ofertaHabitacion) {
        ofertaHabitacionRepository.insertarOfertaHabitacion(ofertaHabitacion.getCapacidad(), 
        ofertaHabitacion.getFechaInicio(), ofertaHabitacion.getFechaFin(), 
        ofertaHabitacion.getCosto(), ofertaHabitacion.getTipoHabitacion(), ofertaHabitacion.getIdHotel().getId());
        return "redirect:/ofertasHabitacion";
    }

    @GetMapping("/ofertasHabitacion/{id}/edit")
    public String ofertaHabitacionEdit(Model model, @ModelAttribute("id")int id) {
        OfertaHabitacion ofertaHabitacion = ofertaHabitacionRepository.mostrarOfertaHabitacionPorId(id);
        if (ofertaHabitacion != null) {
            model.addAttribute("ofertaHabitacion", ofertaHabitacion);
            model.addAttribute("hoteles", hotelRepository.mostrarHoteles());
            return "ofertasHabitacionEditar";
        }
        return "redirect:/ofertasHabitacion";
    }

    @PostMapping("/ofertasHabitacion/{id}/edit/save")
    public String ofertaHabitacionEditSubmit(@ModelAttribute OfertaHabitacion ofertaHabitacion, @ModelAttribute("id")int id) {
        ofertaHabitacionRepository.actualizarOfertaHabitacion(id, ofertaHabitacion.getCapacidad(), ofertaHabitacion.getFechaInicio(), ofertaHabitacion.getFechaFin(), ofertaHabitacion.getCosto(), ofertaHabitacion.getTipoHabitacion(), ofertaHabitacion.getIdHotel().getId());
        return "redirect:/ofertasHabitacion";
    }

    @PostMapping("/ofertasHabitacion/{id}/delete")
    public String ofertaHabitacionDelete(@ModelAttribute("id")int id) {
        ofertaHabitacionRepository.eliminarOfertaHabitacion(id);
        return "redirect:/ofertasHabitacion";
    }

    
}
