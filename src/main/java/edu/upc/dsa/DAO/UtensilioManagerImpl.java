package edu.upc.dsa.DAO;

import edu.upc.dsa.BBDD.FactorySession;
import edu.upc.dsa.BBDD.Session;
import edu.upc.dsa.models.*;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class UtensilioManagerImpl implements UtensilioManager{
    private static UtensilioManager instance;
    protected List<Utensilio> utensilios;
    final static Logger logger = Logger.getLogger(UtensilioManagerImpl.class);

    public UtensilioManagerImpl(){
        this.utensilios=new LinkedList<>();
    }

    public static UtensilioManager getInstance(){

        if(instance == null)
            instance = new UtensilioManagerImpl();

        return instance;
    }

    /*
    @Override
    public List<Utensilio> getAllUtensilios() {

        return this.utensilios;
    }*/

    @Override
    public List<Utensilio> getAllUtensilios() {
        return null;
    }

    @Override
    public Utensilio getUtensilio (int idUtensilio){
        logger.info("getUtensilio("+idUtensilio+")");

        for (Utensilio u: this.utensilios) {
            if (Objects.equals(u.getIdUtensilio(), idUtensilio)) {
                logger.info("getUtensilio("+idUtensilio+"): "+u);

                return u;
            }
        }
        logger.warn("not found " + idUtensilio);
        return null;
    }

    @Override
    public Utensilio addUtensilio(String nombreUtensilio, int tiempoNivel1, int tiempoNivel2, int tiempoNivel3, double precioUtensilio) {
        Utensilio u = new Utensilio(nombreUtensilio,tiempoNivel1, tiempoNivel2, tiempoNivel3, precioUtensilio);
        logger.info("new Utensilio " + u);
        this.utensilios.add(u);
        logger.info("Se ha añadido un Utensilio");
        return u;
    }

    @Override
    public void deleteUtensilio(int idUtensilio) {
        Utensilio u = this.getUtensilio(idUtensilio);
        if (u==null){
            logger.warn("not found "+u);
        } else {
            logger.info(u+" deleted");
        }
        this.utensilios.remove(u);
    }

    @Override
    public int getTiempoNivel1(int idUtensilio) {
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
    public int getTiempoNivel2(int idUtensilio) {
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
    public int getTiempoNivel3(int idUtensilio) {
        Utensilio u = this.getUtensilio(idUtensilio);
        if (u==null) {
            logger.warn("not found "+u);
            return-1;
        }
        else{
            return u.getTiempoNivel3();
        }
    }
    @Override
    public Utensilio putUtensilio (Utensilio utensilio) {
        Utensilio u = this.getUtensilio(utensilio.getIdUtensilio());
        if (u!=null){
            logger.info(u+" rebut!");
            u.setNombreUtensilio(utensilio.getNombreUtensilio());
            u.setIdUtensilio(utensilio.getIdUtensilio());
            u.setTiempoNivel1(utensilio.getTiempoNivel1());
            u.setTiempoNivel2(utensilio.getTiempoNivel2());
            u.setTiempoNivel3(utensilio.getTiempoNivel3());
            logger.info(u+" update");
        } else {
            logger.warn("not found "+u);
        }
        return u;
    }

    @Override
    public int size() {
        return utensilios.size();
    }

    @Override
    public double getPrecioUtensilio(int idUtensilio) {
        Session session = null;
        Utensilio u = new Utensilio();
        try {
            session = FactorySession.openSession();
            u = (Utensilio) session.getUtensilioId(u,idUtensilio);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return u.getPrecioUtensilio();
    }

    @Override
    public int comprarUtensilio(Jugador j, int idUtensilio, int nivelUtensilio){

        Session session = null;
        int error =-1;
        try {
            double precioUtensilio = getPrecioUtensilio(idUtensilio);
            double dinero=j.getDinero();//Buscamos el dinero que tiene el usuario
            double dineroRestante = dinero-precioUtensilio;
            if(dineroRestante>0) {
                session = FactorySession.openSession();
                Jugador jug = new Jugador (j.getNombreJugador(), j.getPasswordJugador(),j.getEmailJugador(),j.getPaisJugador(),dineroRestante);
                session.update(jug);
                UtensiliosComprados NuevoUtensilio = new UtensiliosComprados(idUtensilio, jug.getIdJugador(), nivelUtensilio);
                session.save(NuevoUtensilio);
                error = 0;
            }
            else
            {
                error=-1;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return error;

    }

    @Override
    public UtensiliosComprados postUtensilioComprado(UtensiliosComprados uc, int idJugador, int idUtensilio) {
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.save(uc);
            return uc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


}
