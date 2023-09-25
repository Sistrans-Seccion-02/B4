package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Check;

public interface CheckRepository extends JpaRepository<Check, Integer> {

    //id 
    //llegada:bool para saber si es llegada o salida
    //fecha
    //idReserva
    //idUsuario

    //mostrar todos los checks sin importar si son de llegada o salida
    @Query(value = "SELECT * FROM check", nativeQuery = true)
    Collection<Check> mostrarChecks();

    //mostrar todos los checks que sean de llegada
    @Query(value = "SELECT * FROM check WHERE llegada = true", nativeQuery = true)
    Collection<Check> mostrarChecksLlegada();

    //mostrar todos los checks que sean de salida
    @Query(value = "SELECT * FROM check WHERE llegada = false", nativeQuery = true)
    Collection<Check> mostrarChecksSalida();

    //mostrar el check por id
    @Query(value = "SELECT * FROM check WHERE id = :id", nativeQuery = true)
    Check mostrarCheckPorId(@Param("id") Integer id);

    //mostrar los checks de un usuario
    @Query(value = "SELECT * FROM check WHERE idUsuario = :idUsuario", nativeQuery = true)
    Collection<Check> mostrarChecksPorUsuario(@Param("idUsuario") Integer idUsuario);

    //insertar check
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO check (llegada, fecha, idReserva, idUsuario) VALUES (:llegada, :fecha, :idReserva, :idUsuario)", nativeQuery = true)
    void insertarCheck(@Param("llegada") Boolean llegada, @Param("fecha") String fecha, 
    @Param("idReserva") Integer idReserva, @Param("idUsuario") Integer idUsuario);

    //actualizar check
    @Modifying
    @Transactional
    @Query(value = "UPDATE check SET llegada = :llegada, fecha = :fecha, idReserva = :idReserva, idUsuario = :idUsuario WHERE id = :id", nativeQuery = true)
    void actualizarCheck(@Param("id") Integer id, @Param("llegada") Boolean llegada, @Param("fecha") String fecha,
    @Param("idReserva") Integer idReserva, @Param("idUsuario") Integer idUsuario);

    //eliminar check
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM check WHERE id = :id", nativeQuery = true)
    void eliminarCheck(@Param("id") Integer id);

  

    
}
