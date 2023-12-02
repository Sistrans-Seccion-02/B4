package com.example.demo.modelo;

import java.lang.annotation.Inherited;
import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "servicios")
public class servicio {

    //atributos
    // IdServicio:Int
    // Nombre: String
    // Capacidad: Int
    // Profundidad: Int
    // Maquinas: Int
    // Estilo: String
    // Tipo: String
    // Tipo_Prenda: String
    // Num_Prenda: Int
    // Utensilio: String
    // Multa: Float
    // Devuelto: Bool
    // Inicio_Servicio: Date
    // Fin_Servicio: Date
    // Costo: Float
    // Productos: ProductosEmbedded

    @Id
    private String id;

    // Nombre del servicio
    private String nombre;

    // Capacidad del servicio
    private int capacidad;

    // Profundidad del servicio
    private int profundidad;

    // Numero de maquinas del servicio
    private int maquinas;

    // Estilo del servicio
    private String estilo;

    // Tipo de servicio
    private String tipo;

    // Tipo de prenda
    private String tipo_prenda;

    // Numero de prendas
    private int num_prenda;

    // Utensilio del servicio
    private String utensilio;

    // Multa del servicio
    private float multa;

    // Devuelto del servicio
    private boolean devuelto;

    // Inicio del servicio
    private Date inicio_servicio;

    // Fin del servicio
    private Date fin_servicio;


    // Costo del servicio
    private float costo;

    // Productos del servicio
    private List<ProductosEmbedded> productos;

    // Constructor vacio para el uso de Spring
    public servicio(){}

    public servicio(String nombre, int capacidad, int profundidad, int maquinas, String estilo, String tipo, String tipo_prenda, int num_prenda, String utensilio, float multa, boolean devuelto, Date inicio_servicio, Date fin_servicio, float costo, List<ProductosEmbedded> productos) {
        
        //Constructor con atributos. Note que si no se define una id, mongo genera una automaticamente 
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.profundidad = profundidad;
        this.maquinas = maquinas;
        this.estilo = estilo;
        this.tipo = tipo;
        this.tipo_prenda = tipo_prenda;
        this.num_prenda = num_prenda;
        this.utensilio = utensilio;
        this.multa = multa;
        this.devuelto = devuelto;
        this.inicio_servicio = inicio_servicio;
        this.fin_servicio = fin_servicio;
        this.costo = costo;
        this.productos = productos;
    }

    //<---------- Getters and Setters ---------->
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String name){
        this.nombre = name;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
    }

    public int getProfundidad(){
        return profundidad;
    }

    public void setProfundidad(int profundidad){
        this.profundidad = profundidad;
    }

    public int getMaquinas(){
        return maquinas;
    }

    public void setMaquinas(int maquinas){
        this.maquinas = maquinas;
    }

    public String getEstilo(){
        return estilo;
    }

    public void setEstilo(String estilo){
        this.estilo = estilo;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo_Prenda(){
        return tipo_prenda;
    }

    public void setTipo_Prenda(String tipo_prenda){
        this.tipo_prenda = tipo_prenda;
    }

    public int getNum_Prenda(){
        return num_prenda;
    }

    public void setNum_Prenda(int num_prenda){
        this.num_prenda = num_prenda;
    }

    public String getUtensilio(){
        return utensilio;
    }

    public void setUtensilio(String utensilio){
        this.utensilio = utensilio;
    }

    public float getMulta(){
        return multa;
    }

    public void setMulta(float multa){
        this.multa = multa;
    }

    public boolean getDevuelto(){
        return devuelto;
    }

    public void setDevuelto(boolean devuelto){
        this.devuelto = devuelto;
    }

    public Date getInicio_Servicio(){
        return inicio_servicio;
    }

    public void setInicio_Servicio(Date inicio_servicio){
        this.inicio_servicio = inicio_servicio;
    }

    public Date getFin_Servicio(){
        return fin_servicio;
    }

    public void setFin_Servicio(Date fin_servicio){
        this.fin_servicio = fin_servicio;
    }

    public float getCosto(){
        return costo;
    }

    public void setCosto(float costo){
        this.costo = costo;
    }

    public List<ProductosEmbedded> getProductos(){
        return productos;
    }

    public void setProductos(List<ProductosEmbedded> productos){
        this.productos = productos;
    }

    public void addProducto(ProductosEmbedded producto){
        this.productos.add(producto);
    }

    
}
