package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitaciondotacion")
public class HabitacionDotacion {

    @EmbeddedId
    private HabitacionDotacionPK pk;

    public HabitacionDotacion() 
    {;}

    public HabitacionDotacion(OfertaHabitacion idOfertaHabitacion, Dotacion idDotacion) 
    {
        this.pk = new HabitacionDotacionPK(idOfertaHabitacion, idDotacion);
    }

    public HabitacionDotacionPK getPk() {
        return this.pk;
    }

    public void setPk(HabitacionDotacionPK pk) {
        this.pk = pk;
    }
    
}
