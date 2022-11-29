package edu.upc.dsa.models;


import edu.upc.dsa.util.RandomUtils;

public class Mapa {
    String idMapa;
    String nombreMapa;
    int numNivelesMapa;

    public Mapa() {
        this.idMapa = RandomUtils.getId();
    }

    public Mapa (String nombre, int numNiveles) {
        this();
        this.setNombre(nombre);
        this.setNombre(nombre);
        this.setNumNiveles(numNiveles);
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
