package edu.upc.dsa.DAO;

import edu.upc.dsa.BBDD.FactorySession;
import edu.upc.dsa.BBDD.Session;
import edu.upc.dsa.models.Jugador;

import java.util.LinkedList;
import java.util.List;

import edu.upc.dsa.models.LogIn;
import edu.upc.dsa.models.Registro;
import org.apache.log4j.Logger;

public class JugadorManagerImpl implements JugadorManager{
    private static JugadorManager instance;
    protected List<Jugador> jugadores;
    final static Logger logger = Logger.getLogger(JugadorManagerImpl.class);

    public static JugadorManager getInstance(){
        //logger.info(instance);
        if(instance == null)
            instance = new JugadorManagerImpl();
        //logger.info(instance);
        return instance;
    }
    public int size(){
        int s = this.jugadores.size();
        logger.info("size " + s);
        return s;
    }
    public Jugador searchJugador(String nombre, String password) {
        logger.info("getJugador("+nombre+", "+password+")");
        for (Jugador j: this.jugadores){
            if (j.getNombre().equals(nombre) && j.getPassword().equals(password)){
                logger.info("getJugador("+nombre+", "+password+"): "+j);
                return j;
            }
        }
        logger.warn("not found "+nombre);
        return null;
    }

    public JugadorManagerImpl(){this.jugadores=new LinkedList<>();}
    @Override
    public List<Jugador> getAllJugadores() {
        return this.jugadores;
    }

    /*@Override
    public Jugador getJugador(String id) {
        logger.info("getJugador("+id+")");
        for (Jugador j: this.jugadores){
            if (j.getIdJugador().equals(id)){
                logger.info("getJugador("+id+"): "+j);
                return j;
            }
        }
        logger.warn("not found "+id);
        return null;
    }*/

    @Override
    public Jugador addJugador(String nombre, String password, String email, String pais, double dinero) {
        Jugador j = searchJugador(nombre, password);
        if (j==null){
            Jugador jugador = new Jugador(nombre,password,email,pais, dinero);
            logger.info("new Jugador " + jugador.getNombre());
            this.jugadores.add(jugador);
            logger.info("new Jugdor added");
            return jugador;
        } else {
            return null;
        }
    }

   /* @Override
    public void deleteJugador(String id) {
        Jugador j = this.getJugador(id);
        if (j==null){
            logger.warn("not found "+j);
        } else {
            logger.info(j+" deleted");
        }
        this.jugadores.remove(j);
    }

    @Override
    public Jugador putJugador(Jugador jugador) {
        Jugador j = this.getJugador(jugador.getIdJugador());
        if (j!=null){
            logger.info(j+" rebut!");
            j.setNombreJugador(jugador.getNombreJugador());
            j.setPasswordJugador(jugador.getPasswordJugador());
            logger.info(j+" update");
        } else {
            logger.warn("not found "+j);
        }
        return j;
    }*/

    @Override
    public Jugador logInJugador(LogIn logInParams)  { //LOGIN
        logger.info("logInJugador("+logInParams.getNombre()+", "+logInParams.getPassword()+")");
        Session session = null;
        Jugador jugador = null;
        try {
            session = FactorySession.openSession();
            jugador= (Jugador) session.getByTwoParameters(Jugador.class, logInParams.getNombre(), "nombre", logInParams.getPassword(), "password");
            if (jugador!=null){
                logger.info(jugador+" rebut!");
                return jugador;
            }
        }
        catch (Exception e) {
            logger.warn("not found "+jugador);
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return null;
    }


    @Override
    public Jugador registroJugador(Registro registro)  {

            Session session = null;
            try {
                session = FactorySession.openSession();
                Jugador jugador= (Jugador) session.getByTwoParameters(Jugador.class, registro.getNombre(), "nombreJugador", registro.getPassword(), "passwordJugador");
                if(jugador==null){
                    Jugador jugadorAdd = new Jugador(registro.getNombre(),registro.getPassword(),registro.getEmail(),registro.getPais(), registro.getDinero());
                    logger.info("new Jugador " + jugadorAdd.getNombre());
                    session.save(jugadorAdd);
                    logger.info("new Jugdor added");
                    return jugadorAdd;
                }
            }
            catch (Throwable e) {
                e.printStackTrace();
            }
            finally {
                session.close();
            }
            return null;
        }
    }

