package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planesconsumo")
public class PlanConsumo {

    //id
    //nombre
    //descuento

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;

    private Float descuento;

    public PlanConsumo() 
    {;}

    public PlanConsumo(Integer id, String nombre, Float descuento) {
        this.id = id;
        this.nombre = nombre;
        this.descuento = descuento;
    }

    //getters
    public Integer getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Float getDescuento() {
        return this.descuento;
    }

    //setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }
}
