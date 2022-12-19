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
                            precio double,
                            urlImagen varchar(250)

);
CREATE TABLE if not exists Utensilio(
                        id int auto_increment primary key,
                        nombre varchar(250) not null,
                        tiempoNivel1 int not null,
                        tiempoNivel2 int not null,
                        tiempoNivel3 int not null,
                        precio double not null,
                        urlImagen varchar(250)
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

INSERT INTO Ingrediente (nombre, nivelDesbloqueo, precio, urlImagen) VALUE ('Bacon',1,12,'https://drive.google.com/file/d/17ur755AeDq6ZjlaJYl3u-bjmVZ9zelcF/view?usp=share_link');
INSERT INTO Ingrediente (nombre, nivelDesbloqueo, precio, urlImagen) VALUE ('Hamburguesa',1,13,'https://drive.google.com/file/d/11BPzsTkykb-HX-a7JmkAMdME0T8HxgMO/view?usp=share_link');
INSERT INTO Ingrediente (nombre, nivelDesbloqueo, precio, urlImagen) VALUE ('Lechuga',1,14,'https://drive.google.com/file/d/14UMDkt6xBgnK9cKMKbWdclq70_XzGPon/view?usp=share_link');
INSERT INTO Ingrediente (nombre, nivelDesbloqueo, precio, urlImagen) VALUE ('Tomate',1,15,'https://drive.google.com/file/d/1CuXpOGuhMA50W1ieYDuhIVHmsXdKgcA_/view?usp=share_link');

INSERT INTO Utensilio (nombre, tiempoNivel1, tiempoNivel2, tiempoNivel3, precio, urlImagen) VALUE ('Horno',15,10,5,100,'https://drive.google.com/file/d/1tHazjRhs_wJPHfHTIao82IMKnMpmjmjI/view?usp=share_link');
INSERT INTO Utensilio (nombre, tiempoNivel1, tiempoNivel2, tiempoNivel3, precio, urlImagen) VALUE ('Plancha',15,10,5,50,'https://drive.google.com/file/d/1aDErVrozCVncf007IXOz6OwwciJrasix/view?usp=share_link');
INSERT INTO Utensilio (nombre, tiempoNivel1, tiempoNivel2, tiempoNivel3, precio, urlImagen) VALUE ('Plato',15,10,5,20,'https://drive.google.com/file/d/10DG9x492t76jGNVGyd4vlNcRrE7w-PHo/view?usp=share_link');

INSERT INTO IngredientesComprados (idIngrediente, idJugador) VALUE (1,1);
INSERT INTO IngredientesComprados (idIngrediente, idJugador) VALUE (1,2);

INSERT INTO UtensiliosComprados (idUtensilio,idJugador,nivel) VALUE (1,1,1);
INSERT INTO UtensiliosComprados (idUtensilio, idJugador,nivel) VALUE (1,2,1);