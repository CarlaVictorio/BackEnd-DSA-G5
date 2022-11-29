package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils;

public class Jugador {
    String id;
    String nombre;
    String password;
    String email;
    String pais;

    public Jugador() {
        this.id = RandomUtils.getId();
    }

    public Jugador (String nombre, String password, String email, String pais) {
        this();
        this.setNombre(nombre);
        this.setPassword(password);
        this.setEmail(email);
        this.setPais(pais);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password
    ) {
        this.password = password;
    }
}
