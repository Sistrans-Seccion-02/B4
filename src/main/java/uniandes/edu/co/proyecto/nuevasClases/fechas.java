package uniandes.edu.co.proyecto.nuevasClases;

import java.sql.Date;

public class fechas {
    public Date fecha1;
    public Date fecha2;

    public fechas(Date fecha1, Date fecha2){
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
    }

    public fechas()
    {;}

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    
}
