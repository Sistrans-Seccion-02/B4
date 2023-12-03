package com.example.demo.modelo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document (collection = "reserva_habitaciones")
public class ReservaHabitacion {
    @Id
    private String id;

    private String descripcion;

    private Float costo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date FechaInicioReserva;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date FechaFinReserva;

    private Integer idUsuario;

    private String idHabitacion;

    public ReservaHabitacion(){}

    public ReservaHabitacion(String descripcion, Float costo, Date FechaInicioReserva, Date FechaFinReserva, Integer idUsuario,String idHabitacion){
        this.descripcion = descripcion;
        this.costo = costo;
        this.FechaInicioReserva = FechaInicioReserva;
        this.FechaFinReserva = FechaFinReserva;
        this.idUsuario = idUsuario;
        this.idHabitacion = idHabitacion;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getCosto() {
        return this.costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Date getFechaInicioReserva() {
        return this.FechaInicioReserva;
    }

    public void setFechaInicioReserva(Date fechaInicioReserva) {
        FechaInicioReserva = fechaInicioReserva;
    }

    public Date getFechaFinReserva() {
        return this.FechaFinReserva;
    }

    public void setFechaFinReserva(Date fechaFinReserva) {
        FechaFinReserva = fechaFinReserva;
    }

    public Integer getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdHabitacion() {
        return this.idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    


}
