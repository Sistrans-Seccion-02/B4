package uniandes.edu.co.proyecto.nuevasClases;

import java.sql.Date;

public class fechas3 {
    public static Date fecha1;
    public static Date fecha2;
    public static String nombre;
    public static Number costo1;
    public static Number costo2;

    public void fechas(Date fecha1, Date fecha2, String nombre, Number costo1, Number costo2){
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
        this.nombre = nombre;
        this.costo1 = costo1;
        this.costo2 = costo2;
    }

    public void fechas()
    {;}

    public static Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public static Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public static String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public static Number getcosto1() {
        return costo1;
    }

    public void setcosto1(Number costo1) {
        this.costo1 = costo1;
    }

    public static Number getcosto2() {
        return costo2;
    }

    public void setcosto2(Number costo2) {
        this.costo2 = costo2;
    }
}
