package edu.upc.dsa;

import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.util.ObjectHelper;
import org.junit.Assert;
import org.junit.Test;

public class ObjectHelperTest {


    @Test
    public void test(){
        Jugador j = new Jugador("Carme", "11111", "22222", "3333");

        Assert.assertEquals("Carme", ObjectHelper.getter(j, "nombreJugador"));

        ObjectHelper.setter(j, "name", "XXXX");

        Assert.assertEquals("XXXX", j.getNombreJugador());
    }


}
