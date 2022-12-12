package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Ingrediente;
import edu.upc.dsa.models.Jugador;

import java.sql.SQLException;
import java.util.List;

public interface IngredienteManager {
    public Ingrediente getIngrediente (int idIngrediente);
    public Ingrediente getIngredienteByNombre (String nombre);
    public Ingrediente addIngrediente(String nombreIngrediente, int nivelDesbloqueoIngrediente, double precioIngrediente);
    public List<Ingrediente> getAllIngredientes();
    public void deleteIngrediente(int idIngrediente);
    public int getNivelDesbloqueoIngrediente(int idIngrediente);
    public double getPrecioIngrediente(String idIngrediente);
    public Ingrediente putIngrediente (Ingrediente ingrediente);
    public int comprarIngrediente (Jugador j, String idIngrediente );


    public int size();
}
