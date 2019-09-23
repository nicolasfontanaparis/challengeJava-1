----EJERCICIOS
-- SOLO ES REQUERIDO REALIZAR LOS EJERCICIOS DE COMPLEJIDAD BAJA, realizar los demas ejercicios serán puntos extras para la evaluación del examen.



--- EJERCICIO 1 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todos los alumnos existentes, mostrar: TipoDoc, Documento, Nombre, Apellido, Legajo.

select pe.tipodoc, pe.documento, pe.nombre, pe.apellido, al legajo
from alumno al inner join persona pe on al.idpersona = pe.identificador

--- EJERCICIO 2 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todas las carreras a la que un alumno esta inscripto, mostrar: Legajo, nombre, apellido, nombre carrera, fechainscripcioncarrera
--ordenado por legajo descendiente
select al.legajo, pe.nombre, pe.apellido, STRING_AGG(ca.nombre|| ' - '||in_ca.fechainscripcion , ', ')--ca.nombre, in_ca.fechainscripcion 
from persona pe inner join alumno al on pe.identificador = al.idpersona
inner join inscripciones_carrera in_ca on in_ca.idalumno = al.identificador
inner join carrera ca on in_ca.idcarrera = ca.identificador
group by al.legajo, pe.nombre, pe.apellido


--- EJERCICIO 3 - COMPLEJIDAD MEDIA: 
--Realizar una consulta para consultar la cantidad de inscriptos por curso, mostrando: nombre carrera, nombre curso, cantidad inscriptos, cupo máximo por curso

select ca.nombre, cu.nombre, count(in_cu.idalumno), cu.cupomaximo
from curso cu inner join inscripciones_curso in_cu on in_cu.idcurso = cu.identificador
inner join carrera ca on cu.idcarrera = ca.identificador
group by ca.nombre, ca.descripcion, cu.nombre, cu.descripcion, cu.cupomaximo
order by ca.nombre, cu.nombre
--- EJERCICIO 4 - COMPLEJIDAD ALTA: 
--Sobre la consulta anterior (copiar y pegarla y modificarla) modificar la sql para que la consulta retorne solo los cursos cuya cantidad de inscripciones 
--supera su cupo maximo
select ca.nombre, cu.nombre, count(in_cu.idalumno), cu.cupomaximo
from curso cu inner join inscripciones_curso in_cu on in_cu.idcurso = cu.identificador
inner join carrera ca on cu.idcarrera = ca.identificador
group by ca.nombre, ca.descripcion, cu.nombre, cu.descripcion, cu.cupomaximo
having count(idalumno) > cu.cupomaximo
order by ca.nombre, cu.nombre



--- EJERCICIO 5 -  COMPLEJIDAD BAJA: 
-- actualizar todos los cursos que posean anio 2018 y cuyo cupo sea menor a 5, y actualizar el cupo de todos ellos a 10.
update curso set cupomaximo = 10
where anio = 2018 
and cupo < 5;


--- EJERCICIO 6 -  COMPLEJIDAD ALTA: 
-- actualizar todas las fechas de inscripcion a cursados que posean el siguiente error: la fecha de inscripcion al cursado de un 
-- alumno es menor a la fecha de inscripcion a la carrera. La nueva fecha que debe tener es la fecha del dia. Se puede hacer en dos pasos, primero
-- realizando la consulta y luego realizando el update manual

update inscripciones_curso 
set fechainscripcion = current_date
where (idalumno, idcurso, fechainscripcion) in (
	select in_cu.idalumno, in_cu.idcurso, in_cu.fechainscripcion
	from inscripciones_curso in_cu inner join curso cu on in_cu.idcurso = cu.identificador
	inner join inscripciones_carrera in_ca on in_ca.idcarrera = cu.idcarrera
	and in_ca.idalumno = in_cu.idalumno
	where in_cu.fechainscripcion < in_ca.fechainscripcion)



--- EJERCICIO 7 - COMPLEJIDAD BAJA:  
--INSERTAR un nuevo registro de alumno con tus datos personales, (hacer todos inserts que considera necesario)
do $$
declare idpersona_aux int;
begin
	select COALESCE(max(identificador),0) + 1 into idpersona_aux from persona;
	insert into persona (
				identificador, 
				tipodoc, 
				documento,
				nombre, 
				apellido,
				fechanac
				)
	values(
		idpersona_aux,
		'DNI',
		32296321,
		'Nicolás',
		'Fontana',
		to_date('30-06-1986', 'DD-MM-YYYY')
		);
	insert into alumno(
			identificador,
			idpersona, 
			legajo
			)
	values(
			(select COALESCE(max(identificador),0) + 1 from alumno),
			idpersona_aux,
			(select COALESCE(max(legajo),0) + 1 from alumno)
	);
end$$;
--language 'plpgsql';



--- EJERCICIO 8 -  COMPLEJIDAD BAJA: 
-- si se desea comenzar a persistir de ahora en mas el dato de direccion de un alumno y considerando que este es un único cambio string de 200 caracteres.
-- Determine sobre que tabla seria mas conveniente persistir esta información y realizar la modificación de estructuras correspondientes.

create table tipo_domicilio(
	identificador int not null primary key,
	descripcion varchar not null
);

insert into tipo_domicilio 
	values(1, 'legal');
insert into tipo_domicilio 
	values(2, 'reall');
insert into tipo_domicilio 
	values(3, 'postal');

create table domicilios_alumno(
	identificador int not null primary key,
	idalumno int references alumno(identificador),
	idtipodomicilio int references tipo_domicilio(identificador),
	docmicilio varchar(200) not null
	
);