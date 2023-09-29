package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios")
public class Servicio {

    //id
    //nombre
    //costo
    //descripcion

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;

    private Float costo;

    private String descripcion;

    public Servicio() 
    {;}

    public Servicio(Integer id, String nombre, Float costo, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = descripcion;
    }

    //getters
    public Integer getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Float getCosto() {
        return this.costo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    //setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
