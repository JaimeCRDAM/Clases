CREATE DATABASE [videoclub]
GO

USE [videoclub]
GO

CREATE TABLE [categorias] (
  [categoria] varchar(100) NOT NULL PRIMARY KEY,
  [precio] decimal NULL
)
GO

CREATE TABLE [estilos] (
  [estilo] varchar(100) NOT NULL PRIMARY KEY
)
GO

CREATE TABLE [peliculas] (
[codpeli] int IDENTITY(1,1) NOT NULL PRIMARY KEY,
[titulo] varchar(80) NULL,
[director] varchar(80) NULL,
[protagonista] varchar(80) NULL,
[argumento] varchar(1000) NULL,
[estilo] varchar(100) NOT NULL,
[anio] int NULL,
[caratula] varchar(500) NULL,
[categoria] varchar(100) NOT NULL,
[stock] int NULL
)
GO
CREATE NONCLUSTERED INDEX [estilo]
ON [peliculas] (
  [estilo]
)
GO
CREATE NONCLUSTERED INDEX [categoria]
ON [peliculas] (
  [categoria]
)
GO
ALTER TABLE [peliculas] ADD CONSTRAINT [peliculas_fk_est] FOREIGN KEY ([estilo]) REFERENCES [estilos] ([estilo])
GO
ALTER TABLE [peliculas] ADD CONSTRAINT [peliculas_fk_cat] FOREIGN KEY ([categoria]) REFERENCES [categorias] ([categoria])
GO

CREATE TABLE [socios] (
[idSocio] int IDENTITY(1,1) NOT NULL PRIMARY KEY,
[login] varchar(12) NULL,
[pwd] varchar(12) NULL,
[nombre] varchar(80) NULL,
[apell1] varchar(80) NULL,
[apell2] varchar(80) NULL,
[direccion] varchar(80) NULL,
[localidad] varchar(80) NULL,
[telefono] varchar(20) NULL,
[email] varchar(255) NULL
)
GO

CREATE TABLE [alquileres] (
[codAlquiler] int IDENTITY(1,1) NOT NULL PRIMARY KEY,
[fechaAlquiler] date NULL,
[socio] int NOT NULL,
[pelicula] int NOT NULL,
[fechaDevolucion] date NULL,
[precio] decimal NULL
)
GO
CREATE NONCLUSTERED INDEX [alq_soc]
ON [alquileres] (
  [socio]
)
GO
CREATE NONCLUSTERED INDEX [alq_pel]
ON [alquileres] (
  [pelicula]
)
GO
ALTER TABLE [alquileres] ADD CONSTRAINT [alquileres_fk_pel] FOREIGN KEY ([pelicula]) REFERENCES [peliculas] ([codpeli])
GO
ALTER TABLE [alquileres] ADD CONSTRAINT [alquileres_fk_soc] FOREIGN KEY ([socio]) REFERENCES [socios] ([idSocio])
GO

INSERT INTO categorias VALUES ('Estrenos',3);
INSERT INTO categorias VALUES ('MALA',0.5);
INSERT INTO categorias VALUES ('Más Vistas',2.5);
INSERT INTO categorias VALUES ('Normales',2);
INSERT INTO categorias VALUES ('Poco Vistas',1);

INSERT INTO estilos VALUES ('Acción');
INSERT INTO estilos VALUES ('Aventura');
INSERT INTO estilos VALUES ('Comedia');
INSERT INTO estilos VALUES ('Dibujos Animados');
INSERT INTO estilos VALUES ('Documental');
INSERT INTO estilos VALUES ('Drama');
INSERT INTO estilos VALUES ('Fantasía');
INSERT INTO estilos VALUES ('Histórica');
INSERT INTO estilos VALUES ('Intriga');
INSERT INTO estilos VALUES ('Musical');
INSERT INTO estilos VALUES ('Otro');
INSERT INTO estilos VALUES ('Suspense');
INSERT INTO estilos VALUES ('Terror');

INSERT INTO peliculas (titulo,director,protagonista,argumento,estilo,anio,caratula,categoria,stock) VALUES ('Noches de tormenta','George C Wolfe','Richard Gere, Scott Glenn','Una mujer cuya vida está sumergida en caos, se retira al pueblecido costero de Rodanthe, en los Outer Banks de Carolina del Norte, para hacerse cargo de la posada de una amiga durante un fin de semana','Comedia',2008,'','Normales',1);
INSERT INTO peliculas (titulo,director,protagonista,argumento,estilo,anio,caratula,categoria,stock) VALUES ('Pesadillas antes de Navidad','Tim Burton','Jack Skelleton','En la ciudad de Halloween Jack intenta cambiar las costumbres y disfrutar de la Navidad, para ello intenta conocer a Santa Clavos y hacer su trabajo por él','Otro',1998,'','Normales',4);
INSERT INTO peliculas (titulo,director,protagonista,argumento,estilo,anio,caratula,categoria,stock) VALUES ('King Kong','Peter Jackson','King Kong','Un gorila gigante se enamora de una mujercita','Acción',2006,'','Poco Vistas',2);
INSERT INTO peliculas (titulo,director,protagonista,argumento,estilo,anio,caratula,categoria,stock) VALUES ('Los Otros','Alejandro Amenabar','Nicole Kidman','Una mujer que vive con sus hijos alérgicos a la luz, tienen que aprender a convivir con unos inquilinos bastante especiales','Suspense',2000,'','Más Vistas',8);
INSERT INTO peliculas (titulo,director,protagonista,argumento,estilo,anio,caratula,categoria,stock) VALUES ('Matrix','Hermanos Watchoski','Keanu Reaves','Neo, el elegido, intentará disminuir las diferencias y peligros entre el mundo real y Matrix','Documental',1996,'','Estrenos',5);
INSERT INTO peliculas (titulo,director,protagonista,argumento,estilo,anio,caratula,categoria,stock) VALUES ('Volver','Pedro Almodovar','Penélope Cruz','Rogustiana descubre que su madre no está muerta, e intenta recuperar el tiempo perdido con ella','Drama',2004,'','Normales',1);
INSERT INTO peliculas (titulo,director,protagonista,argumento,estilo,anio,caratula,categoria,stock) VALUES ('Los miserables','Toom Hopper','Hugh Jackman, Russell Crowe  Anne Hathaway','Lucha, sueña, desea, ama …..','Musical',2012,'','Estrenos',5);
INSERT INTO peliculas (titulo,director,protagonista,argumento,estilo,anio,caratula,categoria,stock) VALUES ('Hobbit','Peter Jackson','Martin Freeman, Ian McKellen','Bilbo Bolsón, un Hobbit, viaja a la Montaña Solitaria acompañado por un grupo de enanos para recuperar un tesoro robado por el dragón Smaug','Fantasía',2012,'','Estrenos',7);
INSERT INTO peliculas (titulo,director,protagonista,argumento,estilo,anio,caratula,categoria,stock) VALUES ('Matrix II','Hermanos Watchoski','Keanu Reaves','y poco más o menos','Acción',1998,'','Más Vistas',6);

INSERT INTO socios (login,pwd,nombre,apell1,apell2,direccion,localidad,telefono,email) VALUES ('admin','hola','root','root','','c/ancha 20','Puertollano','926 42 42 42','admin@e.es');
INSERT INTO socios (login,pwd,nombre,apell1,apell2,direccion,localidad,telefono,email) VALUES ('carlos','carlos','carlos','carlos','','avenida 1º de mayo','Puertollano','678 67 86 78','carlos@e.es');
INSERT INTO socios (login,pwd,nombre,apell1,apell2,direccion,localidad,telefono,email) VALUES ('lola','lola','lola','lopez','','avenida 1º de mayo','Puertollano','926 34 34 34','lola@e.es');
INSERT INTO socios (login,pwd,nombre,apell1,apell2,direccion,localidad,telefono,email) VALUES ('sergio','sergio','sergio','sergio','','avenida 1º de mayo','Puertollano','654 65 46 54','sergio@e.es');
INSERT INTO socios (login,pwd,nombre,apell1,apell2,direccion,localidad,telefono,email) VALUES ('LUCAS','lucas','Lucas','ros','','plaza españa 20 3','C. Real','698 69 86 98','lucas@e.es');
INSERT INTO socios (login,pwd,nombre,apell1,apell2,direccion,localidad,telefono,email) VALUES ('mario','mario','Mario','Ruiz','','calle toledo 20','C. Real','632 63 26 32','mario@e.es');
INSERT INTO socios (login,pwd,nombre,apell1,apell2,direccion,localidad,telefono,email) VALUES ('jose','jose','jose','sanz','','calle capitan 30','Puertollano','926 42 42 46','jose@e.es');
INSERT INTO socios (login,pwd,nombre,apell1,apell2,direccion,localidad,telefono,email) VALUES ('maria','maria','maria','martinez','','paseo S. Gregorio 29','Puertollano','612 61 23 61','maria@e.es');

INSERT INTO alquileres (fechaAlquiler,socio,pelicula,fechaDevolucion,precio) VALUES('2021-12-20',8,8,null,null);
INSERT INTO alquileres (fechaAlquiler,socio,pelicula,fechaDevolucion,precio) VALUES('2021-10-20',7,8,null,null);
INSERT INTO alquileres (fechaAlquiler,socio,pelicula,fechaDevolucion,precio) VALUES('2021-10-02',1,6,null,null);
INSERT INTO alquileres (fechaAlquiler,socio,pelicula,fechaDevolucion,precio) VALUES('2021-07-12',6,4,null,null);
INSERT INTO alquileres (fechaAlquiler,socio,pelicula,fechaDevolucion,precio) VALUES('2022-01-07',5,8,null,null);
INSERT INTO alquileres (fechaAlquiler,socio,pelicula,fechaDevolucion,precio) VALUES('2022-01-02',8,3,null,null);
INSERT INTO alquileres (fechaAlquiler,socio,pelicula,fechaDevolucion,precio) VALUES('2022-01-02',5,6,null,null);
INSERT INTO alquileres (fechaAlquiler,socio,pelicula,fechaDevolucion,precio) VALUES('2020-01-19',5,3,null,null);
INSERT INTO alquileres (fechaAlquiler,socio,pelicula,fechaDevolucion,precio) VALUES('2021-01-04',7,8,null,null);

GO