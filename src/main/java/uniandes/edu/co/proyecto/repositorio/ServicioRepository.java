package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

     //mostrar todos los servicios
     @Query(value = "SELECT * FROM servicios", nativeQuery = true)
     Collection<Servicio> mostrarServicios();
 
     //mostrar servicio por id
     @Query(value = "SELECT * FROM servicios WHERE id = :id", nativeQuery = true)
     Servicio mostrarServicioPorId(@Param("id") Integer id);
 
     //insertar servicio
     @Modifying
     @Transactional
     @Query(value = "INSERT INTO servicios (id, nombre, costo, descripcion) VALUES (:id, :nombre, :costo, :descripcion)", nativeQuery = true)
     void insertarServicio(@Param("id") int id, @Param("nombre") String nombre, 
     @Param("costo") Float costo, @Param("descripcion") String descripcion);
 
     //actualizar servicio
     @Modifying
     @Transactional
     @Query(value = "UPDATE servicios SET nombre = :nombre, costo = :costo, descripcion = :descripcion WHERE id = :id", nativeQuery = true)
     void actualizarServicio(@Param("id") Integer id, @Param("nombre") String nombre, 
     @Param("costo") Float costo, @Param("descripcion") String descripcion);
 
     //eliminar servicio
     @Modifying
     @Transactional
     @Query(value = "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
     void eliminarServicio(@Param("id") Integer id);

     //servicios con no mucha demanda
     @Query(value = "SELECT s.id, s.nombre, COUNT(rs.id) AS veces_solicitado " +
    "FROM servicios s " +
    "LEFT JOIN reservaservicios rs ON s.id = rs.servicios_id " +
    "WHERE rs.fechainicio >= (SYSDATE - 365) " +
    "GROUP BY s.id, s.nombre " +
    "HAVING COUNT(rs.id) < 3", nativeQuery = true)
     List<Object[]> obtenerServiciosMenosSolicitados();
}
