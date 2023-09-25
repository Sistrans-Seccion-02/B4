package uniandes.edu.co.proyecto.modelo;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class HabitacionDotacionPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="idOfertaHabitacion", referencedColumnName = "id")
    private OfertaHabitacion idOfertaHabitacion;

    @ManyToOne
    @JoinColumn(name="idDotacion", referencedColumnName = "id")
    private Dotacion idDotacion;

    public HabitacionDotacionPK() 
    {
        super();
    }

    public HabitacionDotacionPK(OfertaHabitacion idOfertaHabitacion, Dotacion idDotacion) 
    {
        this.idOfertaHabitacion = idOfertaHabitacion;
        this.idDotacion = idDotacion;
    }

    //getters
    public OfertaHabitacion getIdOfertaHabitacion() {
        return this.idOfertaHabitacion;
    }

    public Dotacion getIdDotacion() {
        return this.idDotacion;
    }

    //setters

    public void setIdOfertaHabitacion(OfertaHabitacion idOfertaHabitacion) {
        this.idOfertaHabitacion = idOfertaHabitacion;
    }

    public void setIdDotacion(Dotacion idDotacion) {
        this.idDotacion = idDotacion;
    }


    
}
