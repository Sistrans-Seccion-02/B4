package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.ReservaHabitacion;
import com.example.demo.nuevasClases.fechas;
import com.example.demo.repositorio.HabitacionRepository;
import com.example.demo.repositorio.ReservaHabitacionRepository;
import com.example.demo.repositorio.ReservaHabitacionRepository.TotalDiasPorHabitacion;

@Controller
public class ReservaHabitacionController {

    public String habitacionActualid;

    public Date FechaInicioActual;

    public Date FechaFinActual;

    

    public String getHabitacionActualid() {
        return habitacionActualid;
    }

    public void setHabitacionActualid(String habitacionActualid) {
        this.habitacionActualid = habitacionActualid;
    }

    public Date getFechaInicioActual() {
        return FechaInicioActual;
    }

    public void setFechaInicioActual(Date fechaInicioActual) {
        FechaInicioActual = fechaInicioActual;
    }

    public Date getFechaFinActual() {
        return FechaFinActual;
    }

    public void setFechaFinActual(Date fechaFinActual) {
        FechaFinActual = fechaFinActual;
    }

    @Autowired
    private ReservaHabitacionRepository reservaHabitacionRepository;

     @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/reservaHabitaciones")
    public String reservaHabitaciones(Model model){
        model.addAttribute("reservasHabitaciones", reservaHabitacionRepository.findAll());
        return "reservaHabitaciones";
    }

    @GetMapping("/reservaHabitaciones/new")
    public String reservaHabitacionesForm(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        model.addAttribute("reservaHabitacionNueva", new ReservaHabitacion());
        return "reservaHabitacionesForm";
    }

    @GetMapping("/reservaHabitaciones/{id}/edit")
    public String reservaHabitacionesEditForm(Model model, @ModelAttribute("id") String id) {
        ReservaHabitacion reserva = reservaHabitacionRepository.findById(id).get();
        this.setFechaFinActual(reserva.getFechaFinReserva());
        this.setFechaInicioActual(reserva.getFechaInicioReserva());
        this.setHabitacionActualid(reserva.getIdHabitacion());
        if(reserva != null){
            model.addAttribute("nuevaReservaHabitacion", reserva);

            return "reservaHabitacionFormEditar";
        }
        return "redirect:/reservaHabitaciones";
    }



    @PostMapping("/reservaHabitaciones/{id}/edit/save")
    public String reservaHabitacionesEditSave(@ModelAttribute("nuevaReservaHabitacion") ReservaHabitacion nuevaReserva, @ModelAttribute("id") String id){
        ReservaHabitacion nueva = new ReservaHabitacion(nuevaReserva.getDescripcion(), nuevaReserva.getCosto(), this.getFechaInicioActual(), this.getFechaFinActual(), nuevaReserva.getIdUsuario(), this.getHabitacionActualid());
        nueva.setId(id);
        reservaHabitacionRepository.save(nueva);
        this.setFechaFinActual(null);
        this.setFechaInicioActual(null);
        this.setHabitacionActualid(null);
        return "redirect:/reservaHabitaciones";
    }


    @GetMapping("/reservaHabitaciones/{id}/delete")
    public String reservaHabitacionesDelete(@ModelAttribute("id")String id) {
        reservaHabitacionRepository.deleteById(id);
        return "redirect:/reservaHabitaciones";
    }



    @PostMapping("/reservaHabitaciones/new/save")
    public String reservaHabitacionesSave(Model model, @ModelAttribute ReservaHabitacion reservaNueva) {
        System.out.println(reservaNueva.getIdHabitacion());
        ReservaHabitacion nueva = new ReservaHabitacion(reservaNueva.getDescripcion(),reservaNueva.getCosto(), this.getFechaInicioActual(),this.getFechaFinActual(),reservaNueva.getIdUsuario(),this.getHabitacionActualid());
        reservaHabitacionRepository.save(nueva);
        this.setFechaFinActual(null);
        this.setFechaInicioActual(null);
        this.setHabitacionActualid(null);
        return "redirect:/reservaHabitaciones";
    }

    @GetMapping("/reservaHabitaciones/new/fechas")
    public String reservaHabitacionesFechasForm(Model model){
        model.addAttribute("fechas", new fechas());
        return "reservaHabitacionesFechasForm";
    }

    @GetMapping("/reservaHabitaciones/new/fechas/habitaciones")
    public String reservaHabitacionesFechas(Model model, @ModelAttribute("fecha1") String fecha1,@ModelAttribute("fecha2") String fecha2,@ModelAttribute fechas fechas){
        Criteria criteria = new Criteria().andOperator(
        Criteria.where("FechaInicioOferta").lte(fechas.getFecha1()),
        Criteria.where("FechaFinOferta").gte(fechas.getFecha2()));

        MatchOperation matchOperation = Aggregation.match(criteria);

        Aggregation aggregation = Aggregation.newAggregation(matchOperation);

        List<Habitacion> aggregationResults = mongoTemplate.aggregate(
                aggregation, "habitaciones", Habitacion.class
        ).getMappedResults();
        System.out.println(fecha1);
        System.out.println(fecha2);
        model.addAttribute("habitaciones", aggregationResults);
        model.addAttribute("fecha1", fecha1);
        model.addAttribute("fecha2", fecha2);
        
        return "reservaHabitacionesFechas";
    }

     @GetMapping("/reservaHabitaciones/new/fechas/habitaciones/{id}/book/{fecha1}/{fecha2}")
     public String reservaHabitacionesFechasBook(Model model, @ModelAttribute("fecha1") String fecha1, @ModelAttribute("fecha2") String fecha2, @ModelAttribute("id") String id){
        
        model.addAttribute("fecha1", fecha1);
        model.addAttribute("fecha2", fecha2);
        model.addAttribute("id", id);
        
        this.setHabitacionActualid(id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date = dateFormat.parse(fecha1);
            Date date2 = dateFormat.parse(fecha2);
            this.setFechaInicioActual(date);
            this.setFechaFinActual(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        

        model.addAttribute("nuevaReservaHabitacion", new ReservaHabitacion());

        return "pasoFinalReservaHabitaciones";
     }

    @GetMapping("/reservas/total")
    public String mostrarTotalPorHabitacion(Model model) {
    List<TotalDiasPorHabitacion> totales = reservaHabitacionRepository.calcularTotalPorHabitacion();
    model.addAttribute("totales", reservaHabitacionRepository.calcularTotalPorHabitacion());
    for (TotalDiasPorHabitacion total : totales) {
        System.out.println(total.getIdHabitacion() + ": " + total.getTotal());
    }
    System.out.println("hola");
    return "reservas-total"; 
}

}
