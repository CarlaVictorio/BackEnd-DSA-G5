package edu.upc.dsa;

import edu.upc.dsa.models.Receta;

import java.util.List;

public interface RecetaManager {
    public List<Receta> getAllRecetas();
    public Receta getReceta (String idReceta);
    public Receta addReceta(String nombre, int numPaso, double premioDinero, int premioPuntos);
    public void deleteReceta(String idReceta);
    public int getNumPaso(String idReceta);
    public double getPremioDinero(String idReceta);
    public int getPremioPuntos(String idReceta);

    public Receta putReceta (Receta receta);
}
