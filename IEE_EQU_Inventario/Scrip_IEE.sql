--Consulta
 
insert into clasificacion(Folio_Clas,Nom_Clas)
VALUES
("EY-01-","Mobiliario y equipo de oficina"),
("EY-02-","Equipo de cómputo"),
("EY-03-","Equipo de fotografía y video"),
("EY-04-","Aire acondicionado"),
("EY-05-","Equipo de comunicación"),
("EY-06-","Equipos y aparatos audiovisuales"),
("EY-07-","Equipo diverso"),
("EY-10-","Equipo de transporte");

insert into estado(Nombre_Est) 
VALUES
("Donacion"),
("Disponible"),
("Reparacion"),
("No disponible"),
("Agotado"); 

INSERT INTO puestos(Nom_Pues, Area_Pues) 
VALUES 
('Presidente','Presidencia'),
('Secretaria','Secretaria General');

insert INTO almacen(Nombre_Alm,Disponibilidad_Alm)
VALUES 
("Almacen de Aministracion","S"),
("Almacen de Informatica","S"),
("Almacen General","S");



insert INTO Car_Esp(Nombre_CarEsp)
VALUES 
("Ninguno"),
("Vehiculo");


insert INTO Datos_Esp(Nombre_Dat,Car_Esp_idCar_Esp)
VALUES 
("Km Recorridos",2),
("Fecha Servicio",2),
("Null",1);

insert INTO Asignacion_Usr(Status_Asig)
VALUES 
("Asignado"),
("Sin Asignar"),
("Perdido"),
("Null");

  


