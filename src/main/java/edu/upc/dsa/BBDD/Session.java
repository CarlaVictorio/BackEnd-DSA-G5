package edu.upc.dsa.BBDD;

import edu.upc.dsa.models.Ingrediente;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface Session<E> {
    void save(Object entity);
    void close() ;
    Object get(Class theClass, int ID);
    void update(Object object);
    public Ingrediente getIngredienteId(Ingrediente in, String idIngrediente);
    void delete(Object object);
    List<Object> findAll(Ingrediente ingrediente);
//    List<Object> findAll(Class theClass, HashMap params);
    List<Object> query(String query, Class theClass, HashMap params);
    public Object getByTwoParameters(Class theClass, String byFirstParameter, Object byFirstParameterValue, String bySecondParameter, Object bySecondParameterValue);
}
