package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Utensilio {
    String idUtensilio;
    String nombreUtensilio;
    int tiempoNivel1;
    int tiempoNivel2;
    int tiempoNivel3;
    public Utensilio() {
        this.idUtensilio = RandomUtils.getId();
    }

    public Utensilio (String nombreUtensilio, int tiempoNivel1, int tiempoNivel2, int tiempoNivel3) {
        this();
        this.setNombreUtensilio(nombreUtensilio);
        this.setTiempoNivel1(tiempoNivel1);
        this.setTiempoNivel2(tiempoNivel2);
        this.setTiempoNivel3(tiempoNivel3);
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
