package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils;

public class Jugador {
    String idJugador;
    String nombreJugador;
    String passwordJugador;
    String emailJugador;
    String paisJugador;

    double dinero;

    public Jugador() {
        this.idJugador = RandomUtils.getId();
    }

    public Jugador (String nombre, String password, String email, String pais, double dinero) {
        this();
        this.setNombreJugador(nombre);
        this.setPasswordJugador(password);
        this.setEmailJugador(email);
        this.setPaisJugador(pais);
        this.setDinero(dinero);
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public String getEmailJugador() {
        return emailJugador;
    }

    public void setEmailJugador(String email) {
        this.emailJugador = email;
    }

    public String getPaisJugador() {
        return paisJugador;
    }

    public void setPaisJugador(String pais) {
        this.paisJugador = pais;
    }

    public String  getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String id) {
        this.idJugador = id;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombre) {
        this.nombreJugador = nombre;
    }

    public String getPasswordJugador() {
        return passwordJugador;
    }

    public void setPasswordJugador(String password){
        this.passwordJugador = password;
    }
}
