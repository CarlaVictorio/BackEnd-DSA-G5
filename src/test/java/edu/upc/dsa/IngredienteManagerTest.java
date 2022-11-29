package edu.upc.dsa;

import edu.upc.dsa.models.Ingrediente;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IngredienteManagerTest {

    IngredienteManager im;

    @Before
    public void setUp(){
        im = (IngredienteManager) new JugadorManagerImpl();
        im.addIngrediente("masa pizza",1, 0 );
        im.addIngrediente("mozarella", 1, 0);
        im.addIngrediente("jamon", 2, 0);
    }

    @After
    public void tearDown() {this.im = null;}

    @Test
    public void testAddIngrediente(){
        List<Ingrediente> testIngredientes = im.getAllIngredientes();
        Assert.assertEquals("masa pizza", testIngredientes.get(0).getNombreIngrediente());
        Assert.assertEquals("1", testIngredientes.get(0).getIdIngrediente());
        Assert.assertEquals(1, testIngredientes.get(0).getNivelDesbloqueoIngrediente());
        Assert.assertEquals(0, testIngredientes.get(0).getPrecioIngrediente());

        Assert.assertEquals("mozarella", testIngredientes.get(1).getNombreIngrediente());
        Assert.assertEquals("2", testIngredientes.get(1).getIdIngrediente());
        Assert.assertEquals(1, testIngredientes.get(1).getNivelDesbloqueoIngrediente());
        Assert.assertEquals(0, testIngredientes.get(1).getPrecioIngrediente());

        Assert.assertEquals("jamon", testIngredientes.get(2).getNombreIngrediente());
        Assert.assertEquals("5", testIngredientes.get(2).getIdIngrediente());
        Assert.assertEquals(2, testIngredientes.get(2).getNivelDesbloqueoIngrediente());
        Assert.assertEquals(0, testIngredientes.get(2).getPrecioIngrediente());
    }
    @Test
    public void testDeleteIngrediente(){
        List<Ingrediente> testIngredientes = im.getAllIngredientes();
        Ingrediente testIngrediente = testIngredientes.get(0);
        im.deleteIngrediente(testIngrediente.getIdIngrediente());
        Assert.assertEquals("masa pizza", testIngredientes.get(0).getNombreIngrediente());
        Assert.assertEquals("1", testIngredientes.get(0).getIdIngrediente());
        Assert.assertEquals(1, testIngredientes.get(0).getNivelDesbloqueoIngrediente());
        Assert.assertEquals(0, testIngredientes.get(0).getPrecioIngrediente());

        Assert.assertEquals("mozarella", testIngredientes.get(1).getNombreIngrediente());
        Assert.assertEquals("2", testIngredientes.get(1).getIdIngrediente());
        Assert.assertEquals(1, testIngredientes.get(1).getNivelDesbloqueoIngrediente());
        Assert.assertEquals(0, testIngredientes.get(1).getPrecioIngrediente());
    }
    @Test
    public void testPutIngrediente (){
        List<Ingrediente> testIngredientes = im.getAllIngredientes();
        Ingrediente testIngrediente = testIngredientes.get(1);
        testIngrediente.setPrecioIngrediente(1);
        Ingrediente ingrediente = im.putIngrediente(testIngrediente);

        Assert.assertEquals(ingrediente.getNombreIngrediente(), im.getAllIngredientes().get(1).getNombreIngrediente());
        Assert.assertEquals(ingrediente.getIdIngrediente(), im.getAllIngredientes().get(1).getIdIngrediente());
        Assert.assertEquals(ingrediente.getNivelDesbloqueoIngrediente(), im.getAllIngredientes().get(1).getNivelDesbloqueoIngrediente());
        Assert.assertEquals(ingrediente.getPrecioIngrediente(), im.getAllIngredientes().get(1).getPrecioIngrediente());
    }
}
