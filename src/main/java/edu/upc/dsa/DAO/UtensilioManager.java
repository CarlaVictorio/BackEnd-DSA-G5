package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Utensilio;

import java.util.List;

public interface UtensilioManager {
    public List<Utensilio> getAllUtensilios();
    public Utensilio getUtensilio (String idUtensilio);
    public Utensilio addUtensilio(String nombreUtensilio, int tiempoNivel1, int tiempoNivel2, int tiempoNivel3, double precioUtensilio);
    public void deleteUtensilio(String idUtensilio);
    public int getTiempoNivel1(String idUtensilio);
    public int getTiempoNivel2(String idUtensilio);
    public int getTiempoNivel3(String idUtensilio);

    public Utensilio putUtensilio (Utensilio utensilio);

    public double getPrecioUtensilio(String idUtensilio);
    public int comprarUtensilio(Jugador j, String idUtensilio, String nivelUtensilio );

    public int size();
}
