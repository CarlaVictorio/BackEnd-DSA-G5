package edu.upc.dsa.BBDD;

import edu.upc.dsa.models.Ingrediente;
import edu.upc.dsa.util.ObjectHelper;
import edu.upc.dsa.util.QueryHelper;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SessionImpl implements Session {
    private final Connection conn;

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }

    public void save(Object entity) {

        String insertQuery = QueryHelper.createQueryINSERT(entity);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            pstm.setObject(1, 0);
            int i = 2;

            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }

            pstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void close()  {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Object get(Class theClass, int ID) {
        return null;
    }

    public void update(Object object) {

    }

    public void delete(Object object) {

    }

    public List<Ingrediente> findAll(Class ingrediente) {
        String selectQuery = QueryHelper.createQuerySELECTAll(ingrediente);
        PreparedStatement pstm = null;
        List<Ingrediente> ListIngre = new ArrayList<Ingrediente>();
        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, 1);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            while (rs.next()) {
                Class theClass = ingrediente.getClass();
                Ingrediente o = new Ingrediente();
                for (int i=1;i<=rs.getMetaData().getColumnCount();i++)
                    ObjectHelper.setter(o,rs.getMetaData().getColumnName(i),rs.getObject(i));
                ListIngre.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return ListIngre;
    }

    public List<Object> findAll(Class theClass, HashMap params) {
        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }
    public Object getByTwoParameters(Class theClass, String byFirstParameter, Object byFirstParameterValue, String bySecondParameter, Object bySecondParameterValue) {

        String selectQuery = QueryHelper.createQuerySELECTbyTwoParameters(theClass, byFirstParameter, bySecondParameter);


        PreparedStatement pstm = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;

        try {
            Object object = theClass.getDeclaredConstructor().newInstance();

            pstm = conn.prepareStatement(selectQuery);

            pstm.setObject(1, byFirstParameterValue);
            pstm.setObject(2, bySecondParameterValue);
            pstm.executeQuery();
            rs = pstm.getResultSet();

            if (rs.next()) {

                rsmd = rs.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String field = rsmd.getColumnName(i);
                    ObjectHelper.setter(object, field, rs.getObject(i));
                }
                return object;

            } else {
                return null;
            }

        } catch (SQLException | NoSuchMethodException | IllegalAccessException | InstantiationException |
                 InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
