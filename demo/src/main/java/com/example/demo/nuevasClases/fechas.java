package com.example.demo.nuevasClases;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class fechas {
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        public Date fecha1;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        public Date fecha2;
    
        public fechas(Date fecha1, Date fecha2){
            this.fecha1 = fecha1;
            this.fecha2 = fecha2;
            System.out.println("*****************");
            System.out.println(this.fecha1);
            System.out.println("***************a**");
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
    

