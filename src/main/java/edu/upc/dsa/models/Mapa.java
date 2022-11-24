package edu.upc.dsa.models;

public class Mapa {
    String idMapa;
    String nombreMapa;
    int numNivelesMapa;

    public Mapa() {
    }

    public Mapa(String id, String nombre, int numNiveles) {
        this.idMapa = id;
        this.nombreMapa = nombre;
        this.numNivelesMapa = numNiveles;
    }

    public String getId() {
        return idMapa;
    }

    public void setId(String id) {
        this.idMapa = id;
    }

    public String getNombre() {
        return nombreMapa;
    }

    public void setNombre(String nombre) {
        this.nombreMapa = nombre;
    }

    public int getNumNiveles() {
        return numNivelesMapa;
    }

    public void setNumNiveles(int numNiveles) {
        this.numNivelesMapa = numNiveles;
    }
}
