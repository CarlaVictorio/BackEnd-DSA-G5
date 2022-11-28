package edu.upc.dsa.models;

public class Registro {
    String nombre;
    String password;

    public Registro() {}

    public Registro(String name, String pass)
    {
        this.nombre = name;
        this.password = pass;
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
}
