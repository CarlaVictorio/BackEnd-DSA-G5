package edu.upc.dsa.models;

public class Ingrediente {
    String idIngrediente;
    String nombreIngrediente;
    int nivelDesbloqueoIngrediente;
    double precioIngrediente;

    public Ingrediente(String idIngrediente, String nombreIngrediente, int nivelDesbloqueoIngrediente, double precioIngrediente) {
        this.idIngrediente = idIngrediente;
        this.nombreIngrediente = nombreIngrediente;
        this.nivelDesbloqueoIngrediente = nivelDesbloqueoIngrediente;
        this.precioIngrediente = precioIngrediente;
    }

    public Ingrediente() {
    }
    public String getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(String idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public int getNivelDesbloqueoIngrediente() {
        return nivelDesbloqueoIngrediente;
    }

    public void setNivelDesbloqueoIngrediente(int nivelDesbloqueoIngrediente) {
        this.nivelDesbloqueoIngrediente = nivelDesbloqueoIngrediente;
    }

    public double getPrecioIngrediente() {
        return precioIngrediente;
    }

    public void setPrecioIngrediente(double precioIngrediente) {
        this.precioIngrediente = precioIngrediente;
    }


}
