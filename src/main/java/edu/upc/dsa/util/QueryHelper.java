package edu.upc.dsa.util;

import edu.upc.dsa.models.Ingrediente;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueryHelper {
    final static Logger logger = Logger.getLogger(QueryHelper.class);

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        Class theClass = entity.getClass();
        Method[] methods = theClass.getDeclaredMethods();
        //String[] sMethods = new String[methods.length/2];
        List<String> sMethods=new ArrayList<>();
        int i=0;
        for (Method m: methods) if(m.getName().substring(0, 3).equals("get")){sMethods.add(m.getName().substring(3));};
        Collections.sort(sMethods);

        //String [] fields = ObjectHelper.getFields(entity);

        //sb.append("ID");
        /*for (String field: fields) {
            sb.append(", ").append(field);
        }*/
        for(String s:sMethods){
            sb.append(s).append(", ");
        }
        sb=sb.replace(sb.length()-2,sb.length(),"");

        //sb.append(") VALUES (?");
        sb.append(") VALUES (");

        /*for (String field: fields) {
            sb.append(", ?");
        }*/
        for (String s:sMethods) {
            sb.append("?, ");
        }
        sb=sb.replace(sb.length()-2,sb.length(),"");

        sb.append(")");

        return sb.toString();
    }

    public static String createQuerySELECT(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE ID = ?");

        return sb.toString();
    }
    public static String createQuerySELECTsearchJugador(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE nombre = ? and password = ?");

        return sb.toString();
    }
    public static String createQuerySELECTbyTwoParameters(Class theClass, String byFirstParameter, String bySecondParameter) {

        StringBuffer sb = new StringBuffer("SELECT * FROM ");
        sb.append(theClass.getSimpleName());
        sb.append(" WHERE " + byFirstParameter + " = ?");
        sb.append(" AND " + bySecondParameter + " = ?");

        return sb.toString();
    }

    public static String createQuerySELECTAll(Ingrediente ingrediente) {

        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(ingrediente.getClass().getSimpleName());

        return sb.toString();
    }

    public static String createQuerySELECTAllByID(Ingrediente ingrediente) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(ingrediente.getClass().get());
        sb.append(" WHERE nickNameBuyer = ?");
        return sb.toString();
    }

    public static String createQueryUPDATE(Object entity) {

        StringBuffer sb = new StringBuffer("UPDATE ");
        sb.append(entity.getClass().getSimpleName()).append(" SET");

        for (String field: ObjectHelper.getFields(entity)) {
            sb.append(" " + field).append(" = ?,");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" WHERE ID = ?");

        return sb.toString();
    }


    public static String createQueryUPDATEbyParameter(Object entity, String parameter) {

        StringBuffer sb = new StringBuffer("UPDATE ");
        sb.append(entity.getClass().getSimpleName()).append(" SET");

        for (String field: ObjectHelper.getFields(entity)) {
            sb.append(" " + field).append(" = ?,");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" WHERE " + parameter + " = ?");

        return sb.toString();
    }





}
