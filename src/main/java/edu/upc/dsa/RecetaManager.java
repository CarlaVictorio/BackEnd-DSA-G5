package edu.upc.dsa;

import edu.upc.dsa.models.Receta;

import java.util.List;

public interface RecetaManager {
    public List<Receta> getAllRecetas();
    public Receta getReceta (String idReceta);
}
