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
    @Query(value = "WITH ServiciosPorSemana AS (\r\n" + //
                    "    SELECT\r\n" + //
                    "        TO_CHAR(r.fechainicio, 'IYYY-IW') AS semana_del_anio,\r\n" + //
                    "        s.nombre AS servicio_mas_consumido,\r\n" + //
                    "        COUNT(*) AS cantidad_consumos,\r\n" + //
                    "        DENSE_RANK() OVER (PARTITION BY TO_CHAR(r.fechainicio, 'IYYY-IW') ORDER BY COUNT(*) DESC) AS ranking\r\n" + //
                    "    FROM\r\n" + //
                    "        reservaservicios r\r\n" + //
                    "    JOIN\r\n" + //
                    "        servicios s ON r.servicios_id = s.id\r\n" + //
                    "    GROUP BY\r\n" + //
                    "        TO_CHAR(r.fechainicio, 'IYYY-IW'), s.nombre\r\n" + //
                    ")\r\n" + //
                    "SELECT\r\n" + //
                    "    semana_del_anio,\r\n" + //
                    "    servicio_mas_consumido,\r\n" + //
                    "    cantidad_consumos\r\n" + //
                    "FROM\r\n" + //
                    "    ServiciosPorSemana\r\n" + //
                    "WHERE\r\n" + //
                    "    ranking = 1\r\n" + //
                    " ", nativeQuery = true)
    List<Object[]> findServicioMasConsumidoPorSemana();

    //req 11 servicio menos consumido por semana:
    @Query(value = " WITH ServiciosPorSemana AS (\r\n" + //
                    "    SELECT\r\n" + //
                    "        TO_CHAR(r.fechainicio, 'IYYY-IW') AS semana_del_anio,\r\n" + //
                    "        s.nombre AS servicio_menos_consumido,\r\n" + //
                    "        COUNT(*) AS cantidad_consumos,\r\n" + //
                    "        DENSE_RANK() OVER (PARTITION BY TO_CHAR(r.fechainicio, 'IYYY-IW') ORDER BY COUNT(*)) AS ranking\r\n" + //
                    "    FROM\r\n" + //
                    "        reservaservicios r\r\n" + //
                    "    JOIN\r\n" + //
                    "        servicios s ON r.servicios_id = s.id\r\n" + //
                    "    GROUP BY\r\n" + //
                    "        TO_CHAR(r.fechainicio, 'IYYY-IW'), s.nombre\r\n" + //
                    ")\r\n" + //
                    "SELECT\r\n" + //
                    "    semana_del_anio,\r\n" + //
                    "    servicio_menos_consumido,\r\n" + //
                    "    cantidad_consumos\r\n" + //
                    "FROM\r\n" + //
                    "    ServiciosPorSemana\r\n" + //
                    "WHERE\r\n" + //
                    "    ranking = 1", nativeQuery = true)
    List<Object[]> findServicioMenosConsumidoPorSemana();

    //req 11 habitacion mas solicitada por semana:
    @Query(value = "WITH HabitacionesSolicitadas AS (\r\n" + //
                    "    SELECT\r\n" + //
                    "        TO_CHAR(r.fechainicio, 'IYYY-IW') AS semana_del_anio,\r\n" + //
                    "        oh.tipohabitacion AS habitacion,\r\n" + //
                    "        COUNT(*) AS cantidad_solicitudes,\r\n" + //
                    "        RANK() OVER (PARTITION BY TO_CHAR(r.fechainicio, 'IYYY-IW') ORDER BY COUNT(*) DESC) AS ranking\r\n" + //
                    "    FROM\r\n" + //
                    "        reservahabitaciones r\r\n" + //
                    "    JOIN\r\n" + //
                    "        ofertashabitaciones oh ON r.ofertashabitaciones_id = oh.id\r\n" + //
                    "    GROUP BY\r\n" + //
                    "        TO_CHAR(r.fechainicio, 'IYYY-IW'), oh.tipohabitacion\r\n" + //
                    ")\r\n" + //
                    "SELECT\r\n" + //
                    "    semana_del_anio,\r\n" + //
                    "    habitacion AS habitacion_mas_solicitada,\r\n" + //
                    "    cantidad_solicitudes\r\n" + //
                    "FROM\r\n" + //
                    "    HabitacionesSolicitadas\r\n" + //
                    "WHERE\r\n" + //
                    "    ranking = 1", nativeQuery = true)
    List<Object[]> findHabitacionMasSolicitadaPorSemana();

    //req 11 habitacion menos solicitada por semana:
    @Query(value = "WITH HabitacionesSolicitadas AS (\r\n" + //
                    "    SELECT\r\n" + //
                    "        TO_CHAR(r.fechainicio, 'IYYY-IW') AS semana_del_anio,\r\n" + //
                    "        oh.tipohabitacion AS habitacion,\r\n" + //
                    "        COUNT(*) AS cantidad_solicitudes,\r\n" + //
                    "        RANK() OVER (PARTITION BY TO_CHAR(r.fechainicio, 'IYYY-IW') ORDER BY COUNT(*)) AS ranking\r\n" + //
                    "    FROM\r\n" + //
                    "        reservahabitaciones r\r\n" + //
                    "    JOIN\r\n" + //
                    "        ofertashabitaciones oh ON r.ofertashabitaciones_id = oh.id\r\n" + //
                    "    GROUP BY\r\n" + //
                    "        TO_CHAR(r.fechainicio, 'IYYY-IW'), oh.tipohabitacion\r\n" + //
                    ")\r\n" + //
                    "SELECT\r\n" + //
                    "    semana_del_anio,\r\n" + //
                    "    habitacion AS habitacion_menos_solicitada,\r\n" + //
                    "    cantidad_solicitudes\r\n" + //
                    "FROM\r\n" + //
                    "    HabitacionesSolicitadas\r\n" + //
                    "WHERE\r\n" + //
                    "    ranking = 1", nativeQuery = true)
    List<Object[]> findHabitacionMenosSolicitadaPorSemana();

}


