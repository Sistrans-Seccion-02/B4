package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Establecimiento;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Integer>{
    
    //mostrar todos los establecimientos
    @Query(value = "SELECT * FROM establecimientos", nativeQuery = true)
    Collection<Establecimiento> mostrarEstablecimientos();

    //mostrar establecimiento por id
    @Query(value = "SELECT * FROM establecimientos WHERE id = :id", nativeQuery = true)
    Establecimiento mostrarEstablecimientoPorId(@Param("id") Integer id);
    
    //Insertar establecimiento
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO establecimiento(nombre, capacidad) VALUES (:nombre, :capacidad)", nativeQuery = true)
    void insertarEstablecimiento(@Param("nombre") String nombre, @Param("capacidad") Integer capacidad);

    //Actualizar establecimiento
    @Modifying
    @Transactional
    @Query(value = "UPDATE establecimientos SET nombre = :nombre, capacidad = :capacidad WHERE id = :id", nativeQuery = true)
    void actualizarEstablecimiento(@Param("id") Integer id, @Param("nombre") String nombre, @Param("capacidad") Integer capacidad);

    //Borrar Establecimiento
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM establecimientos WHERE id = :id", nativeQuery = true)
    void eliminarEstablecimiento(@Param("id") Integer id);
}
