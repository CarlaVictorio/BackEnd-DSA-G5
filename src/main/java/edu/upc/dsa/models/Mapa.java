package edu.upc.dsa.models;

public class Mapa {
    int idMapa;
    String nombreMapa;
    int numNivelesMapa;

    public Mapa() {
    }

    public Mapa(int id, String nombre, int numNiveles) {
        this.idMapa = id;
        this.nombreMapa = nombre;
        this.numNivelesMapa = numNiveles;
    }

    public int getId() {
        return idMapa;
    }

    public void setId(int id) {
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
