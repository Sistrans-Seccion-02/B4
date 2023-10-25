ALTER TABLE "Check" DISABLE CONSTRAINT check_reservahabitaciones_fk;
ALTER TABLE "Check" DISABLE CONSTRAINT check_usuarios_fk;
ALTER TABLE consumos DISABLE CONSTRAINT consumos_reservas_fk;
ALTER TABLE habitacionesdotaciones DISABLE CONSTRAINT dotaciones_ofertas_fk;
ALTER TABLE habitacionesdotaciones DISABLE CONSTRAINT habitaciones_dotaciones_fk;
ALTER TABLE establecimiento DISABLE CONSTRAINT establecimiento_servicios_fk;
ALTER TABLE ofertashabitaciones DISABLE CONSTRAINT ofertas_usuarios_fk;
ALTER TABLE ofertashabitaciones DISABLE CONSTRAINT ofertashabitaciones_hoteles_fk;
ALTER TABLE ofrecen DISABLE CONSTRAINT ofrecen_establecimiento_fk;
ALTER TABLE ofrecen DISABLE CONSTRAINT ofrecen_productos_fk;
ALTER TABLE planservicio DISABLE CONSTRAINT planservicio_planesconsumo_fk;
ALTER TABLE planservicio DISABLE CONSTRAINT planservicio_servicios_fk;
ALTER TABLE reservahabitaciones DISABLE CONSTRAINT reservas_ofertas_fk;
ALTER TABLE reservahabitaciones DISABLE CONSTRAINT reservas_planes_fk;
ALTER TABLE reservahabitaciones DISABLE CONSTRAINT reservas_usuarios_fk;
ALTER TABLE reservaservicios DISABLE CONSTRAINT reservaservicios_servicios_fk;
ALTER TABLE seviciohotel DISABLE CONSTRAINT seviciohotel_hoteles_fk;
ALTER TABLE seviciohotel DISABLE CONSTRAINT seviciohotel_servicios_fk;

-- Eliminar las tablas en orden inverso
-- para evitar conflictos de dependencia
DROP TABLE reservaservicios;
DROP TABLE reservahabitaciones;
DROP TABLE planservicio;
DROP TABLE planesconsumo;
DROP TABLE ofrecen;
DROP TABLE ofertashabitaciones;
DROP TABLE establecimiento;
DROP TABLE habitacionesdotaciones;
DROP TABLE consumos;
DROP TABLE "Check";
DROP TABLE seviciohotel;
DROP TABLE productos;
DROP TABLE servicios;
DROP TABLE dotaciones;
DROP TABLE hoteles;
DROP TABLE usuarios;