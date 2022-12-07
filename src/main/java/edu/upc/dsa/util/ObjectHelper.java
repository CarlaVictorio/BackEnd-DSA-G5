package edu.upc.dsa.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectHelper {
    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();

        //theClass.getDeclaredMethod("getNombreJugador", null)

        String[] sFields = new String[fields.length];
        int i=0;

        for (Field f: fields) sFields[i++]=f.getName();

        return sFields;

    }


    public static void setter(Object object, String property, Object value)  {
        Class theClass = object.getClass();
        Field[] fields = theClass.getDeclaredFields();
        Method[] methods = theClass.getDeclaredMethods();
        String[] sFields = new String[fields.length];
        //theClass.getDeclaredMethod("setNombreJugador",String.class)

        try{
            for (Field f: fields) {
                if (f.getName().equals(property)){
                    f.set(object, value);
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Object getter(Object object, String property)  {
        Object value = null;
        Class theClass = object.getClass();
        Field[] fields = theClass.getDeclaredFields();
        Method[] methods = theClass.getDeclaredMethods();


        String[] sFields = new String[fields.length];

        for (Method m: methods) {
            if (m.getName().equals("get"+property.substring(0,1).toUpperCase()+property.substring(1))){
                System.out.println("Trobat "+m.getName());
                try {
                    Object res = m.invoke(object, null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(m.getName());
        }

        try {
            for (Field f: fields) {
                if (f.getName().equals(property))
                    value = f.get(object);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return value;
    }


    public static String getId(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();

        String id = new String();

        try {
            id = String.valueOf(fields[0].getInt(entity));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return id;
    }
}
