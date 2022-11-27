package edu.upc.dsa;

import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.LogIn;

import java.util.List;


public interface JugadorManager {
    public List<Jugador> getAllJugadores ();
    public Jugador getJugador (String id);
    public Jugador logInJugador (LogIn logInParams);
    public Jugador addJugador (String nombre, String contraseña);
    public  void deleteJugador(String id);
    public Jugador putJugador(Jugador jugador);
    public int size();

}
