package edu.upc.dsa.models;

public class Registro {
    String nombre;
    String password;
    String email;
    String pais;

    public Registro() {}

    public Registro(String name, String pass, String email, String pais)
    {
        this.nombre = name;
        this.password = pass;
        this.email = email;
        this.pais = pais;
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

    public void setPassword(String password) {
        this.password = password;
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
}
