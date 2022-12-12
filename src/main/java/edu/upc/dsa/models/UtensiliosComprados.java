package edu.upc.dsa.models;

public class UtensiliosComprados {

    int idUtensilio;
    int idJugador;
    int nivelUtensilio;


    public UtensiliosComprados(){}



    public UtensiliosComprados(int idUtensilioComprado, int idJugador, int nivelUtensilio){
        this.idUtensilio = idUtensilioComprado;
        this.idJugador = idJugador;
        this.nivelUtensilio = nivelUtensilio;
    }

    public int getIdUtensilio() {
        return idUtensilio;
    }

    public void setIdUtensilio(int idUtensilio) {
        this.idUtensilio = idUtensilio;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getNivelUtensilio() {
        return nivelUtensilio;
    }

    public void setNivelUtensilio(int nivelUtensilio) {
        this.nivelUtensilio = nivelUtensilio;
    }
}
