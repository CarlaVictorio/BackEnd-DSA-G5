package edu.upc.dsa;

import edu.upc.dsa.models.Ingrediente;
import edu.upc.dsa.models.Utensilio;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class UtensilioManagerImpl implements UtensilioManager{
    private static UtensilioManager instance;
    protected List<Utensilio> utensilios;
    final static Logger logger = Logger.getLogger(UtensilioManagerImpl.class);

    UtensilioManagerImpl(){
        this.utensilios=new LinkedList<>();
    }

    public static UtensilioManager getInstance(){

        if(instance == null)
            instance = new UtensilioManagerImpl();

        return instance;
    }

    @Override
    public List<Utensilio> getAllUtensilios() {

        return this.utensilios;
    }

    @Override
    public Utensilio getUtensilio (String idUtensilio){
        logger.info("getUtensilio("+idUtensilio+")");

        for (Utensilio u: this.utensilios) {
            if (u.getIdUtensilio()==idUtensilio) {
                logger.info("getUtensilio("+idUtensilio+"): "+u);

                return u;
            }
        }
        logger.warn("not found " + idUtensilio);
        return null;
    }

    @Override
    public Utensilio addUtensilio(String idUtensilio, String nombreUtensilio, int tiempoNivel1, int tiempoNivel2, int tiempoNivel3) {
        Utensilio u = new Utensilio(idUtensilio, nombreUtensilio,tiempoNivel1, tiempoNivel2, tiempoNivel3);
        logger.info("new Utensilio " + u);
        this.utensilios.add(u);
        logger.info("Se ha añadido un Utensilio");
        return u;
    }

    @Override
    public void deleteUtensilio(String idUtensilio) {
        Utensilio u = this.getUtensilio(idUtensilio);
        if (u==null){
            logger.warn("not found "+u);
        } else {
            logger.info(u+" deleted");
        }
        this.utensilios.remove(u);
    }

    @Override
    public int getTiempoNivel1(String idUtensilio) {
        Utensilio u = this.getUtensilio(idUtensilio);
        if (u==null) {
            logger.warn("not found "+u);
            return-1;
        }
        else{
            return u.getTiempoNivel1();
        }
    }

    @Override
    public int getTiempoNivel2(String idUtensilio) {
        Utensilio u = this.getUtensilio(idUtensilio);
        if (u==null) {
            logger.warn("not found "+u);
            return-1;
        }
        else{
            return u.getTiempoNivel2();
        }
    }

    @Override
    public int getTiempoNivel3(String idUtensilio) {
        Utensilio u = this.getUtensilio(idUtensilio);
        if (u==null) {
            logger.warn("not found "+u);
            return-1;
        }
        else{
            return u.getTiempoNivel3();
        }
    }


}
