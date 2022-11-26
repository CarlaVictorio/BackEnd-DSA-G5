package edu.upc.dsa;

import edu.upc.dsa.models.Ingrediente;
import edu.upc.dsa.models.Mapa;

import java.util.HashMap;
import java.util.List;

public interface MapaManager {
    public HashMap<String, Mapa> getListMapas();
    public void setListMapas(HashMap<String, Mapa> listMapas);
    public HashMap<String,Mapa> getAllMapas();
    public Mapa getMapa(String idMapa);
    public void postMapa(String idMapa, String nombreMapa, int numNivelesMapa);
    public void deleteMapa(String idMapa);
    public void putMapa(String idMapa, String nombreMapa, int numNivelesMapa);
}
