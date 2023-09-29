package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.PlanServicio;

public interface PlanServicioRepository extends JpaRepository<PlanServicio, Integer> {

    //mostrar todas las relaciones planconsumo servicio
    @Query(value = "SELECT * FROM planservicio", nativeQuery = true)
    Collection<PlanServicio> mostrarPlanesServicios();

    //mostrar relacion planconsumo servicio por id
    @Query(value = "SELECT * FROM planservicio WHERE idPlanConsumo = :idPlanConsumo AND idServicio = :idServicio", nativeQuery = true)
    PlanServicio mostrarPlanServicioPorId(@Param("idPlanConsumo") Integer idPlanConsumo, @Param("idServicio") Integer idServicio);

    //insertar relacion planconsumo servicio
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planservicio (idPlanConsumo, idServicio) VALUES (:idPlanConsumo, :idServicio)", nativeQuery = true)
    void insertarPlanServicio(@Param("idPlanConsumo") Integer idPlanConsumo, @Param("idServicio") Integer idServicio);

    //actualizar relacion planconsumo servicio
    @Modifying
    @Transactional
    @Query(value = "UPDATE planservicio SET idPlanConsumo = :idPlanConsumo, idServicio = :idServicio WHERE idPlanConsumo = :idPlanConsumo AND idServicio = :idServicio", nativeQuery = true)
    void actualizarPlanServicio(@Param("idPlanConsumo") Integer idPlanConsumo, @Param("idServicio") Integer idServicio);

    //eliminar relacion planconsumo servicio
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planservicio WHERE idPlanConsumo = :idPlanConsumo AND idServicio = :idServicio", nativeQuery = true)
    void eliminarPlanServicio(@Param("idPlanServicio") Integer idPlanConsumo, @Param("idServicio") Integer idServicio);
}
