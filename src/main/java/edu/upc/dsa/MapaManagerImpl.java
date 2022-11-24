package edu.upc.dsa;

import edu.upc.dsa.models.Ingrediente;
import edu.upc.dsa.models.Mapa;

import java.util.HashMap;
import java.util.List;

public class MapaManagerImpl implements MapaManager{
    HashMap<String,Mapa> listMapas=new HashMap<>();
    @Override
    public List<Ingrediente> getAllIngredientes(String idMapa) {
        return null;
    }



    @Override
    public Mapa getMapa(String idMapa) {
        return listMapas.get(idMapa);
    }

    @Override
    public void postMapa(String idMapa, String nombreMapa, int numNivelesMapa) {
        Mapa mapa=new Mapa(idMapa,nombreMapa,numNivelesMapa);
        listMapas.put(idMapa,mapa);
    }

    @Override
    public void deleteMapa(String idMapa) {

    }

    @Override
    public void putMapa(String idMapa, String nombreMapa, int numNivelesMapa) {

    }




}
