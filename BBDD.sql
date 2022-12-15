CREATE TABLE if not exists Jugador(
    id int auto_increment primary key,
    nombre varchar(250) not null,
    password varchar(250) not null,
    email varchar(250),
    pais varchar(250),
    dinero double
);
CREATE TABLE if not exists Ingrediente(
                            id int auto_increment primary key,
                            nombre varchar(250) not null,
                            nivelDesbloqueo int,
                            precio double

);
CREATE TABLE if not exists Utensilio(
                        id int auto_increment primary key,
                        nombre varchar(250) not null,
                        tiempoNivel1 int not null,
                        tiempoNivel2 int not null,
                        tiempoNivel3 int not null,
                        precio double not null
);

CREATE TABLE if not exists IngredientesComprados(
                                      idJugador int not null,
                                      idIngrediente int not null
);
CREATE TABLE if not exists UtensiliosComprados(
                                    idUtensilio int not null,
                                    idJugador int not null,
                                    nivel int
);


INSERT INTO Jugador(nombre, password, email, pais,dinero ) VALUE ('Juan','1111', 'juan@gmail.com', 'España', 100);
INSERT INTO Jugador(nombre, password, email, pais,dinero) VALUE ('Victoria','2222', 'victoria@gmail.com', 'España', 100);
INSERT INTO Jugador(nombre, password, email, pais,dinero) VALUE ('Maria','3333', 'maria@gmail.com', 'Francia', 100);

INSERT INTO Ingrediente (nombre, nivelDesbloqueo, precio) VALUE ('Bacon',1,12);
INSERT INTO Ingrediente (nombre, nivelDesbloqueo, precio) VALUE ('Hamburguesa',1,13);
INSERT INTO Ingrediente (nombre, nivelDesbloqueo, precio) VALUE ('Lechuga',1,14);
INSERT INTO Ingrediente (nombre, nivelDesbloqueo, precio) VALUE ('Tomate',1,15);

INSERT INTO Utensilio (nombre, tiempoNivel1, tiempoNivel2, tiempoNivel3, precio) VALUE ('Horno',15,10,5,100);
INSERT INTO Utensilio (nombre, tiempoNivel1, tiempoNivel2, tiempoNivel3, precio) VALUE ('Plancha',15,10,5,50);
INSERT INTO Utensilio (nombre, tiempoNivel1, tiempoNivel2, tiempoNivel3, precio) VALUE ('Plato',15,10,5,20);

INSERT INTO IngredientesComprados (idIngrediente, idJugador) VALUE (1,1);
INSERT INTO IngredientesComprados (idIngrediente, idJugador) VALUE (1,2);

INSERT INTO UtensiliosComprados (idUtensilio,idJugador,nivel) VALUE (1,1,1);
INSERT INTO UtensiliosComprados (idUtensilio, idJugador,nivel) VALUE (1,2,1);