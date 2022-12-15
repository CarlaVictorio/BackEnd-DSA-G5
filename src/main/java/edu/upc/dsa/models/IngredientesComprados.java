package edu.upc.dsa.models;

public class IngredientesComprados {
    int idIngrediente;
    int idJugador;

    public IngredientesComprados(){}

    public IngredientesComprados(int idIngredienteComprado, int jugadorName){
        this.idIngrediente = idIngredienteComprado;
        this.idJugador = jugadorName;
    }

    public int getIdIngredienteComprado() {
        return idIngrediente;
    }

    public void setIdIngredienteComprado(int idIngredienteComprado) {
        this.idIngrediente = idIngredienteComprado;
    }

    public int getJugadorName() {
        return idJugador;
    }

    public void setJugadorName(int jugadorName) {
        this.idJugador = jugadorName;
    }
}
