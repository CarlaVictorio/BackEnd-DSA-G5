package edu.upc.dsa.models;

public class UtensiliosComprados {

    String idUtensilioComprado;
    String jugadorName;

    String nivelUtensilio;


    public UtensiliosComprados(){}



    public UtensiliosComprados(String idUtensilioComprado, String jugadorName, String nivelUtensilio){
        this.idUtensilioComprado = idUtensilioComprado;
        this.jugadorName = jugadorName;
        this.nivelUtensilio = nivelUtensilio;
    }

    public String getJugadorName() {
        return jugadorName;
    }

    public void setJugadorName(String jugadorName) {
        this.jugadorName = jugadorName;
    }

    public String getIdUtensilioComprado() {
        return idUtensilioComprado;
    }

    public void setIdUtensilioComprado(String idUtensilioComprado) {
        this.idUtensilioComprado = idUtensilioComprado;
    }

    public String getNivelUtensilio() {
        return nivelUtensilio;
    }

    public void setNivelUtensilio(String nivelUtensilio) {
        this.nivelUtensilio = nivelUtensilio;
    }
}
