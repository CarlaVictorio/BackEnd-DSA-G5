package edu.upc.dsa;

import edu.upc.dsa.models.Ingrediente;
import edu.upc.dsa.models.Mapa;

import java.util.List;

public interface MapaManager {
    public List<Ingrediente> getAllIngredientes(int idMapa);
    public Mapa getMapa(int idMapa);
    public void postMapa(int idMapa, String nombreMapa, int numNivelesMapa);
    public void deleteMapa(int idMapa);
    public void putMapa(int idMapa, String nombreMapa, int numNivelesMapa);
}
