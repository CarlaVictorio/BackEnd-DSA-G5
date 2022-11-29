package edu.upc.dsa;
import edu.upc.dsa.models.Jugador;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JugadorManagerTest {
    JugadorManager jm;

    @Before
    public void setUp(){
        jm = (JugadorManager) new JugadorManagerImpl();
        jm.addJugador("Juan","1111", "juan@gmail.com", "España");
        jm.addJugador("Victoria","2222", "victoria@gmail.com", "España");
        jm.addJugador("Maria","3333", "maria@gmail.com", "Francia");
    }

    @After
    public void tearDown() {this.jm = null;}

    @Test
    public void testAddJugador(){
        List<Jugador> testJugadores = jm.getAllJugadores();
        Assert.assertEquals("Juan", testJugadores.get(0).getNombre());
        Assert.assertEquals("1111", testJugadores.get(0).getPassword());

        Assert.assertEquals("Victoria", testJugadores.get(1).getNombre());
        Assert.assertEquals("2222", testJugadores.get(1).getPassword());

        Assert.assertEquals("Maria", testJugadores.get(2).getNombre());
        Assert.assertEquals("3333", testJugadores.get(2).getPassword());
    }
    @Test
    public void testDeletedJugador(){
        List<Jugador> testJugadores = jm.getAllJugadores();
        Jugador testJugador = testJugadores.get(0);
        jm.deleteJugador(testJugador.getId());
        Assert.assertEquals("Victoria", testJugadores.get(0).getNombre());
        Assert.assertEquals("2222", testJugadores.get(0).getPassword());

        Assert.assertEquals("Maria", testJugadores.get(1).getNombre());
        Assert.assertEquals("3333", testJugadores.get(1).getPassword());
    }
    @Test
    public void testPutJugador (){
        List<Jugador> testJugadores = jm.getAllJugadores();
        Jugador testJugador = testJugadores.get(1);
        testJugador.setPassword("1212");
        Jugador jugador = jm.putJugador(testJugador);

        Assert.assertEquals(jugador.getNombre(), jm.getAllJugadores().get(1).getNombre());
        Assert.assertEquals(jugador.getPassword(), jm.getAllJugadores().get(1).getPassword());
    }
}
