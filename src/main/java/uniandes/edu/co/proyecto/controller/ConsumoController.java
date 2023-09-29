package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaHabitacionRepository;

@Controller
public class ConsumoController {
    
    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired 
    private ReservaHabitacionRepository reservaHabitacionRepository;

    @GetMapping("/consumos")
    public String consumos(Model model, String Llegada, String fecha, String idReserva, String idUsuario)
    {
        model.addAttribute("consumos", consumoRepository.mostrarConsumos());
        model.addAttribute("reservasHabitacion", reservaHabitacionRepository.mostrarReservasHabitacion());
        return "consumos";
    }

    @GetMapping("/consumos/new")
    public String consumosForm(Model model){
        model.addAttribute("consumo", new Consumo());
        return "consumoNuevo";
    }

    @GetMapping("/consumos/new/save")
    public String consumoSave(Consumo consumo){
        consumoRepository.insertarConsumo(consumo.getDescripcion(),consumo.getCosto(),consumo.getFecha(),consumo.getIdReserva().getId());
        return "redirect:/consumos";
    }
    
    @GetMapping("/consumos/{id}/edit")
    public String consumoEditarForm(@PathVariable Integer id, Model model){
        Consumo consumo = consumoRepository.mostrarConsumoPorId(id);

        if(consumo != null){
            model.addAttribute("consumo", consumo);
            model.addAttribute("reservas", reservaHabitacionRepository.mostrarReservasHabitacion());
            return "consumoEditar";
        }
        else{
            return "redirect:/consumos";
        }
    }

    @GetMapping("/consumos/{id}/edit/save")
    public String consumoEditarSave(@PathVariable Integer id, Consumo consumo){
        consumoRepository.actualizarConsumo(id, consumo.getDescripcion(), consumo.getCosto(), consumo.getFecha());
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{id}/delete")
    public String consumoDelete(@PathVariable Integer id){
        consumoRepository.eliminarConsumo(id);
        return "redirect:/consumos";
    }
}