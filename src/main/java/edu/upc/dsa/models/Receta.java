package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Receta {

    String idReceta;
    String nombreReceta;
    int numPaso;
    double premioDinero;
    int premioPuntos;
    public Receta() {
        this.idReceta = RandomUtils.getId();
    }

    public Receta (String nombreReceta, int numPaso, double premioDinero, int premioPuntos) {
        this();
        this.setNombreReceta(nombreReceta);
        this.setNumPaso(numPaso);
        this.setPremioDinero(premioDinero);
        this.setPremioPuntos(premioPuntos);
    }

    public String getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(String idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public int getNumPaso() {
        return numPaso;
    }

    public void setNumPaso(int numPaso) {
        this.numPaso = numPaso;
    }

    public double getPremioDinero() {
        return premioDinero;
    }

    public void setPremioDinero(double premioDinero) {
        this.premioDinero = premioDinero;
    }

    public int getPremioPuntos() {
        return premioPuntos;
    }

    public void setPremioPuntos(int premioPuntos) {
        this.premioPuntos = premioPuntos;
    }
}
