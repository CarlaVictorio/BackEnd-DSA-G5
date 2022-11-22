package edu.upc.dsa;

import edu.upc.dsa.models.Jugador;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

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

    private JugadorManagerImpl(){this.jugadores=new LinkedList<>();}
    @Override
    public List<Jugador> getAllJugadores() {
        return this.jugadores;
    }

    @Override
    public Jugador getJugador(String id) {
        logger.info("getTrack("+id+")");
        for (Jugador j: this.jugadores){
            if (j.getId().equals(id)){
                logger.info("getTrack("+id+"): "+j);
                return j;
            }
        }
        logger.warn("not found"+id);
        return null;
    }

    @Override
    public Jugador addJugador(String nombre, String contraseña) {
        return null;
    }

    @Override
    public void deleteJugador(String id) {
        Jugador j = this.
    }

    @Override
    public Jugador putJugador(Jugador jugador) {
        return null;
    }
}
