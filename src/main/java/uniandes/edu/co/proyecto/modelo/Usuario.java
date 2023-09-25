package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "usuarios")
public class Usuario {
    //id
    //nombre
    //apellido
    //correo
    //rol
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String nombre;

    private String apellido;

    private String correo;

    private String rol;

    public Usuario() 
    {;}

    public Usuario(String nombre, String apellido, String correo, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.rol = rol;
    }

    //getters
    public Integer getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRol() {
        return rol;
    }

    //setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public void setApellido(String apellido) {
        this.apellido=apellido;
    }

    public void setCorreo(String correo) {
        this.correo=correo;
    }

    public void setRol(String rol) {
        this.rol=rol;
    }


}
