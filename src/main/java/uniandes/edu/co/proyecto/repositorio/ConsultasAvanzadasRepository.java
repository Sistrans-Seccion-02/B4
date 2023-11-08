package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.List;


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

    //req 9 mod 1
    @Query(value ="SELECT rs.id, rs.fechafin, rs.nombre_servicio, u.id, u.nombre FROM " 
                    +"RESERVASERVICIOS rs JOIN " 
                    +"OFERTASHABITACIONES oh ON rs.habitacion_id  = oh.id "
                    +"JOIN USUARIOS u "
                    +"ON u.id = oh.usuarios_id "
                    +"WHERE rs.fechainicio >= :fecha1 AND rs.fechafin <= :fecha2 "
                    +"ORDER BY rs.fechafin DESC", nativeQuery = true)
    List<Object[]> r9mod1(@Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2);
    
    //req 9 mod 2
    @Query(value ="SELECT rs.id, rs.fechafin, rs.nombre_servicio, u.id, u.nombre FROM " 
                    +"RESERVASERVICIOS rs JOIN " 
                    +"OFERTASHABITACIONES oh ON rs.habitacion_id  = oh.id "
                    +"JOIN USUARIOS u "
                    +"ON u.id = oh.usuarios_id "
                    +"WHERE rs.fechainicio >= :fecha1 AND rs.fechafin <= :fecha2 "
                    +"ORDER BY u.id DESC", nativeQuery = true)
    List<Object[]> r9mod2(@Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2);


    //req 9 mod 3
    @Query(value ="SELECT rs.id, rs.fechafin, rs.nombre_servicio, u.id, u.nombre FROM " 
                    +"RESERVASERVICIOS rs JOIN " 
                    +"OFERTASHABITACIONES oh ON rs.habitacion_id  = oh.id "
                    +"JOIN USUARIOS u "
                    +"ON u.id = oh.usuarios_id "
                    +"WHERE rs.fechainicio >= :fecha1 AND rs.fechafin <= :fecha2 "
                    +"ORDER BY u.nombre DESC", nativeQuery = true)
    List<Object[]> r9mod3(@Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2);

    //req 9 mod 4
    @Query(value ="SELECT rs.id, rs.fechafin, rs.nombre_servicio, u.id, u.nombre FROM " 
                    +"RESERVASERVICIOS rs JOIN " 
                    +"OFERTASHABITACIONES oh ON rs.habitacion_id  = oh.id "
                    +"JOIN USUARIOS u "
                    +"ON u.id = oh.usuarios_id "
                    +"WHERE rs.fechainicio >= :fecha1 AND rs.fechafin <= :fecha2 "
                    +"ORDER BY rs.nombre_servicio DESC", nativeQuery = true)
    List<Object[]> r9mod4(@Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2);



    //req 10
    @Query(value ="SELECT u1.id, u1.nombre, u1.apellido FROM usuarios u1\r\n" + //
            "WHERE u1.id NOT IN (\r\n" + //
            "SELECT u.id FROM \r\n" + //
            "RESERVASERVICIOS rs JOIN \r\n" + //
            "OFERTASHABITACIONES oh ON rs.habitacion_id  = oh.id\r\n" + //
            "JOIN USUARIOS u\r\n" + //
            "ON u.id = oh.usuarios_id\r\n" + //
            "WHERE rs.fechainicio >= '01-FEB-2023' AND rs.fechafin <= '04-FEB-2023')", nativeQuery = true)
    List<Object[]> r10(@Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2); 

    //req 10 mod 1
    @Query(value ="SELECT u1.id, u1.nombre, u1.apellido FROM usuarios u1\r\n" + //
            "WHERE u1.id NOT IN (\r\n" + //
            "SELECT u.id FROM \r\n" + //
            "RESERVASERVICIOS rs JOIN \r\n" + //
            "OFERTASHABITACIONES oh ON rs.habitacion_id  = oh.id\r\n" + //
            "JOIN USUARIOS u\r\n" + //
            "ON u.id = oh.usuarios_id\r\n" + //
            "WHERE rs.fechainicio >= :fecha1 AND rs.fechafin <= :fecha2) "
            +"ORDER BY u1.nombre", nativeQuery = true)
    List<Object[]> r10mod1(@Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2);


    //req 10 mod 2
    @Query(value ="SELECT u1.id, u1.nombre, u1.apellido FROM usuarios u1\r\n" + //
            "WHERE u1.id NOT IN (\r\n" + //
            "SELECT u.id FROM \r\n" + //
            "RESERVASERVICIOS rs JOIN \r\n" + //
            "OFERTASHABITACIONES oh ON rs.habitacion_id  = oh.id\r\n" + //
            "JOIN USUARIOS u\r\n" + //
            "ON u.id = oh.usuarios_id\r\n" + //
            "WHERE rs.fechainicio >= :fecha1 AND rs.fechafin <= :fecha2) "
            +"ORDER BY u1.id", nativeQuery = true)
    List<Object[]> r10mod2(@Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2);


    //req 11 Servicio más consumido por semana:
    @Query("SELECT TO_CHAR(r.fechainicio, 'IYYY-IW') AS semanaDelAnio, s.nombre AS servicioMasConsumido, COUNT(*) AS cantidadConsumos " +
    "FROM ReservaServicios r " +
    "JOIN r.servicio s " +
    "GROUP BY TO_CHAR(r.fechainicio, 'IYYY-IW'), s.nombre " +
    "HAVING COUNT(*) = (" +
        "SELECT MAX(count(*)) " +
        "FROM ReservaServicios r2 " +
        "WHERE TO_CHAR(r.fechainicio, 'IYYY-IW') = TO_CHAR(r2.fechainicio, 'IYYY-IW') " +
        "GROUP BY r2.servicio.id);")
    List<Object[]> findServicioMasConsumidoPorSemana();

    //req 11 servicio menos consumido por semana:
    @Query("SELECT TO_CHAR(r.fechainicio, 'IYYY-IW') AS semanaDelAnio, s.nombre AS servicioMenosConsumido, COUNT(*) AS cantidadConsumos " +
    "FROM ReservaServicios r " +
    "JOIN r.servicio s " +
    "GROUP BY TO_CHAR(r.fechainicio, 'IYYY-IW'), s.nombre " +
    "HAVING COUNT(*) = (" +
        "SELECT MIN(count(*)) " +
        "FROM ReservaServicios r2 " +
        "WHERE TO_CHAR(r.fechainicio, 'IYYY-IW') = TO_CHAR(r2.fechainicio, 'IYYY-IW') " +
        "GROUP BY r2.servicio.id" +
     ")")
    List<Object[]> findServicioMenosConsumidoPorSemana();

    //req 11 habitacion mas solicitada por semana:
    @Query("SELECT TO_CHAR(r.fechainicio, 'IYYY-IW') AS semanaDelAnio, oh.tipohabitacion AS habitacionMasSolicitada, COUNT(*) AS cantidadSolicitudes " +
    "FROM ReservaHabitaciones r " +
    "JOIN r.ofertashabitaciones oh " +
    "GROUP BY TO_CHAR(r.fechainicio, 'IYYY-IW'), oh.tipohabitacion " +
    "HAVING RANK() OVER (PARTITION BY TO_CHAR(r.fechainicio, 'IYYY-IW') ORDER BY COUNT(*) DESC) = 1")
    List<Object[]> findHabitacionMasSolicitadaPorSemana();

    //req 11 habitacion menos solicitada por semana:
    @Query("SELECT TO_CHAR(r.fechainicio, 'IYYY-IW') AS semanaDelAnio, oh.tipohabitacion AS habitacionMenosSolicitada, COUNT(*) AS cantidadSolicitudes " +
    "FROM ReservaHabitaciones r " +
    "JOIN r.ofertashabitaciones oh " +
    "GROUP BY TO_CHAR(r.fechainicio, 'IYYY-IW'), oh.tipohabitacion " +
    "HAVING RANK() OVER (PARTITION BY TO_CHAR(r.fechainicio, 'IYYY-IW') ORDER BY COUNT(*)) = 1")
    List<Object[]> findHabitacionMenosSolicitadaPorSemana();

}


