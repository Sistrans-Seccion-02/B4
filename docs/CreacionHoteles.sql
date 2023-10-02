-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2023-09-24 17:53:03 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE "Check" (
    id                     INTEGER NOT NULL,
    llegada                CHAR(1),
    fecha                  DATE,
    usuarios_id            INTEGER NOT NULL,
    reservahabitaciones_id INTEGER NOT NULL
);

ALTER TABLE "Check" ADD CONSTRAINT check_pk PRIMARY KEY ( id );

CREATE TABLE consumos (
    id                     INTEGER NOT NULL,
    descripcion            VARCHAR2(150 CHAR),
    costo                  FLOAT,
    fecha                  DATE,
    reservahabitaciones_id INTEGER NOT NULL
);

ALTER TABLE consumos ADD CONSTRAINT consumos_pk PRIMARY KEY ( id );

CREATE TABLE dotaciones (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(50 CHAR)
);

ALTER TABLE dotaciones ADD CONSTRAINT dotaciones_pk PRIMARY KEY ( id );

CREATE TABLE establecimiento (
    id                 INTEGER NOT NULL,
    id_establecimiento INTEGER NOT NULL,
    nombre             VARCHAR2(30 CHAR),
    capacidad          INTEGER
);

ALTER TABLE establecimiento ADD CONSTRAINT establecimiento_pk PRIMARY KEY ( id );

ALTER TABLE establecimiento ADD CONSTRAINT establecimiento_pkv1 UNIQUE ( id_establecimiento );

CREATE TABLE habitacionesdotaciones (
    ofertashabitaciones_id INTEGER NOT NULL,
    dotaciones_id          INTEGER NOT NULL
);

ALTER TABLE habitacionesdotaciones ADD CONSTRAINT habitacionesdotaciones_pk PRIMARY KEY ( ofertashabitaciones_id,
                                                                                          dotaciones_id );

CREATE TABLE hoteles (
    id        INTEGER NOT NULL,
    nombre    VARCHAR2(30 CHAR),
    ubicacion VARCHAR2(100 CHAR)
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( id );

CREATE TABLE ofertashabitaciones (
    id             INTEGER NOT NULL,
    capacidad      INTEGER,
    fechainicio    DATE,
    fechafin       DATE,
    costo          FLOAT,
    tipohabitacion VARCHAR2(30 CHAR),
    usuarios_id    INTEGER NOT NULL,
    hoteles_id     INTEGER NOT NULL
);

ALTER TABLE ofertashabitaciones ADD CONSTRAINT ofertashabitaciones_pk PRIMARY KEY ( id );

CREATE TABLE ofrecen (
    establecimiento_id INTEGER NOT NULL,
    productos_id       INTEGER NOT NULL
);

ALTER TABLE ofrecen ADD CONSTRAINT ofrecen_pk PRIMARY KEY ( establecimiento_id,
                                                            productos_id );

CREATE TABLE planesconsumo (
    id        INTEGER NOT NULL,
    nombre    VARCHAR2(30 CHAR),
    descuento FLOAT
);

ALTER TABLE planesconsumo ADD CONSTRAINT planesconsumo_pk PRIMARY KEY ( id );

CREATE TABLE planservicio (
    planesconsumo_id INTEGER NOT NULL,
    servicios_id     INTEGER NOT NULL
);

ALTER TABLE planservicio ADD CONSTRAINT planservicio_pk PRIMARY KEY ( planesconsumo_id,
                                                                      servicios_id );

CREATE TABLE productos (
    id          INTEGER NOT NULL,
    costo       FLOAT,
    descripcion VARCHAR2(100 CHAR)
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( id );

CREATE TABLE reservahabitaciones (
    id                     INTEGER NOT NULL,
    fechainicio            DATE,
    fechafin               DATE,
    pago                   FLOAT,
    planesconsumo_id       INTEGER NOT NULL,
    ofertashabitaciones_id INTEGER NOT NULL,
    usuarios_id            INTEGER NOT NULL
);

ALTER TABLE reservahabitaciones ADD CONSTRAINT reservahabitaciones_pk PRIMARY KEY ( id );

CREATE TABLE reservaservicios (
    id           INTEGER NOT NULL,
    fechainicio  DATE,
    fechafin     DATE,
    pago         FLOAT,
    servicios_id INTEGER NOT NULL
);

ALTER TABLE reservaservicios ADD CONSTRAINT reservaservicios_pk PRIMARY KEY ( id );

CREATE TABLE servicios (
    id          INTEGER NOT NULL,
    nombre      VARCHAR2(20 CHAR),
    costo       FLOAT,
    descripcion VARCHAR2(150 CHAR)
);

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id );

CREATE TABLE seviciohotel (
    hoteles_id   INTEGER NOT NULL,
    servicios_id INTEGER NOT NULL
);

ALTER TABLE seviciohotel ADD CONSTRAINT seviciohotel_pk PRIMARY KEY ( hoteles_id,
                                                                      servicios_id );

CREATE TABLE usuarios (
    id       INTEGER NOT NULL,
    nombre   VARCHAR2(50 CHAR),
    apellido VARCHAR2(50 CHAR),
    correo   VARCHAR2(50 CHAR),
    rol      VARCHAR2(20 CHAR)
);

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( id );

ALTER TABLE "Check"
    ADD CONSTRAINT check_reservahabitaciones_fk FOREIGN KEY ( reservahabitaciones_id )
        REFERENCES reservahabitaciones ( id );

ALTER TABLE "Check"
    ADD CONSTRAINT check_usuarios_fk FOREIGN KEY ( usuarios_id )
        REFERENCES usuarios ( id );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_reservas_fk FOREIGN KEY ( reservahabitaciones_id )
        REFERENCES reservahabitaciones ( id );

ALTER TABLE habitacionesdotaciones
    ADD CONSTRAINT dotaciones_ofertas_fk FOREIGN KEY ( ofertashabitaciones_id )
        REFERENCES ofertashabitaciones ( id );

ALTER TABLE establecimiento
    ADD CONSTRAINT establecimiento_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE habitacionesdotaciones
    ADD CONSTRAINT habitaciones_dotaciones_fk FOREIGN KEY ( dotaciones_id )
        REFERENCES dotaciones ( id );

ALTER TABLE ofertashabitaciones
    ADD CONSTRAINT ofertas_usuarios_fk FOREIGN KEY ( usuarios_id )
        REFERENCES usuarios ( id );

ALTER TABLE ofertashabitaciones
    ADD CONSTRAINT ofertashabitaciones_hoteles_fk FOREIGN KEY ( hoteles_id )
        REFERENCES hoteles ( id );

ALTER TABLE ofrecen
    ADD CONSTRAINT ofrecen_establecimiento_fk FOREIGN KEY ( establecimiento_id )
        REFERENCES establecimiento ( id );

ALTER TABLE ofrecen
    ADD CONSTRAINT ofrecen_productos_fk FOREIGN KEY ( productos_id )
        REFERENCES productos ( id );

ALTER TABLE planservicio
    ADD CONSTRAINT planservicio_planesconsumo_fk FOREIGN KEY ( planesconsumo_id )
        REFERENCES planesconsumo ( id );

ALTER TABLE planservicio
    ADD CONSTRAINT planservicio_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE reservahabitaciones
    ADD CONSTRAINT reservas_ofertas_fk FOREIGN KEY ( ofertashabitaciones_id )
        REFERENCES ofertashabitaciones ( id );

ALTER TABLE reservahabitaciones
    ADD CONSTRAINT reservas_planes_fk FOREIGN KEY ( planesconsumo_id )
        REFERENCES planesconsumo ( id );

ALTER TABLE reservahabitaciones
    ADD CONSTRAINT reservas_usuarios_fk FOREIGN KEY ( usuarios_id )
        REFERENCES usuarios ( id );

ALTER TABLE reservaservicios
    ADD CONSTRAINT reservaservicios_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE seviciohotel
    ADD CONSTRAINT seviciohotel_hoteles_fk FOREIGN KEY ( hoteles_id )
        REFERENCES hoteles ( id );

ALTER TABLE seviciohotel
    ADD CONSTRAINT seviciohotel_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            16
-- CREATE INDEX                             0
-- ALTER TABLE                             35
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
