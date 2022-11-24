package edu.upc.dsa;

import edu.upc.dsa.models.Ingrediente;
import edu.upc.dsa.models.Mapa;

import java.util.List;

public interface MapaManager {
    public List<Ingrediente> getAllIngredientes(String idMapa);
    public Mapa getMapa(String idMapa);

    public void postMapa(String idMapa, String nombreMapa, int numNivelesMapa);
    public void deleteMapa(String idMapa);
    public void putMapa(String idMapa, String nombreMapa, int numNivelesMapa);
}
