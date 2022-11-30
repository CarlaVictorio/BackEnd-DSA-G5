package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Mapa;

import java.util.HashMap;

import org.apache.log4j.Logger;

public class MapaManagerImpl implements MapaManager{
    HashMap<String,Mapa> listMapas=new HashMap<>();
    private static MapaManager instance;
    final static Logger logger= Logger.getLogger(MapaManagerImpl.class);

    public static MapaManager getInstance(){
        if(instance==null){
            instance=new MapaManagerImpl();
        }
        return instance;
    }

    public HashMap<String, Mapa> getListMapas() {
        return listMapas;
    }

    public void setListMapas(HashMap<String, Mapa> listMapas) {
        this.listMapas = listMapas;
    }

    @Override
    public HashMap<String, Mapa> getAllMapas() {
        logger.info("Lista Mapas: "+listMapas);
        return listMapas;
    }

    @Override
    public Mapa getMapa(String idMapa) {
        boolean exist=listMapas.containsKey(idMapa);
        if(exist){
            logger.info("Mapa dado: "+listMapas.get(idMapa));
            return listMapas.get(idMapa);
        }
        else {
            logger.warn("not found "+idMapa);
            return null;
        }

    }

    @Override
    public Mapa postMapa(String nombreMapa, int numNivelesMapa) {
        Mapa mapa=new Mapa(nombreMapa,numNivelesMapa);
        listMapas.put(mapa.getId(),mapa);
        logger.info("Mapa añadido: "+mapa);
        return mapa;
    }

    @Override
    public void deleteMapa(String idMapa) {
        Mapa mapa= listMapas.remove(idMapa);
        if(mapa!=null){
            logger.info("Mapa eliminado: "+mapa);
        }
        else{
            logger.warn("Mapa no encontrado");
        }
    }

    @Override
    public Mapa putMapa(String idMapa, String nombreMapa, int numNivelesMapa) {
        Mapa mapa=listMapas.get(idMapa);
        mapa.setNombre(nombreMapa);
        mapa.setNumNiveles(numNivelesMapa);
        if(mapa!=null){
            logger.info("Mapa actualizado: "+mapa);
            return mapa;
        }
        else{
            logger.warn("Mapa no encontrado");
            return null;
        }

    }
}
