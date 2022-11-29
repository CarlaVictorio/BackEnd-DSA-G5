package edu.upc.dsa;

import edu.upc.dsa.models.Partida;

import java.util.List;

public interface PartidasManager {

    //public List<Partida> getAllPartidasJugador(int idJugador);
    //public List<Partida> getAllPartidasMapa(int idMapa);
    public List<Partida> getAllPartidas();
    public Partida getPartida(String idPartida);
    public Partida addPartida(Partida p);
    public Partida addPartida (int nivelActual, int puntos, String idMapa, String idJugador);
    public void deletePartida(String idPartida);
    public Partida updatePartida(Partida p);
    public int size();

}
