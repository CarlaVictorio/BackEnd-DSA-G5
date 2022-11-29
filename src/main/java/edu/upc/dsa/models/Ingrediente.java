package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils;

public class Ingrediente {
    String idIngrediente;
    String nombreIngrediente;
    int nivelDesbloqueoIngrediente;
    double precioIngrediente;
    public Ingrediente() {
        this.idIngrediente = RandomUtils.getId();
    }

    public Ingrediente (String nombreIngrediente, int nivelDesbloqueoIngrediente, double precioIngrediente) {
        this();
        this.setNombreIngrediente(nombreIngrediente);
        this.setNivelDesbloqueoIngrediente(nivelDesbloqueoIngrediente);
        this.setPrecioIngrediente(precioIngrediente);
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
