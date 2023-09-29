package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "planesservicios")
public class PlanServicio {

    @EmbeddedId
    private PlanServicioPK pk;

    public PlanServicio() 
    {;}

    public PlanServicio(PlanConsumo idPlanConsumo, Servicio idServicio) 
    {
        this.pk = new PlanServicioPK(idPlanConsumo, idServicio);
    }

    public PlanServicioPK getPk() {
        return this.pk;
    }

    public void setPk(PlanServicioPK pk) {
        this.pk = pk;
    }
    
}
