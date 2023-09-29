package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.repositorio.HotelRepository;

@Controller
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/hoteles")
    public String hoteles(Model model) {
        model.addAttribute("hoteles", hotelRepository.mostrarHoteles());
        return "hoteles";
    }

    @GetMapping("/hoteles/new")
    public String hotelForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "hoteles/new";
    }


    @PostMapping("/hoteles/new/save")
    public String hotelSubmit(@ModelAttribute Hotel hotel) {
        hotelRepository.insertarHotel(hotel.getNombre(), hotel.getUbicacion());
        return "redirect:/hoteles";
    }

    @GetMapping("/hoteles/{id}/edit")
    public String hotelEdit(Model model, @PathVariable Integer id) {
        Hotel hotel = hotelRepository.mostrarHotelporId(id);
        if (hotel != null) {
            model.addAttribute("hotel", hotel);
            return "hoteles/edit";
        }
        return "redirect:/hoteles";
    }

    @PostMapping("/hoteles/{id}/edit/save")
    public String hotelEditSubmit(@ModelAttribute Hotel hotel, @PathVariable Integer id) {
        hotelRepository.actualizarHotel(id, hotel.getNombre(), hotel.getUbicacion());
        return "redirect:/hoteles";
    }

    @PostMapping("/hoteles/{id}/delete")
    public String hotelDelete(@PathVariable Integer id) {
        hotelRepository.eliminarHotel(id);
        return "redirect:/hoteles";
    }
}
