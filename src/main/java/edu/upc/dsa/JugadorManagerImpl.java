package edu.upc.dsa;

import edu.upc.dsa.models.Jugador;

import java.util.LinkedList;
import java.util.List;
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

    JugadorManagerImpl(){this.jugadores=new LinkedList<>();}
    @Override
    public List<Jugador> getAllJugadores() {
        return this.jugadores;
    }

    @Override
    public Jugador getJugador(String id) {
        logger.info("getJugador("+id+")");
        for (Jugador j: this.jugadores){
            if (j.getId().equals(id)){
                logger.info("getJugador("+id+"): "+j);
                return j;
            }
        }
        logger.warn("not found "+id);
        return null;
    }

    @Override
    public Jugador addJugador(String nombre, String password) {
        Jugador j = new Jugador(nombre,password);
        logger.info("new Jugador " + j);
        this.jugadores.add(j);
        logger.info("new Jugdor added");
        return j;
    }

    @Override
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
        Jugador j = this.getJugador(jugador.getId());
        if (j!=null){
            logger.info(j+" rebut!");
            j.setNombre(jugador.getNombre());
            j.setPassword(jugador.getPassword());
            logger.info(j+" update");
        } else {
            logger.warn("not found "+j);
        }
        return j;
    }
}
