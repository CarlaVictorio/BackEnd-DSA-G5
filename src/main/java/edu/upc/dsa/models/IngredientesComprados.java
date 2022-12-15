package edu.upc.dsa.models;

public class IngredientesComprados {
    String idIngrediente;
    String idJugador;


    public IngredientesComprados(){}

    public IngredientesComprados(String idIngredienteComprado, String jugadorName){
        this.idIngrediente = idIngredienteComprado;
        this.idJugador = jugadorName;
    }

    public String getIdIngredienteComprado() {
        return idIngrediente;
    }

    public void setIdIngredienteComprado(String idIngredienteComprado) {
        this.idIngrediente = idIngredienteComprado;
    }

    public String getJugadorName() {
        return idJugador;
    }

    public void setJugadorName(String jugadorName) {
        this.idJugador = jugadorName;
    }
}
