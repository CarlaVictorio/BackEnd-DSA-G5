package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Utensilio {
    int idUtensilio;
    String nombreUtensilio;
    int tiempoNivel1;
    int tiempoNivel2;
    int tiempoNivel3;
    double precioUtensilio;
    public Utensilio() {
    }



    public Utensilio (String nombreUtensilio, int tiempoNivel1, int tiempoNivel2, int tiempoNivel3, double precioUtensilio) {
        this();
        this.setNombreUtensilio(nombreUtensilio);
        this.setTiempoNivel1(tiempoNivel1);
        this.setTiempoNivel2(tiempoNivel2);
        this.setTiempoNivel3(tiempoNivel3);
        this.setPrecioUtensilio(precioUtensilio);
    }

    public int getIdUtensilio() {
        return idUtensilio;
    }

    public void setIdUtensilio(int idUtensilio) {
        this.idUtensilio = idUtensilio;
    }

    public String getNombreUtensilio() {
        return nombreUtensilio;
    }

    public void setNombreUtensilio(String nombreUtensilio) {
        this.nombreUtensilio = nombreUtensilio;
    }

    public int getTiempoNivel1() {
        return tiempoNivel1;
    }

    public void setTiempoNivel1(int tiempoNivel1) {
        this.tiempoNivel1 = tiempoNivel1;
    }

    public int getTiempoNivel2() {
        return tiempoNivel2;
    }

    public void setTiempoNivel2(int tiempoNivel2) {
        this.tiempoNivel2 = tiempoNivel2;
    }

    public int getTiempoNivel3() {
        return tiempoNivel3;
    }

    public void setTiempoNivel3(int tiempoNivel3) {
        this.tiempoNivel3 = tiempoNivel3;
    }

    public double getPrecioUtensilio() {
        return precioUtensilio;
    }

    public void setPrecioUtensilio(double precioUtensilio) {
        this.precioUtensilio = precioUtensilio;
    }
}
