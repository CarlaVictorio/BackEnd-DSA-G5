package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Ingrediente;

import java.util.List;

public interface IngredienteManager {
    public Ingrediente getIngrediente (String idIngrediente);
    public Ingrediente addIngrediente(String nombreIngrediente, int nivelDesbloqueoIngrediente, double precioIngrediente);
    public List<Ingrediente> getAllIngredientes();
    public void deleteIngrediente(String idIngrediente);
    public int getNivelDesbloqueoIngrediente(String idIngrediente);
    public double getPrecioIngrediente(String idIngrediente);
    public Ingrediente putIngrediente (Ingrediente ingrediente);

}
