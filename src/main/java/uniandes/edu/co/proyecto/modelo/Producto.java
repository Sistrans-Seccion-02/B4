package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Float costo;
    private String descripcion;
    
    public Producto(Integer id, Float costo, String descripcion)
    {
        this.id = id;
        this.costo = costo;
        this.descripcion = descripcion;
    }

    public Producto()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}