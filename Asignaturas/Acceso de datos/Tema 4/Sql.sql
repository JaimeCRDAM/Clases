create or replace type direccion as object(
    calle varchar2(25),
    ciudad varchar2(20),
    codigo_post number(5)
                                          );

create or replace type persona as object(
    codigo number,
    nombre varchar2(15),
    direc direccion,
    fecha_nac date
                                        );

create or replace type t_alumno as object(
    datos persona, nota1 number, nota2 number, nota3 number
);

declare
    dir direccion := direccion(null, null, null);
    p persona := persona(null, null, null, null);
begin
    dir.CALLE := 'La mina';
    dir.CIUDAD := 'Puertollano';
    dir.CODIGO_POST := 23001;
    p.CODIGO := 1;
    p.DIREC := dir;
    p.NOMBRE := 'Maria';
    p.FECHA_NAC := '10/11/1998';
end;

alter type direccion
    add member procedure set_calle(c varchar2),
    add member function get_calle return varchar2 cascade;

create or replace type body direccion as
    member procedure set_calle(c varchar2) is
        begin
            calle := c;
        end;
    member function get_calle return varchar2 is
        begin
            return calle;
        end;
end;

declare
    dir direccion := direccion(null, null, null);
    p persona := persona(null, null, null, null);
    alumno t_alumno := t_alumno(null, null, null, null);
begin
    dir.CALLE := 'La mina';
    dir.CIUDAD := 'Puertollano';
    dir.CODIGO_POST := 23001;
    p.CODIGO := 1;
    p.DIREC := dir;
    p.NOMBRE := 'Maria';
    p.FECHA_NAC := '10/11/1998';
    alumno.DATOS := p;
    alumno.NOTA1 := 1;
    alumno.NOTA2 := 2;
    alumno.NOTA3 := 3;
end;
create table direccion(
    id number(9),
    calle varchar2(35),
    ciudad varchar2(35)
);

create type tabla_anidada as table of direccion;
drop table ejemplo_tabla_anidada;
drop table direccion;

create table ejemplo_tabla_anidada(
    id number(9),
    apellidos varchar2(35),
    direc tabla_anidada
)
nested table direc store as direc_anidada;

insert into ejemplo_tabla_anidada values(1,'ramos',
    tabla_anidada(
        direccion('1', '1', 19001),
        direccion('2', '2', 19002),
        direccion('3', '3', 19003),
        direccion('4', '4', 19004),
        direccion('5', '5', 19005)
        )
);
insert into ejemplo_tabla_anidada values(2,'ak',
    tabla_anidada(
        direccion('1', '1', 19001),
        direccion('2', '2', 19002)
        )
);
insert into ejemplo_tabla_anidada values(2, 'ak', null);

select id,
       apellidos,
       cursor(
            select TT.calle
            from table(T.direc) TT)
from ejemplo_tabla_anidada T;
insert into EJEMPLO_TABLA_ANIDADA (id, apellidos, direc)
values (3, 'RAMOS', TABLA_ANIDADA(DIRECCION('C/Los manantiales 5', 'GUADALAJARA', 19004),
                                  DIRECCION('C/Los manantiales 10', 'GUADALAJARA', 19004),
                                  DIRECCION('C/Av de Paris 25', 'CACERES', 10005),
                                  DIRECCION('C/Segovia 23-3A', 'TOLEDO', 45005)));
insert into EJEMPLO_TABLA_ANIDADA (id, apellidos, direc)
values (4, 'MARTÍN', TABLA_ANIDADA(DIRECCION('C/Huesca 5', 'ALCALÁ DE H', 28804),
                                   DIRECCION('C/Madrid 20', 'ALCORCÓN', 28921)));

select calle from the ( select t.direc from ejemplo_tabla_anidada T where id = 3 )
    where ciudad='GUADALAJARA';
--Ejercicio 1
create or replace procedure ver_direc(ident number) as
    cursor c1 is
        select calle, ciudad, codigo_post from the(
        select t.direc from ejemplo_tabla_anidada t where id = ident
            );
    cursor c2 is
        select apellidos from ejemplo_tabla_anidada where id = ident;
begin
    for i in c2 loop
        DBMS_OUTPUT.PUT_LINE('identificador: '||ident||' - Apellidos: '||i.apellidos );
        DBMS_OUTPUT.PUT_LINE('===========Direcciones===========');
        for j in c1 loop
            DBMS_OUTPUT.PUT_LINE(j.calle||' '||j.ciudad||' '||j.codigo_post);
        end loop;
    end loop;
end;
begin
    ver_direc(3);
    select apellidos, cursor (select tt.calle from table (t.direc) tt)
        from ejemplo_tabla_anidada t where id = 3;
end;
--Ejercicio 2
insert into EJEMPLO_TABLA_ANIDADA (id, apellidos, direc)
values (5, 'Cano', TABLA_ANIDADA(DIRECCION('C/Marco polo 1', 'PU', 13500),
                                   DIRECCION('‘Pº San Gregorio, 82', 'PU', 13500)));
--Ejercicio 3
begin
    ver_direc(5);
end;
--Ejercicio 4
insert into table ( select direc from ejemplo_tabla_anidada where id = 5 )
VALUES (
            DIRECCION('C/Los álamos, 105','CR',13001)
       );
insert into table ( select direc from ejemplo_tabla_anidada where id = 5 )
VALUES (
            DIRECCION('C/Malagón, 108','CR',13001)
       );
select direc from ejemplo_tabla_anidada where id = 5;
--ejercicio 5
select calle, ciudad from the(
    select t.direc from ejemplo_tabla_anidada t where id = 5
) where codigo_post = 13001;
--ejercicio 6
UPDATE TABLE(SELECT e.direc FROM ejemplo_tabla_anidada e WHERE e.id = 5) d
SET d.codigo_post = 13000
where d.codigo_post = 13001;
--ejercicio 7
UPDATE TABLE(SELECT e.direc FROM ejemplo_tabla_anidada e WHERE e.id = 5) d
SET d.calle = 'C/Malagón, 110'
where d.codigo_post = 13000;
--ejericicio 8
begin
    ver_direc(5);
end;
--ejercicio 9
delete from TABLE(SELECT e.direc FROM ejemplo_tabla_anidada e WHERE e.id = 5) d
where d.calle = '‘Pº San Gregorio, 82';
--ejercicio 10
delete from TABLE(SELECT e.direc FROM ejemplo_tabla_anidada e WHERE e.id = 5) d
where d.codigo_post = 13000;
--ejercicio 11
create or replace procedure ver_direc2 is
    cur sys_refcursor;
    cont number;
    cal varchar2(50);
    ciu varchar2(50);
    cursor c2 is
        select apellidos, id from ejemplo_tabla_anidada;
begin
    for i in c2 loop
        DBMS_OUTPUT.PUT_LINE('identificador: '||i.id||' - Apellidos: '||i.apellidos);
        DBMS_OUTPUT.PUT_LINE('===========Direcciones===========');
        Loop
            OPEN cur FOR select calle, ciudad from the(
                            select t.direc from ejemplo_tabla_anidada t where id = i.id
                        ) where codigo_post != 13500;
            FETCH cur INTO cal, ciu;
            EXIT WHEN cont > 5;
            cont := cont +1;
                DBMS_OUTPUT.PUT_LINE(cal||' '||ciu);
        end loop;
    end loop;
end;
create or replace procedure ver_direc3 is
    cur sys_refcursor;
    cal varchar2(50);
    ciu varchar2(50);
    cursor c2 is
        select apellidos, id from ejemplo_tabla_anidada;
begin
    for i in c2 loop
        DBMS_OUTPUT.PUT_LINE('identificador: '||i.id||' - Apellidos: '||i.apellidos);
        DBMS_OUTPUT.PUT_LINE('===========Direcciones===========');
        OPEN cur FOR select calle, ciudad from the(
            select t.direc from ejemplo_tabla_anidada t where id = i.id
        ) where codigo_post != 13500;
        LOOP
            EXIT WHEN cur%NOTFOUND;
            FETCH cur INTO cal, ciu;
            DBMS_OUTPUT.PUT_LINE(cal||' '||ciu);
        end loop;

    end loop;
end;

begin
    select apellidos, cursor (select tt.calle, tt.ciudad from table (t.direc) tt where tt.codigo_post != 13500)
        from ejemplo_tabla_anidada t;
    ver_direc3();
end;
-- Jueves --
create type tip_telefonos as varray(3) of varchar2(15);

create type tip_direccion as object
(
    calle     varchar2(50),
    poblacion varchar2(50),
    codpostal number(5),
    provincia varchar2(40)
);
create type tip_cliente as object
(
    idcliente number,
    nombre    varchar2(50),
    direc     tip_direccion,
    nif       varchar2(9),
    telef     tip_telefonos
);

create type tip_producto as object
(
    idproducto  number,
    descricion  varchar2(80),
    pvp         number,
    stockactual number
);

create type tip_lineaventa as object
(
    numerolinea number,
    idproducto  ref tip_producto,
    cantidad    number
);
create or replace type tip_venta as object
(
    idventa    number,
    idcliente  ref tip_cliente,
    fechaventa date,
    lineas     tip_lineaventa,
    member function total_venta return number
);


DROP TABLE TALUMNOS;
Create table TALUMNOS(
    DNI VARCHAR2(10),
    NOMBRE VARCHAR2(50),
    DIRECCION VARCHAR2(50),
    POBLACION VARCHAR2(50),
    CODPOSTAL NUMBER(5),
    PROVINCIA VARCHAR2(40),
    TELEFONO1 VARCHAR2(15),
    TELEFONO2 VARCHAR2(15),
    FECHA_NAC DATE,
    ID_CURSO NUMBER(4),
    PRIMARY KEY (DNI),
    FOREIGN KEY (ID_CURSO) REFERENCES TCURSOS(ID_CURSO)
);

DROP TABLE TCURSOS;
CREATE TABLE TCURSOS(
    ID_CURSO NUMBER(4),
    DESCRIPCION VARCHAR2(60),
    NIVEL VARCHAR2(30),
    TURNO CHAR(1),
    PRIMARY KEY (ID_CURSO)
);

CREATE TABLE TASIGNATURAS(
    COD_ASIG NUMBER(4),
    NOMBRE VARCHAR2(80),
    TIPO CHAR(1),
    PRIMARY KEY (COD_ASIG)
);
DROP TABLE TNOTAS;
CREATE TABLE TNOTAS(
    DNI VARCHAR2(10),
    COD_ASIGNACION NUMBER(4),
    NOTA1EV NUMBER(4, 2),
    NOTA2EV NUMBER(4, 2),
    NOTA3EV NUMBER(4, 2),
    NOTAFJUN NUMBER(4,2),
    NOTASEPT NUMBER(4,2) CHECK ( NOTAFJUN < 4 ),
    PRIMARY KEY (DNI, COD_ASIGNACION),
    FOREIGN KEY (DNI) REFERENCES TALUMNOS(DNI),
    FOREIGN KEY (COD_ASIGNACION) REFERENCES TASIGNATURAS(COD_ASIG)
);
DROP TYPE TNOTASARRAY;
create type "NOTA" as varray(5) of NUMBER(4,2);
create type "TELF" as varray(2) of VARCHAR2(15);
create or replace type "DIRE" as object(
    direccion varchar2(50),
    poblacion varchar2(50),
    codigo_post number(5),
    provincia varchar2(40)
);
create or replace type "ASIGNATURA" as object(
    COD_ASIG NUMBER(4),
    NOMBRE VARCHAR2(60),
    TIPO CHAR(1)
                                             );
create or replace type "EVALUACION" as object(
    ASIG REF ASIGNATURA,
    N NOTA

                                         );
CREATE OR REPLACE TYPE "NOTAS" AS TABLE OF EVALUACION;

CREATE OR REPLACE TYPE "CURSO" AS object(
    ID_CURSO number(4),
    DESCRIPCION VARCHAR2(60),
    NIVEL VARCHAR2(30),
    TURNO CHAR(1)
                                        );
drop type ALUMNO;
create or replace type alumno as object
(
    dni       varchar2(10),
    nombre    varchar2(50),
    direccion DIRE,
    telefonos telf,
    n         notas,
    id_curso  REF CURSO
);
drop table TASIGNATURAS CASCADE CONSTRAINTS ;
create table "TASIGNATURAS" OF "ASIGNATURA"(
    PRIMARY KEY ("COD_ASIG"),
    UNIQUE ("NOMBRE")
    );
DROP TABLE "TCURSOS" CASCADE CONSTRAINTS;
create table "TCURSOS" OF "CURSO"(
    PRIMARY KEY ("ID_CURSO")
    );
DROP TABLE "TALUMNOS" CASCADE CONSTRAINTS;
CREATE TABLE "TALUMNOS" OF "ALUMNO"(
        primary key ("DNI")
    )
nested table "N" store as "TABLA_NOTAS";

INSERT INTO "TCURSOS" VALUES(1, 'MUY CHULO', 'SEGUNDO', 0);
INSERT INTO "TCURSOS" VALUES(2, 'MUY CHULO', 'SEGUNDO', 0);
insert into "TASIGNATURAS" VALUES(1, 'AK', 0);
Insert into "TALUMNOS" VALUES('xxxxxx',
                              'Jaime',
                              DIRE('direccion => _, poblacion => _, codigo_post => 1, provincia => _'),
                              TELF('AAAAAA'),
                              NOTAS(5, 5, 5),
                              CURSO(ID_CURSO => 1, DESCRIPCION => 'DAM', NIVEL => 1, TURNO => 1)
                              );
SELECT * FROM "TCURSOS";

