package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "consumos")
public class Consumo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String descripcion;

    private Float costo;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name="idReserva", referencedColumnName = "id")
    private ReservaHabitacion idReserva;

    public Consumo(Integer id, String descripcion, Float costo, Date fecha)
    {
        this.id = id;
        this.descripcion = descripcion;
        this.costo = costo;
        this.fecha = fecha;
    }

    public Consumo()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ReservaHabitacion getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(ReservaHabitacion idReserva) {
        this.idReserva = idReserva;
    }


    

}
