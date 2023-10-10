package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Column;
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
    @Column (name = "descripcion")
    private String descripcion;
    @Column (name = "costo")
    private Float costo;
    @Column (name = "fecha")
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name="reservahabitaciones_id", referencedColumnName = "id")
    private ReservaHabitacion idReserva;

    public Consumo(Integer id, String descripcion, Float costo, Date fecha, ReservaHabitacion idReserva)
    {
        this.id = id;
        this.descripcion = descripcion;
        this.costo = costo;
        this.fecha = fecha;
        this.idReserva = idReserva;
    }

    public Consumo()
    {;}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ReservaHabitacion getIdReserva() {
        return this.idReserva;
    }

    public void setIdReserva(ReservaHabitacion idReserva) {
        this.idReserva = idReserva;
    }


    

}
