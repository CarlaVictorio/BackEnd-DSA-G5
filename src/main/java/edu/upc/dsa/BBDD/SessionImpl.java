package edu.upc.dsa.BBDD;

import edu.upc.dsa.util.ObjectHelper;
import edu.upc.dsa.util.QueryHelper;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;


public class SessionImpl implements Session {
    private final Connection conn;

    final Logger logger = Logger.getLogger(SessionImpl.class.getName());

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
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public void close() throws SQLException {
        conn.close();
    }

    public Object get(Object object) {

        Class theClass = object.getClass();
        String selectQuery = QueryHelper.createQuerySELECT(object);
        logger.info(selectQuery);
        String id = ObjectHelper.getId(object);

        PreparedStatement pstm = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;

        try {
            object = theClass.getDeclaredConstructor().newInstance();

            pstm = conn.prepareStatement(selectQuery);

            pstm.setObject(1, id);
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

        } catch (SQLException | NoSuchMethodException | IllegalAccessException
                 | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Object object) {

    }

    public void delete(Object object) {

    }
/*
    public List<Object> findAll(Class theClass) {

        String selectQuery = QueryHelper.createQuerySELECTAll(theClass);
        logger.info(selectQuery);

        PreparedStatement pstm = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        HashMap<Integer, Object> result = new HashMap<>();
        Object object = null;

        try {
            object = theClass.getDeclaredConstructor().newInstance();

            pstm = conn.prepareStatement(selectQuery);
            rs = pstm.executeQuery();

            while (rs.next()) {
                rsmd = rs.getMetaData();

                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String field = rsmd.getColumnName(i);
                    ObjectHelper.setter(object, field, rs.getObject(i));
                }
                result.put((int) rs.getObject(1), object);
                object = theClass.getDeclaredConstructor().newInstance();
            }
            return result;

        } catch (SQLException | NoSuchMethodException | IllegalAccessException
                 | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }



    public List<Object> findAll(Class theClass, HashMap params) {
        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }*/
}
