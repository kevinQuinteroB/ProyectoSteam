create table usuarios (
	id SERIAL PRIMARY KEY,
	username varchar(20) NOT NULL,
	email varchar(50) NOT NULL,
	contrasena varchar(50) not null,
	saldo NUMERIC(50, 2),
	activo BOOLEAN NOT NULL
)

create table amigos (
	fecha date,
	usuario_id1 integer,
	usuario_id2 integer,
	FOREIGN KEY (usuario_id1) REFERENCES usuarios(id),
	FOREIGN KEY (usuario_id2) REFERENCES usuarios(id)
)

create table pais (
	id SERIAL PRIMARY KEY,	
	pais varchar(100),
	usuarioid integer,
	FOREIGN KEY (usuarioid) REFERENCES usuarios(id)
)

create table ciudad (
	id SERIAL PRIMARY KEY,	
	ciudad varchar(100),
	paisid integer,
	FOREIGN KEY (paisid) REFERENCES pais(id)
)

create table desarrolladores (
	id SERIAL PRIMARY KEY,
	nombre varchar(50) NOT NULL
)

create table juegos (
	id SERIAL PRIMARY KEY,
	nombre varchar(50) NOT NULL,
	descripcion varchar(500) NOT NULL,
	fecha_lanzamiento date not null,
	valoracion integer,
	desarrollador_id integer,
	FOREIGN KEY (desarrollador_id) REFERENCES desarrolladores(id)
)


create table precios (
	id SERIAL PRIMARY KEY,
	fecha_final date,
	fecha_inicio date,
	descuento integer,
	precio NUMERIC(50, 2) not null,
	juego_id integer not null,
	FOREIGN KEY (juego_id) REFERENCES juegos(id)
)

create table generos (
	id SERIAL PRIMARY KEY,
	nombre varchar(50) not null
)

create table juegogenero (
	juego_id integer not null,
	genero_id integer not null,
	FOREIGN KEY (juego_id) REFERENCES juegos(id),
	FOREIGN KEY (genero_id) REFERENCES generos(id)
)

create table comentarios_jugador (
	id serial primary key,
	escritor_id integer,
	receptor_id integer,
	descripcion varchar(1000),
	fecha date,
	foreign key (escritor_id) references usuarios(id),
	foreign key (receptor_id) references usuarios(id)
)

create table comentarios_juego (
	id serial primary key,
	escritor_id integer,
	receptor_id integer,
	descripcion varchar(1000),
	fecha date,
	foreign key (escritor_id) references usuarios(id),
	foreign key (receptor_id) references juegos(id)
)

create table noticias (
	id serial primary key,
	titulo varchar(50),
	descripcion varchar(10000),
	juego_id integer,
	foreign key (juego_id) references juegos(id)
)

create table idiomas(
	id serial primary key,
	idioma varchar(50)
)

create table idiomasjuegos(
	juego_id integer,
	idioma_id integer,
	foreign key (juego_id) references juegos(id),
	foreign key (idioma_id) references idiomas(id)
)