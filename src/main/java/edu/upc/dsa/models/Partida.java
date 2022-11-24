package edu.upc.dsa.models;

public class Partida {

    String idPartida;
    int nivelActual;
    int puntos;
    String idMapa;
    String idJugador;

    public Partida(){

    }
    public Partida (String idPartida, int nivelActual, int puntos, String idMapa, String idJugador){
        this();
        this.setIdPartida(idPartida);
        this.setNivelActual(nivelActual);
        this.setPuntos(puntos);
        this.setIdMapa(idMapa);
        this.setIdJugador(idJugador);

    }
    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
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

    public String getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(String idMapa) {
        this.idMapa = idMapa;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }
}
