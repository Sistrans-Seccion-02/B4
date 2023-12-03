package com.example.demo.modelo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "tipos_habitacion")
public class TipoHabitacion{

    @Id
    private String id;

    private String tipo;

    private String dotacion;

    public TipoHabitacion(){}

    public TipoHabitacion(String tipo, String dotacion){
        this.tipo = tipo;
        this.dotacion = dotacion;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDotacion() {
        return this.dotacion;
    }

    public void setDotacion(String dotacion) {
        this.dotacion = dotacion;
    }

}