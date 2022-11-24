package edu.upc.dsa;

import edu.upc.dsa.models.Ingrediente;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Partida;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class IngredienteManagerImpl implements IngredienteManager {
    private static IngredienteManager instance;
    protected List<Ingrediente> ingredientes;
    final static Logger logger = Logger.getLogger(IngredienteManagerImpl.class);

    IngredienteManagerImpl(){
        this.ingredientes=new LinkedList<>();
    }

    public static IngredienteManager getInstance(){

        if(instance == null)
            instance = new IngredienteManagerImpl();

        return instance;
    }

    @Override
    public Ingrediente getIngrediente (String idIngrediente){
        logger.info("getPartida("+idPartida+")");

        for (Partida p: this.partidasList) {
            if (p.getIdPartida()==idPartida) {
                logger.info("getPartida("+idPartida+"): "+p);

                return p;
            }
        }
        logger.warn("not found " + idPartida);
        return null;
    }

}
