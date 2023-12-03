package com.example.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "checks")
public class Check {
    @Id
    private String id;
    private Boolean llegada;
    private String idReserva;
    private String idUsuario;

    public Check(){}

    public Check(Boolean llegada, String idReserva, String idUsuario){
        this.llegada = llegada;
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
