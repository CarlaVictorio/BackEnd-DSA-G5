package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Jugador {
    int id;
    String nombre;
    String contraseña;
    public Jugador() {
        this.id = RandomUtils.getId();
    }


    public Jugador (String nombre, String contraseña) {
        this();
        this.nombre(nombre);
        this.contraseña(contraseña);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
