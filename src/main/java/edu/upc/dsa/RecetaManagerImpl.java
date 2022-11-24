package edu.upc.dsa;

import edu.upc.dsa.models.Receta;
import edu.upc.dsa.models.Utensilio;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class RecetaManagerImpl implements RecetaManager{
    private static RecetaManager instance;
    protected List<Receta> recetas;
    final static Logger logger = Logger.getLogger(RecetaManagerImpl.class);

    RecetaManagerImpl(){
        this.recetas=new LinkedList<>();
    }

    public static RecetaManager getInstance(){

        if(instance == null)
            instance = new RecetaManagerImpl();

        return instance;
    }

    @Override
    public List<Receta> getAllRecetas() {

        return this.recetas;
    }

    @Override
    public Receta getReceta (String idReceta){
        logger.info("getReceta("+idReceta+")");

        for (Receta r: this.recetas) {
            if (r.getIdReceta()==idReceta) {
                logger.info("getReceta("+idReceta+"): "+r);

                return r;
            }
        }
        logger.warn("not found " + idReceta);
        return null;
    }

    /*@Override
    public Receta addReceta(String idUtensilio, String nombreUtensilio, int tiempoNivel1, int tiempoNivel2, int tiempoNivel3) {
        Utensilio u = new Utensilio(idUtensilio, nombreUtensilio,tiempoNivel1, tiempoNivel2, tiempoNivel3);
        logger.info("new Utensilio " + u);
        this.utensilios.add(u);
        logger.info("Se ha añadido un Utensilio");
        return u;
    }*/
}
