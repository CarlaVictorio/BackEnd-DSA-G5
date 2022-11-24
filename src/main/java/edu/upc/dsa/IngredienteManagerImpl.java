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
    public List<Ingrediente> getAllIngredientes() {

        return this.ingredientes;
    }

    @Override
    public Ingrediente getIngrediente (String idIngrediente){
        logger.info("getIngrediente("+idIngrediente+")");

        for (Ingrediente i: this.ingredientes) {
            if (i.getIdIngrediente()==idIngrediente) {
                logger.info("getIngrediente("+idIngrediente+"): "+i);

                return i;
            }
        }
        logger.warn("not found " + idIngrediente);
        return null;
    }

    @Override
    public Ingrediente addIngrediente(String idIngrediente, String nombreIngrediente, int nivelDesbloqueoIngrediente, double precioIngrediente) {
        Ingrediente i = new Ingrediente(idIngrediente, nombreIngrediente,nivelDesbloqueoIngrediente, precioIngrediente);
        logger.info("new Ingrediente " + i);
        this.ingredientes.add(i);
        logger.info("Se ha añadido un Ingrediente");
        return i;
    }

    @Override
    public void deleteIngrediente(String idIngrediente) {
        Ingrediente i = this.getIngrediente(idIngrediente);
        if (i==null){
            logger.warn("not found "+i);
        } else {
            logger.info(i+" deleted");
        }
        this.ingredientes.remove(i);
    }
    @Override
    public int getNivelDesbloqueoIngrediente(String idIngrediente) {
        Ingrediente i = this.getIngrediente(idIngrediente);
        if (i==null) {
            logger.warn("not found "+i);
            return-1;
        }
        else{
            return i.getNivelDesbloqueoIngrediente();
        }
    }

    @Override
    public double getPrecioIngrediente(String idIngrediente) {
        Ingrediente i = this.getIngrediente(idIngrediente);
        if (i==null) {
            logger.warn("not found "+i);
            return-1;
        }
        else{
            return i.getPrecioIngrediente();
        }
    }

}
