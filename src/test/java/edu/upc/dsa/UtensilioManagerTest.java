package edu.upc.dsa;


import edu.upc.dsa.models.Utensilio;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UtensilioManagerTest {
    UtensilioManager um;

    @Before
    public void setUp(){
        um = (UtensilioManager) new UtensilioManagerImpl();
        um.addUtensilio("50","plancha", 15, 10, 5);
        um.addUtensilio("51","dispensador cocacola", 15, 10, 5);
        um.addUtensilio("54","horno", 15, 10, 5);
    }

    @After
    public void tearDown() {this.um = null;}

    @Test
    public void testAddUtensilio(){
        List<Utensilio> testUtensilios = um.getAllUtensilios();
        Assert.assertEquals("plancha", testUtensilios.get(0).getNombreUtensilio());
        Assert.assertEquals("50", testUtensilios.get(0).getIdUtensilio());
        Assert.assertEquals(15, testUtensilios.get(0).getTiempoNivel1());
        Assert.assertEquals(10, testUtensilios.get(0).getTiempoNivel2());
        Assert.assertEquals(5, testUtensilios.get(0).getTiempoNivel3());

        Assert.assertEquals("dispensador cocacola", testUtensilios.get(1).getNombreUtensilio());
        Assert.assertEquals("51", testUtensilios.get(1).getIdUtensilio());
        Assert.assertEquals(15, testUtensilios.get(1).getTiempoNivel1());
        Assert.assertEquals(10, testUtensilios.get(1).getTiempoNivel2());
        Assert.assertEquals(5, testUtensilios.get(1).getTiempoNivel3());

        Assert.assertEquals("horno", testUtensilios.get(2).getNombreUtensilio());
        Assert.assertEquals("54", testUtensilios.get(2).getIdUtensilio());
        Assert.assertEquals(15, testUtensilios.get(2).getTiempoNivel1());
        Assert.assertEquals(10, testUtensilios.get(2).getTiempoNivel2());
        Assert.assertEquals(5, testUtensilios.get(2).getTiempoNivel3());
    }
    @Test
    public void testDeleteUtensilio(){
        List<Utensilio> testUtensilios = um.getAllUtensilios();
        Utensilio testUtensilio = testUtensilios.get(0);
        um.deleteUtensilio(testUtensilio.getIdUtensilio());
        Assert.assertEquals("plancha", testUtensilios.get(0).getNombreUtensilio());
        Assert.assertEquals("50", testUtensilios.get(0).getIdUtensilio());
        Assert.assertEquals(15, testUtensilios.get(0).getTiempoNivel1());
        Assert.assertEquals(10, testUtensilios.get(0).getTiempoNivel2());
        Assert.assertEquals(5, testUtensilios.get(0).getTiempoNivel3());

        Assert.assertEquals("dispensador cocacola", testUtensilios.get(1).getNombreUtensilio());
        Assert.assertEquals("51", testUtensilios.get(1).getIdUtensilio());
        Assert.assertEquals(15, testUtensilios.get(1).getTiempoNivel1());
        Assert.assertEquals(10, testUtensilios.get(1).getTiempoNivel2());
        Assert.assertEquals(5, testUtensilios.get(1).getTiempoNivel3());
    }
    @Test
    public void testPutUtensilio (){
        List<Utensilio> testUtensilios = um.getAllUtensilios();
        Utensilio testUtensilio = testUtensilios.get(1);
        testUtensilio.setTiempoNivel1(20);
        Utensilio utensilio = um.putUtensilio(testUtensilio);

        Assert.assertEquals(utensilio.getNombreUtensilio(), um.getAllUtensilios().get(1).getNombreUtensilio());
        Assert.assertEquals(utensilio.getIdUtensilio(), um.getAllUtensilios().get(1).getIdUtensilio());
        Assert.assertEquals(utensilio.getTiempoNivel1(), um.getAllUtensilios().get(1).getTiempoNivel1());
        Assert.assertEquals(utensilio.getTiempoNivel2(), um.getAllUtensilios().get(1).getTiempoNivel2());
        Assert.assertEquals(utensilio.getTiempoNivel3(), um.getAllUtensilios().get(1).getTiempoNivel3());
    }
}
