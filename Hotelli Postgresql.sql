CREATE TABLE CATEGORIA (
CATEGORIA_ID SERIAL NOT NULL,
NOMBRE CHAR(64) NOT NULL,
PRECIO_INICIAL REAL NOT NULL,
PRECIO_USUARIO REAL NOT NULL,
MAX_USUARIOS INT NOT NULL,
CONSTRAINT PK_CATEGORIA PRIMARY KEY (CATEGORIA_ID));

CREATE TABLE HABITACION (
HABITACION_ID SERIAL NOT NULL,
CATEGORIA_ID INT NOT NULL,
PLANTA INT,
NUMERACION CHAR(4) NOT NULL,
ESTADO INT NOT NULL,
CONSTRAINT PK_HABITACION PRIMARY KEY (HABITACION_ID));

CREATE TABLE USUARIO (
USUARIO_ID SERIAL NOT NULL,
CEDULA CHAR(10),
NOMBRE CHAR(124),
TELEFONO CHAR(12),
CONSTRAINT PK_CLIENTE PRIMARY KEY (USUARIO_ID));

CREATE TABLE RESERVACION (
RESERVACION_ID INT NOT NULL,
USUARIO_ID INT NOT NULL,
HABITACION_ID INT NOT NULL,
FECHA_ENTRADA DATE,
FECHA_SALIDA DATE,
NUM_USUARIOS INT,
ESTADO INT NOT NULL,
CONSTRAINT PK_RESERVACION PRIMARY KEY (RESERVACION_ID));

ALTER TABLE HABITACION
ADD CONSTRAINT CATEGORIA_FK
FOREIGN KEY (CATEGORIA_ID)
REFERENCES CATEGORIA(CATEGORIA_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE RESERVACION
ADD CONSTRAINT USUARIO_FK
FOREIGN KEY (USUARIO_ID)
REFERENCES USUARIO(USUARIO_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE RESERVACION
ADD CONSTRAINT HABITACION_FK
FOREIGN KEY (HABITACION_ID)
REFERENCES HABITACION(HABITACION_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;
