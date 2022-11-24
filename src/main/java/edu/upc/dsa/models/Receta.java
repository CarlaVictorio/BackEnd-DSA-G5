package edu.upc.dsa.models;

public class Receta {

    String idReceta;
    String nombreReceta;
    int numPaso;
    double premioDinero;
    int premioPuntos;

    public Receta(){}

    public Receta(String idReceta, String nombreReceta, int numPaso, double premioDinero, int premioPuntos){
        this.idReceta = idReceta;
        this.nombreReceta = nombreReceta;
        this.numPaso = numPaso;
        this.premioDinero = premioDinero;
        this.premioPuntos = premioPuntos;
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
