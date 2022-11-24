package edu.upc.dsa.models;

public class Utensilio {
    String idUtensilio;
    String nombreUtensilio;
    int tiempoNivel1;
    int tiempoNivel2;
    int tiempoNivel3;

    public Utensilio() {
    }

    public Utensilio(String idUtensilio, String nombreUtensilio, int tiempoNivel1, int tiempoNivel2, int tiempoNivel3) {
        this.idUtensilio = idUtensilio;
        this.nombreUtensilio = nombreUtensilio;
        this.tiempoNivel1 = tiempoNivel1;
        this.tiempoNivel2 = tiempoNivel2;
        this.tiempoNivel3 = tiempoNivel3;
    }

    public String getIdUtensilio() {
        return idUtensilio;
    }

    public void setIdUtensilio(String idUtensilio) {
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
}
