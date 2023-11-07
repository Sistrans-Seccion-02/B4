INSERT INTO usuarios (id, nombre, apellido, correo, rol) VALUES (1, 'Juan', 'Pérez', 'juan.perez@example.com', 'Cliente');
INSERT INTO usuarios (id, nombre, apellido, correo, rol) VALUES (2, 'Ana', 'Gómez', 'ana.gomez@example.com', 'Cliente');
INSERT INTO usuarios (id, nombre, apellido, correo, rol) VALUES (3, 'Carlos', 'López', 'carlos.lopez@example.com', 'Empleado');

INSERT INTO hoteles (id, nombre, ubicacion) VALUES (1, 'Hotel A', 'Ciudad A');
INSERT INTO hoteles (id, nombre, ubicacion) VALUES(2, 'Hotel B', 'Ciudad B');


INSERT INTO planesconsumo (id, nombre, descuento) VALUES (1, 'Plan A', 10);
INSERT INTO planesconsumo (id, nombre, descuento) VALUES(2, 'Plan B', 15);

INSERT INTO reservahabitaciones (id, fechainicio, fechafin, pago, planesconsumo_id, ofertashabitaciones_id, usuarios_id) VALUES (1, TO_DATE('2023-10-02', 'YYYY-MM-DD'), TO_DATE('2023-10-05', 'YYYY-MM-DD'), 280.00, 1, 1, 1);
INSERT INTO reservahabitaciones (id, fechainicio, fechafin, pago, planesconsumo_id, ofertashabitaciones_id, usuarios_id) VALUES(2, TO_DATE('2023-10-07', 'YYYY-MM-DD'), TO_DATE('2023-10-10', 'YYYY-MM-DD'), 200.00, 2, 2, 2);


INSERT INTO servicios (id, nombre, costo, descripcion) VALUES (1, 'Desayuno', 10.00, 'Desayuno continental incluido');
INSERT INTO servicios (id, nombre, costo, descripcion) VALUES(2, 'Wi-Fi', 5.00, 'Acceso a Internet de alta velocidad');
INSERT INTO servicios (id, nombre, costo, descripcion) VALUES(3, 'Piscina', 20.00, 'Acceso a la piscina');

INSERT INTO dotaciones (id, nombre) VALUES (1, 'Toallas');
INSERT INTO dotaciones (id, nombre) VALUES(2, 'Artículos de aseo');

INSERT INTO productos (id, costo, descripcion) VALUES (1, 5.00, 'Bebidas en el minibar');
INSERT INTO productos (id, costo, descripcion) VALUES(2, 8.00, 'Snacks en la habitación');

INSERT INTO ofrecen (establecimiento_id, productos_id) VALUES(1, 1);
INSERT INTO ofrecen (establecimiento_id, productos_id) VALUES(1, 2);
INSERT INTO ofrecen (establecimiento_id, productos_id) VALUES(2, 1);

INSERT INTO habitacionesdotaciones (ofertashabitaciones_id, dotaciones_id) VALUES(1, 1);
INSERT INTO habitacionesdotaciones (ofertashabitaciones_id, dotaciones_id) VALUES(1, 2);
INSERT INTO habitacionesdotaciones (ofertashabitaciones_id, dotaciones_id) VALUES(2, 1);