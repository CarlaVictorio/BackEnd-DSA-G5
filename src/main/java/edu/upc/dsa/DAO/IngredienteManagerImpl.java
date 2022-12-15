package edu.upc.dsa.DAO;

import edu.upc.dsa.BBDD.FactorySession;
import edu.upc.dsa.BBDD.Session;
import edu.upc.dsa.models.Ingrediente;
import edu.upc.dsa.models.IngredientesComprados;
import edu.upc.dsa.models.Jugador;
import io.swagger.models.auth.In;
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
        listaIngredientes = (ArrayList<Ingrediente>) session.findAll(new Ingrediente());
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
    public Ingrediente getIngrediente (int idIngrediente){
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
    public Ingrediente getIngredienteByNombre(String nombre) {
        logger.info("getIngrediente("+nombre+")");

        for (Ingrediente i: this.ingredientes) {
            if (i.getNombreIngrediente()==nombre) {
                logger.info("getIngrediente("+nombre+"): "+i);
                return i;
            }
        }
        logger.warn("not found " + nombre);
        return null;    }

    @Override
    public Ingrediente addIngrediente(String nombreIngrediente, int nivelDesbloqueoIngrediente, double precioIngrediente) {
        Ingrediente i = new Ingrediente(nombreIngrediente,nivelDesbloqueoIngrediente, precioIngrediente);
        logger.info("new Ingrediente " + i);
        this.ingredientes.add(i);
        logger.info("Se ha añadido un Ingrediente");
        return i;
    }

    @Override
    public void deleteIngrediente(int idIngrediente) {
        Ingrediente i = this.getIngrediente(idIngrediente);
        if (i==null){
            logger.warn("not found "+i);
        } else {
            logger.info(i+" deleted");
        }
        this.ingredientes.remove(i);
    }
    @Override
    public int getNivelDesbloqueoIngrediente(int idIngrediente) {
        Ingrediente i = this.getIngrediente(idIngrediente);
        if (i==null) {
            logger.warn("not found "+i);
            return-1;
        }
        else{
            return i.getNivelDesbloqueoIngrediente();
        }
    }
/*
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
    }*/

    @Override
    public double getPrecioIngrediente(String idIngrediente) {
        Session session = null;
        Ingrediente i = new Ingrediente();
        try {
            session = FactorySession.openSession();
            i = (Ingrediente) session.getIngredienteId(i,idIngrediente);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return i.getPrecioIngrediente();
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




    @Override
    public int comprarIngrediente(Jugador j, String idIngrediente ){

        Session session = null;
        int error =-1;
        try {
            double precioIngrediente = getPrecioIngrediente(idIngrediente);
            double dinero=j.getDinero();//Buscamos el dinero que tiene el usuario
            double dineroRestante = dinero-precioIngrediente;
            if(dineroRestante>0) {
                session = FactorySession.openSession();
                Jugador jug = new Jugador (j.getNombreJugador(), j.getPasswordJugador(),j.getEmailJugador(),j.getPaisJugador(),dineroRestante);
                session.update(jug);
                IngredientesComprados NuevoIngrediente = new IngredientesComprados(idIngrediente, jug.getNombreJugador());
                session.save(NuevoIngrediente);
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

    public List<Ingrediente> listaIngredientesComprados(int idJugador) throws SQLException {

        Session session = null;
        List<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
        try {
            session = FactorySession.openSession();
            List<IngredientesComprados> listaComprados = session.findAllByName(new IngredientesComprados(), idJugador);

            for (IngredientesComprados ingredienteComprado : listaComprados)
            {
                Ingrediente nuevoIngrediente = new Ingrediente();
                int idIn = ingredienteComprado.getIdIngredienteComprado();
                nuevoIngrediente = (Ingrediente) session.getIngredienteId(nuevoIngrediente, idIn);
                listaIngredientes.add(nuevoIngrediente);

            }

        } catch (Exception e) {
            e.printStackTrace();
            listaIngredientes = null;
        } finally {
            session.close();
            return listaIngredientes;
        }
    }


}
