package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PlanServicioPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="idServicio", referencedColumnName = "id")
    private Servicio idServicio;

    @ManyToOne
    @JoinColumn(name="idPlanConsumo", referencedColumnName = "id")
    private PlanConsumo idPlanConsumo;

    public PlanServicioPK() 
    {
        super();
    }

    public PlanServicioPK(PlanConsumo idPlanConsumo, Servicio idServicio) 
    {
        super();
        this.idServicio = idServicio;
        this.idPlanConsumo = idPlanConsumo;
    }

    //getters
    public Servicio getIdServicio() {
        return idServicio;
    }

    public PlanConsumo getIdPlanConsumo() {
        return idPlanConsumo;
    }

    //setters

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public void setIdPlanConsumo(PlanConsumo idPlanConsumo) {
        this.idPlanConsumo = idPlanConsumo;
    }
}
