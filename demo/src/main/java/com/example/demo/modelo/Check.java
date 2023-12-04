package com.example.demo.modelo;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "checks")
public class Check {
    @Id
    public String id;
    public Boolean llegada;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date fecha;
    private String idReserva;
    private String idUsuario;

    public Check(){}

    public Check(Boolean llegada,Date fecha,String idReserva, String idUsuario){
        this.llegada = llegada;
        this.fecha = fecha;
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getllegada() {
        return this.llegada;
    }

    public void setllegada(Boolean llegada) {
        this.llegada = llegada;
    }

    public Date getfecha() {
        return this.fecha;
    }

    public void setfecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdReserva() {
        return this.idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
