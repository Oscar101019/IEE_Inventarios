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

INSERT INTO puestos(idPuesto,Nom_Pues, Area_Pues) 
VALUES 
('Presidente','Presidencia'),
('Secretaria','Secretaria General');

select idPuesto from puestos where Nom_Pues='Presidente';

