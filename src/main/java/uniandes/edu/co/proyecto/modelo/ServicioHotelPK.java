package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ServicioHotelPK {

    @ManyToOne
    @JoinColumn(name="idServicio", referencedColumnName = "id")
    private Servicio idServicio;

    @ManyToOne
    @JoinColumn(name="idHotel", referencedColumnName = "id")
    private Hotel idHotel;

    public ServicioHotelPK() 
    {
        super();
    }

    public ServicioHotelPK(Servicio idServicio, Hotel idHotel) 
    {
        super();
        this.idServicio = idServicio;
        this.idHotel = idHotel;
    }

    //getters
    public Servicio getIdServicio() {
        return idServicio;
    }

    public Hotel getIdHotel() {
        return idHotel;
    }

    //setters

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public void setIdHotel(Hotel idHotel) {
        this.idHotel = idHotel;
    }
    
}
