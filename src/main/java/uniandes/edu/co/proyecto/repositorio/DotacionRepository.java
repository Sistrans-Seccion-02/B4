package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Dotacion;

public interface DotacionRepository extends JpaRepository<Dotacion, Integer> {

 
    //id
    //nombre

    //mostrar todas las dotaciones
    @Query(value = "SELECT * FROM dotacion", nativeQuery = true)
    Collection<Dotacion> mostrarDotaciones();

    //mostrar dotacion por id
    @Query(value = "SELECT * FROM dotacion WHERE id = :id", nativeQuery = true)
    Dotacion mostrarDotacionPorId(@Param("id") Integer id);

    //insertar dotacion
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO dotacion (nombre) VALUES (:nombre)", nativeQuery = true)
    void insertarDotacion(@Param("nombre") String nombre);

    //actualizar dotacion
    @Modifying
    @Transactional
    @Query(value = "UPDATE dotacion SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarDotacion(@Param("id") Integer id, @Param("nombre") String nombre);

    //eliminar dotacion
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM dotacion WHERE id = :id", nativeQuery = true)
    void eliminarDotacion(@Param("id") Integer id);

    
    
    
}
