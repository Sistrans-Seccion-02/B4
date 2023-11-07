package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.List;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.ReservaServ;

public interface ConsultasAvanzadasRepository extends JpaRepository<ReservaServ, Integer>{
    
    //req 9
    @Query(value ="SELECT rs.id, rs.fechafin, rs.nombre_servicio, u.id, u.nombre FROM " 
                    +"RESERVASERVICIOS rs JOIN " 
                    +"OFERTASHABITACIONES oh ON rs.habitacion_id  = oh.id "
                    +"JOIN USUARIOS u "
                    +"ON u.id = oh.usuarios_id "
                    +"WHERE rs.fechainicio >= :fecha1 AND rs.fechafin <= :fecha2", nativeQuery = true)
    List<Object[]> r9(@Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2);               

}
