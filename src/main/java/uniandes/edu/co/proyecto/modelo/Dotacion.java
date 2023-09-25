package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dotaciones")
public class Dotacion {

    //id
    //nombre
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;

    public Dotacion() 
    {;}

    public Dotacion(String nombre) {
        this.nombre = nombre;
    }

    //getters
    public Integer getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    //setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
