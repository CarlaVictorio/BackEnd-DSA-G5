package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Mapa;

import java.util.HashMap;

public interface MapaManager {
    public HashMap<String, Mapa> getListMapas();
    public void setListMapas(HashMap<String, Mapa> listMapas);
    public HashMap<String,Mapa> getAllMapas();
    public Mapa getMapa(String idMapa);
    public Mapa postMapa( String nombreMapa, int numNivelesMapa);
    public void deleteMapa(String idMapa);
    public Mapa putMapa(String idMapa, String nombreMapa, int numNivelesMapa);
}
