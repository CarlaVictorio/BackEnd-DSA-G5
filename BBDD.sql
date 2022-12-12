CREATE TABLE if not exists Jugador(
    idJugador int auto_increment primary key,
    nombreJugador varchar(250) not null,
    passwordJugador varchar(250) not null,
    emailJugador varchar(250),
    paisJugador varchar(250),
    dinero double
);
CREATE TABLE if not exists Ingrediente(
                            idIngrediente int auto_increment primary key,
                            nombreIngrediente varchar(250) not null,
                            nivelDesbloqueoIngrediente int,
                            precioIngrediente double

);
CREATE TABLE if not exists Utensilio(
                        idUtensilio int auto_increment primary key,
                        nombreUtensilio varchar(250) not null,
                        tiempoNivel1 int not null,
                        tiempoNivel2 int not null,
                        tiempoNivel3 int not null,
                        precioUtensilio double not null
);

CREATE TABLE if not exists IngredientesComprados(
                                      idJugador int not null,
                                      idIngrediente int not null
);
CREATE TABLE if not exists UtensiliosComprados(
                                    idUtensilio int not null,
                                    idJugador int not null,
                                    nivelUtensilio int
);


INSERT INTO Jugador(nombreJugador, passwordJugador, emailJugador, paisJugador,dinero ) VALUE ('Juan','1111', 'juan@gmail.com', 'España', 100);
INSERT INTO Jugador(nombreJugador, passwordJugador, emailJugador, paisJugador, dinero) VALUE ('Victoria','2222', 'victoria@gmail.com', 'España', 100);
INSERT INTO Jugador(nombreJugador, passwordJugador, emailJugador, paisJugador, dinero) VALUE ('Maria','3333', 'maria@gmail.com', 'Francia', 100);

INSERT INTO Ingrediente (nombreIngrediente, nivelDesbloqueoIngrediente, precioIngrediente) VALUE ('Bacon',1,12);
INSERT INTO Ingrediente (nombreIngrediente, nivelDesbloqueoIngrediente, precioIngrediente) VALUE ('Hamburguesa',1,13);
INSERT INTO Ingrediente (nombreIngrediente, nivelDesbloqueoIngrediente, precioIngrediente) VALUE ('Lechuga',1,14);
INSERT INTO Ingrediente (nombreIngrediente, nivelDesbloqueoIngrediente, precioIngrediente) VALUE ('Tomate',1,15);

INSERT INTO Utensilio (nombreUtensilio, tiempoNivel1, tiempoNivel2, tiempoNivel3, precioUtensilio) VALUE ('Horno',15,10,5,100);
INSERT INTO Utensilio (nombreUtensilio, tiempoNivel1, tiempoNivel2, tiempoNivel3, precioUtensilio) VALUE ('Plancha',15,10,5,50);
INSERT INTO Utensilio (nombreUtensilio, tiempoNivel1, tiempoNivel2, tiempoNivel3, precioUtensilio) VALUE ('Plato',15,10,5,20);

INSERT INTO IngredientesComprados (idIngrediente, idJugador) VALUE (1,1);
INSERT INTO IngredientesComprados (idIngrediente, idJugador) VALUE (1,2);

INSERT INTO UtensiliosComprados (idUtensilio,idJugador,nivelUtensilio) VALUE (1,1,1);
INSERT INTO UtensiliosComprados (idUtensilio, idJugador,nivelUtensilio) VALUE (1,2,1);