package task_4.reflection;

import java.lang.reflect.Field;

public class ReflectionMain {
    public static void main(String[] args) {
        //Write a method which can work with any object using reflection.
        // End user should be able use it like this:
        //get(object,”fieldName”) - return value of field
        //        put(object,”fieldName”,value) - put the value to field
        //        clear(object,”fieldName”) - put null or 0 to the field.
        //Methods should throw exceptions with explanations if something is wrong.

        MyClass myClass = new MyClass("some", 1234);

        System.out.println(get(myClass, "field1"));
        System.out.println(set(myClass, "field1", "another"));
        System.out.println(clear(myClass, "field1"));
    }

    private static Object clear(Object object, String fieldName) {
        Class thisClass = object.getClass();
        try {
            Field f = thisClass.getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(object, "");
            return f.get(object);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object set(Object object, String fieldName, String text) {
        Class thisClass = object.getClass();
        try {
            Field f = thisClass.getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(object, text);
            return f.get(object);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object get(Object object, String fieldName) {
        Class thisClass = object.getClass();
        try {
            Field f = thisClass.getDeclaredField(fieldName);
            f.setAccessible(true);
            return f.get(object);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
