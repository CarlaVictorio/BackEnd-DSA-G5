package edu.upc.dsa.models;

public class Receta {

    String idReceta;
    String nombre;
    int numPaso;
    String herramienta;
    String ingrediente;
    String idMapa;
    double premioDinero;
    int premioPuntos;

    public Receta(){}

    public Receta(String idReceta, String nombre, String herramienta, String ingrediente, String idMapa, double premioDinero, int premioPuntos){
        this.idReceta = idReceta;
        this.nombre = nombre;
        this.herramienta = herramienta;
        this.ingrediente = ingrediente;
        this.idMapa = idMapa;
        this.premioDinero = premioDinero;
        this.premioPuntos = premioPuntos;
    }

    public String getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(String idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPaso() {
        return numPaso;
    }

    public void setNumPaso(int numPaso) {
        this.numPaso = numPaso;
    }

    public String getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(String idMapa) {
        this.idMapa = idMapa;
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
