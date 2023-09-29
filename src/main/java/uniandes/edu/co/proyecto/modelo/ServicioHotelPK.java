package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Embeddable
public class ServicioHotelPK {

    @ManyToMany
    @JoinColumn(name="idServicio", referencedColumnName = "id")
    private Servicio idServicio;

    @ManyToMany
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
