package edu.upc.dsa.models;

public class Tienda {
    int idJugador;
    int idObjeto;
    boolean comprado;

    public Tienda(){}

    public Tienda (int idJugador, int idObjeto)
    {
        this.idJugador = idJugador;
        this.idObjeto = idObjeto;

    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
}
