package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils;

public class Ingrediente {
    int idIngrediente;
    String nombreIngrediente;
    int nivelDesbloqueoIngrediente;
    double precioIngrediente;
    public Ingrediente() {

    }

    public Ingrediente (String nombreIngrediente, int nivelDesbloqueoIngrediente, double precioIngrediente) {
        this();
        this.setNombreIngrediente(nombreIngrediente);
        this.setNivelDesbloqueoIngrediente(nivelDesbloqueoIngrediente);
        this.setPrecioIngrediente(precioIngrediente);
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
