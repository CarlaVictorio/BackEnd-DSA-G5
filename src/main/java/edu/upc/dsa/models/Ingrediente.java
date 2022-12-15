package edu.upc.dsa.models;

public class Ingrediente {
    int id;
    String nombre;
    int nivelDesbloqueo;
    double precio;
    public Ingrediente() {

    }

    public Ingrediente (String nombreIngrediente, int nivelDesbloqueoIngrediente, double precioIngrediente) {
        this();
        this.setNombre(nombreIngrediente);
        this.setNivelDesbloqueo(nivelDesbloqueoIngrediente);
        this.setPrecio(precioIngrediente);
    }

    public int getId() {
        return id;
    }

    public void setId(int idIngrediente) {
        this.id = idIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreIngrediente) {
        this.nombre = nombreIngrediente;
    }

    public int getNivelDesbloqueo() {
        return nivelDesbloqueo;
    }

    public void setNivelDesbloqueo(int nivelDesbloqueoIngrediente) {
        this.nivelDesbloqueo = nivelDesbloqueoIngrediente;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precioIngrediente) {
        this.precio = precioIngrediente;
    }


}
