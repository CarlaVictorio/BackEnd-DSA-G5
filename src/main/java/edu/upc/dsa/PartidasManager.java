package edu.upc.dsa;

import edu.upc.dsa.models.Partida;

import java.util.List;

public interface PartidasManager {

    //public List<Partida> getAllPartidasJugador(int idJugador);
    //public List<Partida> getAllPartidasMapa(int idMapa);
    public List<Partida> getAllPartidas();
    public Partida getPartida(int idPartida);
    public Partida addPartida(Partida p);
    public Partida addPartida (String idPartida, int nivelActual, int puntos, String idMapa, String idJugador);
    public void deletePartida(int idPartida);
    public Partida updatePartida(Partida p);
    public int size();

}
