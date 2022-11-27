package edu.upc.dsa;

import edu.upc.dsa.models.Utensilio;

import java.util.List;

public interface UtensilioManager {
    public List<Utensilio> getAllUtensilios();
    public Utensilio getUtensilio (String idUtensilio);
    public Utensilio addUtensilio(String idUtensilio, String nombreUtensilio, int tiempoNivel1, int tiempoNivel2, int tiempoNivel3);
    public void deleteUtensilio(String idUtensilio);
    public int getTiempoNivel1(String idUtensilio);
    public int getTiempoNivel2(String idUtensilio);
    public int getTiempoNivel3(String idUtensilio);

    public Utensilio putUtensilio (Utensilio utensilio);
}
