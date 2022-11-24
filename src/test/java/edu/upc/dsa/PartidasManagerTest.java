package edu.upc.dsa;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Partida;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;


public class PartidasManagerTest {

    PartidasManager pm;

    @Before
    public void setUp(){
        pm = (PartidasManager) new PartidasManagerImpl();
        pm.addPartida(0,1,5,0,0);
        pm.addPartida(1,1,50,1,1);
        pm.addPartida(2,2,100,2,2);
    }

    @After
    public void tearDown() {this.pm = null;}

    @Test
    public void testAddPartida(){
        List<Partida> testPartidas = pm.getAllPartidas();

        Assert.assertEquals(0, testPartidas.get(0).getIdPartida());
        Assert.assertEquals(1, testPartidas.get(0).getNivelActual());
        Assert.assertEquals(5, testPartidas.get(0).getPuntos());
        Assert.assertEquals(0, testPartidas.get(0).getIdMapa());
        Assert.assertEquals(0, testPartidas.get(0).getIdJugador());

        Assert.assertEquals(1, testPartidas.get(1).getIdPartida());
        Assert.assertEquals(1, testPartidas.get(1).getNivelActual());
        Assert.assertEquals(50, testPartidas.get(1).getPuntos());
        Assert.assertEquals(1, testPartidas.get(1).getIdMapa());
        Assert.assertEquals(1, testPartidas.get(1).getIdJugador());

        Assert.assertEquals(2, testPartidas.get(2).getIdPartida());
        Assert.assertEquals(2, testPartidas.get(2).getNivelActual());
        Assert.assertEquals(100, testPartidas.get(2).getPuntos());
        Assert.assertEquals(2, testPartidas.get(2).getIdMapa());
        Assert.assertEquals(2, testPartidas.get(2).getIdJugador());
    }

    @Test
    public void testDeletePartida(){
        List<Partida> testPartidas = pm.getAllPartidas();
        Partida testPartida = testPartidas.get(0);
        pm.deletePartida(testPartida.getIdPartida());

        Assert.assertEquals(1, testPartidas.get(0).getIdPartida());
        Assert.assertEquals(1, testPartidas.get(0).getNivelActual());
        Assert.assertEquals(50, testPartidas.get(0).getPuntos());
        Assert.assertEquals(1, testPartidas.get(0).getIdMapa());
        Assert.assertEquals(1, testPartidas.get(0).getIdJugador());

        Assert.assertEquals(2, testPartidas.get(1).getIdPartida());
        Assert.assertEquals(2, testPartidas.get(1).getNivelActual());
        Assert.assertEquals(100, testPartidas.get(1).getPuntos());
        Assert.assertEquals(2, testPartidas.get(1).getIdMapa());
        Assert.assertEquals(2, testPartidas.get(1).getIdJugador());
    }

    @Test
    public void testPutPartida (){
        List<Partida> testPartidas = pm.getAllPartidas();
        Partida testPartida = testPartidas.get(1);
        testPartida.setPuntos(200);
        Partida partida = pm.updatePartida(testPartida);

        Assert.assertEquals(partida.getIdPartida(), pm.getAllPartidas().get(1).getIdPartida());
        Assert.assertEquals(partida.getPuntos(), pm.getAllPartidas().get(1).getPuntos());
    }

}