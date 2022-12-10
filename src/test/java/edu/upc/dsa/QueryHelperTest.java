package edu.upc.dsa;

import edu.upc.dsa.models.Ingrediente;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.util.QueryHelper;

import org.junit.Assert;
import org.junit.Test;

public class QueryHelperTest {


    @Test
    public void testQueryINSERT() {
        Assert.assertEquals("INSERT INTO Jugador (ID, idJugador, nombreJugador, passwordJugador, emailJugador, paisJugador) VALUES (?, ?, ?, ?, ?, ?)",
                QueryHelper.createQueryINSERT(new Jugador("Juan", "lopez", "333333","4444", 100)));
    }
    @Test
    public void testCreateQuerySELECTbyTwoParameters(){
        Assert.assertEquals("SELECT * FROM Jugador WHERE nombreJugador = ? AND passwordJugador = ?",
                QueryHelper.createQuerySELECTbyTwoParameters(Jugador.class,"nombreJugador","passwordJugador"));
    }

    @Test
    public void testQuerySELECT() {
        Assert.assertEquals("SELECT * FROM Ingredientes WHERE ID = ?",
                QueryHelper.createQuerySELECT(new Ingrediente("Lechuga", 1, 10)));
    }
/*
    @Test
    public void testQuerySELECT2() {
        Assert.assertEquals("SELECT * FROM Deparment WHERE ID = ?",
                QueryHelper.createQuerySELECT(new Deparment("ENTEL", "ENGINYERIA TELEMÀTICA")));
    }
*/
}
