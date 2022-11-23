package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils;

import java.util.List;
import java.util.ArrayList;

public class Partida {

    int idPartida;
    int nivelActual;
    int puntos;
    int idMapa;
    int idJugador;

    public Partida(){

    }
    public Partida (int idPartida, int nivelActual, int puntos, int idMapa, int idJugador){
        this();
        this.setIdPartida(idPartida);
        this.setNivelActual(nivelActual);
        this.setPuntos(puntos);
        this.setIdMapa(idMapa);
        this.setIdJugador(idJugador);

    }
    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(int idMapa) {
        this.idMapa = idMapa;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }
}
