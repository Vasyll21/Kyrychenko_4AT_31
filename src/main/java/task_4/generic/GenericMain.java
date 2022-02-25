package task_4.generic;

import task_4.reflection.MyClass;

import java.util.*;

public class GenericMain {
    public static void main(String[] args) {
        //Make two different comparators for your Custom class
        // (simple java class with few fields).
        // End users should be able to use ‘min’, ‘max’, ‘sotr’ methods
        // with that comparators.

        List<MyClass> list = new ArrayList<>(Arrays.asList(
                new MyClass("some1", 123),
                new MyClass("etg", 28),
                new MyClass("fgjm", 321),
                new MyClass("fhu76", 2)
        ));
        System.out.println(list);
        System.out.println(max(list, new PersonComparatorByField2()));
        System.out.println(min(list, new PersonComparatorByField2()));
        sort(list, new PersonComparatorByField2());
        System.out.println(list);
    }

    private static void sort(List<MyClass> list, PersonComparatorByField2 personComparatorByField2) {
        Collections.sort(list, personComparatorByField2);
    }

    private static MyClass min(List<MyClass> list, PersonComparatorByField2 personComparatorByField2) {
        return Collections.min(list, personComparatorByField2);
    }

    private static MyClass max(List<MyClass> list, Comparator personComparatorByField2) {
        return Collections.max(list, personComparatorByField2);
    }
}
