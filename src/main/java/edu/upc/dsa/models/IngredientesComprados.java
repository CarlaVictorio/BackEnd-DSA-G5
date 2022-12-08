package edu.upc.dsa.models;

public class IngredientesComprados {
    String idIngredienteComprado;
    String jugadorName;


    public IngredientesComprados(){}

    public IngredientesComprados(String idIngredienteComprado, String jugadorName){
        this.idIngredienteComprado = idIngredienteComprado;
        this.jugadorName = jugadorName;
    }

    public String getIdIngredienteComprado() {
        return idIngredienteComprado;
    }

    public void setIdIngredienteComprado(String idIngredienteComprado) {
        this.idIngredienteComprado = idIngredienteComprado;
    }

    public String getJugadorName() {
        return jugadorName;
    }

    public void setJugadorName(String jugadorName) {
        this.jugadorName = jugadorName;
    }
}
