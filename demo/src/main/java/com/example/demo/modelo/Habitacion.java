package com.example.demo.modelo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document (collection = "habitaciones")
public class Habitacion {
    @Id
    private String id;

    private Integer capacidad;

    private String idTipoHabitacion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date FechaInicioOferta;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date FechaFinOferta;

    public Habitacion(){;}

    public Habitacion(Integer capacidad, String idTipoHabitacion, Date FechaInicioOferta, Date FechaFinOferta){
        this.capacidad = capacidad;
        this.idTipoHabitacion = idTipoHabitacion;
        this.FechaInicioOferta = FechaInicioOferta;
        this.FechaFinOferta =FechaFinOferta;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getIdTipoHabitacion() {
        return this.idTipoHabitacion;
    }

    public void setIdTipoHabitacion(String idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public Date getFechaInicioOferta() {
        return this.FechaInicioOferta;
    }

    public void setFechaInicioOferta(Date fechaInicioOferta) {
        FechaInicioOferta = fechaInicioOferta;
    }

    public Date getFechaFinOferta() {
        return this.FechaFinOferta;
    }

    public void setFechaFinOferta(Date fechaFinOferta) {
        FechaFinOferta = fechaFinOferta;
    }

    
}
