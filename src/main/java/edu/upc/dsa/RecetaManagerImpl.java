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

    @Override
    public Receta addReceta(String idReceta, String nombre, int numPaso, double premioDinero, int premioPuntos) {
        Receta r = new Receta(idReceta, nombre,numPaso, premioDinero, premioPuntos);
        logger.info("new Receta " + r);
        this.recetas.add(r);
        logger.info("Se ha añadido una Receta");
        return r;
    }

    @Override
    public void deleteReceta(String idReceta) {
        Receta r = this.getReceta(idReceta);
        if (r==null){
            logger.warn("not found "+r);
        } else {
            logger.info(r+" deleted");
        }
        this.recetas.remove(r);
    }

    @Override
    public int getNumPaso(String idReceta) {
        Receta r = this.getReceta(idReceta);
        if (r==null) {
            logger.warn("not found "+r);
            return-1;
        }
        else{
            return r.getNumPaso();
        }
    }

    @Override
    public double getPremioDinero(String idReceta) {
        Receta r = this.getReceta(idReceta);
        if (r==null) {
            logger.warn("not found "+r);
            return-1;
        }
        else{
            return r.getPremioDinero();
        }
    }

    @Override
    public int getPremioPuntos(String idReceta) {
        Receta r = this.getReceta(idReceta);
        if (r==null) {
            logger.warn("not found "+r);
            return-1;
        }
        else{
            return r.getPremioPuntos();
        }
    }
}
