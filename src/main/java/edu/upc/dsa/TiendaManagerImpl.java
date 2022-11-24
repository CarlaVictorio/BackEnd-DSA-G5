package edu.upc.dsa;

import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Tienda;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class TiendaManagerImpl implements TiendaManager{
    private static TiendaManager instance;
    protected List<Tienda> tiendas;
    final static Logger logger = Logger.getLogger(JugadorManagerImpl.class);

    private TiendaManagerImpl() {
        this.tiendas = new LinkedList<>();
    }

    public static TiendaManager getInstance(){
        if(instance == null){
            instance = new TiendaManagerImpl();
        }
        return instance;
    }
/*
    @Override
    public List<Tienda> getAllTiendas() {
        return this.tiendas;
    }

    @Override
    public List<Jugador> getAllObjetos(String jugador){

    }*/

}
