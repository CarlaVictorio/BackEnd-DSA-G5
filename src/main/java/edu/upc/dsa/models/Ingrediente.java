package edu.upc.dsa.models;

public class Ingrediente {
    int idIngrediente;
    String nombreIngrediente;
    int nivelDesbloqueoIngrediente;
    double precioIngrediente;

    public Ingrediente(int idIngrediente, String nombreIngrediente, int nivelDesbloqueoIngrediente, double precioIngrediente) {
        this.idIngrediente = idIngrediente;
        this.nombreIngrediente = nombreIngrediente;
        this.nivelDesbloqueoIngrediente = nivelDesbloqueoIngrediente;
        this.precioIngrediente = precioIngrediente;
    }

    public Ingrediente() {
    }
    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
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
