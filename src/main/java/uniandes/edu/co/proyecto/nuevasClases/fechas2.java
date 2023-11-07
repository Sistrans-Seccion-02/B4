package uniandes.edu.co.proyecto.nuevasClases;

import java.sql.Date;

public class fechas2 {
    public Date fecha1;
    public Date fecha2;
    public Integer id;

    public fechas2(Date fecha1, Date fecha2){
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
     
    }

    public fechas2()
    {;}

    public Date getFecha1() {
        return this.fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return this.fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
}

