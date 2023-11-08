--Req1
SELECT habitacion_id, sum(pago) as pago FROM reservaservicios
WHERE fechafin >= ADD_MONTHS(TRUNC(SYSDATE),-12) AND fechafin < TRUNC(SYSDATE)
GROUP BY habitacion_id;

--Req2
SELECT nombre_servicio, sum(existe) as existe FROM reservaservicios
WHERE fechafin <= :fecha2 AND fechafin >= :fecha1
GROUP BY nombre_servicio
ORDER BY existe DESC;

--Req3
SELECT habitacion_id, sum(existe) as existe FROM ofertashabitaciones
WHERE fechafin >= ADD_MONTHS(TRUNC(SYSDATE),-12) AND fechafin < TRUNC(SYSDATE)
GROUP BY habitacion_id;

--Req4
--Filtro por fecha
SELECT s.id, s.nombre, s.costo, s.descripcion
FROM servicios s
JOIN reservaservicios rs ON s.id = rs.servicios_id
WHERE fechafin <= :fecha2 AND fechafin >= :fecha1;

--Filtro por categoría
SELECT s.id, s.nombre, s.costo, s.descripcion
FROM servicios s
JOIN reservaservicios rs ON s.id = rs.servicios_id
WHERE lower(nombre) = lower(:nombre1);

--Filtro por precio
SELECT s.id, s.nombre, s.costo, s.descripcion
FROM servicios s
JOIN reservaservicios rs ON s.id = rs.servicios_id
WHERE costo <= :costo2 AND costo >= :costo1;

--Req5
CREATE INDEX id_consumos_fecha ON consumos (fecha);

SELECT h.nombre AS hotel_nombre,
       c.fecha AS fecha_consumo,
       c.descripcion AS descripcion_consumo,
       c.costo AS costo_consumo
FROM hoteles h
       JOIN ofertashabitaciones oh ON h.id = oh.hoteles_id
       JOIN reservahabitaciones rh ON oh.id = rh.ofertashabitaciones_id
       JOIN consumos c ON rh.id = c.reservahabitaciones_id
       JOIN usuarios u ON rh.usuarios_id = u.id
 WHERE u.id = :id
   AND c.fecha BETWEEN :fecha1 AND :fecha2;

--Req6
--Mayor Ocupación
SELECT fechainicio, COUNT(*) 
FROM reservahabitaciones
GROUP BY fechainicio
ORDER BY COUNT(*) DESC;

--Menor Ocupación
SELECT fechainicio, COUNT(*) 
FROM reservahabitaciones
GROUP BY fechainicio
ORDER BY COUNT(*) ASC;

--Mayores Consumos
SELECT fecha, SUM(costo) 
FROM consumos
GROUP BY fecha
ORDER BY SUM(costo) DESC;

--Req7
SELECT u.id AS usuario_id, u.nombre AS nombre_usuario,
        u.apellido AS apellido_usuario,
    SUM(CASE WHEN r.fechafin >= SYSDATE - 365 THEN r.pago ELSE 0 END) AS total_pagos_ultimo_anio,
    SUM(CASE WHEN o.fechainicio >= SYSDATE - 365 THEN (o.fechafin - o.fechainicio) ELSE 0 END) AS total_dias_estadia_ultimo_anio
FROM usuarios u
LEFT JOIN reservahabitaciones r ON u.id = r.usuarios_id
LEFT JOIN ofertashabitaciones o ON r.ofertashabitaciones_id = o.id
GROUP BY u.id, u.nombre, u.apellido
HAVING SUM(CASE WHEN r.fechafin >= SYSDATE - 365 THEN r.pago ELSE 0 END) > 15000000
OR SUM(CASE WHEN o.fechainicio >= SYSDATE - 365 THEN (o.fechafin - o.fechainicio) ELSE 0 END) >= 14;


--Req8
SELECT s.id, s.nombre, COUNT(rs.id) AS veces_solicitado
FROM servicios s
LEFT JOIN reservaservicios rs ON s.id = rs.servicios_id
WHERE rs.fechainicio >= (SYSDATE - 365)
GROUP BY s.id, s.nombre
HAVING COUNT(rs.id) < 3;

--Req9
SELECT rs.id, rs.fechafin, rs.nombre_servicio, u.id, u.nombre FROM
RESERVASERVICIOS rs JOIN
OFERTASHABITACIONES oh ON rs.habitacion_id  = oh.id
JOIN USUARIOS u ON u.id = oh.usuarios_id
WHERE rs.fechainicio >= :fecha1 AND rs.fechafin <= :fecha2;

--Req10
SELECT u1.id, u1.nombre, u1.apellido FROM usuarios u1
WHERE u1.id NOT IN
(SELECT u.id FROM
RESERVASERVICIOS rs JOIN
OFERTASHABITACIONES oh ON rs.habitacion_id  = oh.id
JOIN USUARIOS u
ON u.id = oh.usuarios_id
WHERE rs.fechainicio >= '01-FEB-2023' AND rs.fechafin <= '04-FEB-2023');

--Req11
--Servicio más consumido por semana:
WITH ServiciosPorSemana AS (
    SELECT
        TO_CHAR(r.fechainicio, 'IYYY-IW') AS semana_del_anio,
        s.nombre AS servicio_mas_consumido,
        COUNT(*) AS cantidad_consumos,
        DENSE_RANK() OVER (PARTITION BY TO_CHAR(r.fechainicio, 'IYYY-IW') ORDER BY COUNT(*) DESC) AS ranking
    FROM
        reservaservicios r
    JOIN
        servicios s ON r.servicios_id = s.id
    GROUP BY
        TO_CHAR(r.fechainicio, 'IYYY-IW'), s.nombre
)
SELECT
    semana_del_anio,
    servicio_mas_consumido,
    cantidad_consumos
FROM
    ServiciosPorSemana
WHERE
    ranking = 1;

--Servicio menos consumido por semana:
WITH ServiciosPorSemana AS (
    SELECT
        TO_CHAR(r.fechainicio, 'IYYY-IW') AS semana_del_anio,
        s.nombre AS servicio_menos_consumido,
        COUNT(*) AS cantidad_consumos,
        DENSE_RANK() OVER (PARTITION BY TO_CHAR(r.fechainicio, 'IYYY-IW') ORDER BY COUNT(*)) AS ranking
    FROM
        reservaservicios r
    JOIN
        servicios s ON r.servicios_id = s.id
    GROUP BY
        TO_CHAR(r.fechainicio, 'IYYY-IW'), s.nombre
)
SELECT
    semana_del_anio,
    servicio_menos_consumido,
    cantidad_consumos
FROM
    ServiciosPorSemana
WHERE
    ranking = 1;

--Habitaciones más solicitadas por semana:
WITH HabitacionesSolicitadas AS (
    SELECT
        TO_CHAR(r.fechainicio, 'IYYY-IW') AS semana_del_anio,
        oh.tipohabitacion AS habitacion,
        COUNT(*) AS cantidad_solicitudes,
        RANK() OVER (PARTITION BY TO_CHAR(r.fechainicio, 'IYYY-IW') ORDER BY COUNT(*) DESC) AS ranking
    FROM
        reservahabitaciones r
    JOIN
        ofertashabitaciones oh ON r.ofertashabitaciones_id = oh.id
    GROUP BY
        TO_CHAR(r.fechainicio, 'IYYY-IW'), oh.tipohabitacion
)
SELECT
    semana_del_anio,
    habitacion AS habitacion_mas_solicitada,
    cantidad_solicitudes
FROM
    HabitacionesSolicitadas
WHERE
    ranking = 1;

--Habitaciones menos solicitadas por semana:
WITH HabitacionesSolicitadas AS (
    SELECT
        TO_CHAR(r.fechainicio, 'IYYY-IW') AS semana_del_anio,
        oh.tipohabitacion AS habitacion,
        COUNT(*) AS cantidad_solicitudes,
        RANK() OVER (PARTITION BY TO_CHAR(r.fechainicio, 'IYYY-IW') ORDER BY COUNT(*)) AS ranking
    FROM
        reservahabitaciones r
    JOIN
        ofertashabitaciones oh ON r.ofertashabitaciones_id = oh.id
    GROUP BY
        TO_CHAR(r.fechainicio, 'IYYY-IW'), oh.tipohabitacion
)
SELECT
    semana_del_anio,
    habitacion AS habitacion_menos_solicitada,
    cantidad_solicitudes
FROM
    HabitacionesSolicitadas
WHERE
    ranking = 1;
