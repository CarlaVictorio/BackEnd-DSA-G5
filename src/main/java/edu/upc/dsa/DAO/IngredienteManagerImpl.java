package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Ingrediente;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class IngredienteManagerImpl implements IngredienteManager {
    private static IngredienteManager instance;
    protected List<Ingrediente> ingredientes;
    final static Logger logger = Logger.getLogger(IngredienteManagerImpl.class);

    public IngredienteManagerImpl(){
        this.ingredientes=new LinkedList<>();
    }

    public static IngredienteManager getInstance(){

        if(instance == null)
            instance = new IngredienteManagerImpl();

        return instance;
    }
    public int size(){
        return ingredientes.size();
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
    public Ingrediente addIngrediente(String nombreIngrediente, int nivelDesbloqueoIngrediente, double precioIngrediente) {
        Ingrediente i = new Ingrediente(nombreIngrediente,nivelDesbloqueoIngrediente, precioIngrediente);
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
    @Override
    public Ingrediente putIngrediente (Ingrediente ingrediente) {
        Ingrediente i = this.getIngrediente(ingrediente.getIdIngrediente());
        if (i!=null){
            logger.info(i+" rebut!");
            i.setNombreIngrediente(ingrediente.getNombreIngrediente());
            i.setIdIngrediente(ingrediente.getIdIngrediente());
            i.setNivelDesbloqueoIngrediente(ingrediente.getNivelDesbloqueoIngrediente());
            i.setPrecioIngrediente(ingrediente.getPrecioIngrediente());
            logger.info(i+" update");
        } else {
            logger.warn("not found "+i);
        }
        return i;
    }

}
