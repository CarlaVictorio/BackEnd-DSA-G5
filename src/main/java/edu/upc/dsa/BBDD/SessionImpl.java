package edu.upc.dsa.BBDD;

import edu.upc.dsa.models.Ingrediente;
import edu.upc.dsa.models.Utensilio;
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

            for (String field : ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }

            pstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void close() {
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

    @Override
    public List<Ingrediente> findAll(Ingrediente ingrediente) {
        String selectQuery = QueryHelper.createQuerySELECTAll(ingrediente);
        PreparedStatement pstm = null;
        List<Ingrediente> ListIngre = new ArrayList<Ingrediente>();
        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, 1);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            while (rs.next()) {
                Class clase = ingrediente.getClass();
                Ingrediente o = new Ingrediente();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
                    ObjectHelper.setter(o, rs.getMetaData().getColumnName(i), rs.getObject(i));
                ListIngre.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return ListIngre;
    }

    @Override
    public List<Object> findAllByID(Ingrediente ingrediente, int idJugador) {
        String selectQuery = QueryHelper.createQuerySELECTAllByID(ingrediente);
        PreparedStatement pstm = null;
        List<Object> ListObject = new ArrayList<Object>();
        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, userName);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            while (rs.next()) {
                //Class theClass = Class.forName("edu.upc.eetac.dsa.model.BuyedObject");
                Class theClass = theObject.getClass();
                Object object = theClass.newInstance();
                //BuyedObject object =  new BuyedObject();// parche pq si entra algo que no es object mal !!
                for (int i=1;i<=rs.getMetaData().getColumnCount();i++)
                    ObjectHelper.setter(object,rs.getMetaData().getColumnName(i),rs.getObject(i));
                ListObject.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return ListObject;
    }




    @Override
    public Ingrediente getIngredienteId(Ingrediente in, String idIngrediente) {
        String selectQuery = QueryHelper.createQuerySELECT(in);
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, idIngrediente);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            if (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
                    ObjectHelper.setter(in, rs.getMetaData().getColumnName(i), rs.getObject(i));
            }
            return in;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Utensilio getUtensilioId(Utensilio u, int idUtensilio) {
        String selectQuery = QueryHelper.createQuerySELECT(u);
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, idUtensilio);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            if (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
                    ObjectHelper.setter(u, rs.getMetaData().getColumnName(i), rs.getObject(i));
            }
            return u;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }


    @Override
    public Object getByTwoParameters(Class theClass, String byFirstParameter, Object byFirstParameterValue, String bySecondParameter, Object bySecondParameterValue) {

        String selectQuery = QueryHelper.createQuerySELECTbyTwoParameters(theClass, (String) byFirstParameterValue, (String) bySecondParameterValue);


        PreparedStatement pstm = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;

        try {
            Object object = theClass.getDeclaredConstructor().newInstance();

            pstm = conn.prepareStatement(selectQuery);

            pstm.setObject(1, byFirstParameter);
            pstm.setObject(2, bySecondParameter);
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
