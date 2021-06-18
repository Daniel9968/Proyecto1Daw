CREATE DATABASE Pizzeria CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE Pizzeria;
CREATE TABLE Empleados(
dni VARCHAR(10), -- Tambien puede guardar el numero de los que no tengan dni
usuario VARCHAR(50) UNIQUE,
contrasenya VARCHAR(10000),
nombre VARCHAR(50),
apellido1 VARCHAR(50),
apellido2 VARCHAR(50),
contacto VARCHAR(50),
CONSTRAINT emp_dni_pk PRIMARY KEY(dni)
);
insert into Empleados values ( 123456789, "empleado1", "1234", "Raul", "Fernandez", "Gonzalez", 644171717);
insert into Empleados values ( 987654321, "empleado2", "4321", "Mauro", "Cabanillas", "Lloret", 644171819);
select * from empleados;
-- drop table Empleados;