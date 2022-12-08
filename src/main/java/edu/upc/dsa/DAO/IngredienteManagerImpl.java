package edu.upc.dsa.DAO;

import edu.upc.dsa.BBDD.FactorySession;
import edu.upc.dsa.BBDD.Session;
import edu.upc.dsa.models.Ingrediente;
import edu.upc.dsa.models.Jugador;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
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
    Session session = null;
    List<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();

    try{
        session = FactorySession.openSession();
        listaIngredientes = (ArrayList<Ingrediente>) session.findAll(Ingrediente.class);
    }
    catch(Exception e){
        e.printStackTrace();
        listaIngredientes = null;
    }

    finally {
        session.close();
    }
        return listaIngredientes;

    }

    /*
    @Override
    public List<Ingrediente> getAllIngredientes() {

        return this.ingredientes;
    }
*/


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

    /*
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
*/
    /*
    @Override
    public int ComprarIngrediente (Jugador j, int idIngredeinte ){

        Session session = null;
        int error =-1;
        try {
            int precioIngrediente = getPriceByID(idIngrediente);
            double dinero=j.getDinero();//Buscamos el dinero que tiene el usuario
            double dineroRestante = dinero-precioIngrediente;
            if(dineroRestante>0) {
                session = FactorySession.openSession();
                Jugador jug = new Jugador (j.getIdJugador(),j.getNombreJugador(), j.getPasswordJugador(),j.getEmailJugador(),j.getPaisJugador(),dineroRestante);
                session.update(updateuser);//modificamos el dinero restante al usuario
                BuyedObject newBuyedObject = new BuyedObject(0, idObject, user.getUserName());
                session.save(newBuyedObject);
                error = 0;
            }
            else
            {
                error=6;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return error;

    }
*/

}
