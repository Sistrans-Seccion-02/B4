package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

     //mostrar todos los servicios
     @Query(value = "SELECT * FROM servicio", nativeQuery = true)
     Collection<Servicio> mostrarServicios();
 
     //mostrar servicio por id
     @Query(value = "SELECT * FROM servicio WHERE id = :id", nativeQuery = true)
     Servicio mostrarServicioPorId(@Param("id") Integer id);
 
     //insertar servicio
     @Modifying
     @Transactional
     @Query(value = "INSERT INTO servicio (id, nombre, costo, descripcion) VALUES (:id, :nombre, :costo, :descripcion)", nativeQuery = true)
     void insertarServicio(@Param("id") int id, @Param("nombre") String nombre, 
     @Param("costo") Float costo, @Param("descripcion") String descripcion);
 
     //actualizar servicio
     @Modifying
     @Transactional
     @Query(value = "UPDATE servicio SET nombre = :nombre, costo = :costo, descripcion = :descripcion WHERE id = :id", nativeQuery = true)
     void actualizarServicio(@Param("id") Integer id, @Param("nombre") String nombre, 
     @Param("costo") Float costo, @Param("descripcion") String descripcion);
 
     //eliminar servicio
     @Modifying
     @Transactional
     @Query(value = "DELETE FROM servicio WHERE id = :id", nativeQuery = true)
     void eliminarServicio(@Param("id") Integer id);
}
