package task_5.streams;

import task_4.generic.PersonComparatorByField2;
import task_4.reflection.MyClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApp {
    public static void main(String[] args) {

        System.out.println(Arrays.asList(args));
        List<MyClass> list = new ArrayList<>(Arrays.asList(
                new MyClass("some1", 123),
                new MyClass("etg", 28),
                new MyClass("fgjm", 321),
                new MyClass("fhu76", 2)
        ));

        System.out.println(list);
        List<String> sortedList = list.stream().sorted(new PersonComparatorByField2()).map(MyClass::getField1).collect(Collectors.toList());
        System.out.println(sortedList);

        List<String> list1 = list.stream().sorted(new Comparator<MyClass>() {
            @Override
            public int compare(MyClass o1, MyClass o2) {
                return o1.getField1().compareTo(o2.getField1());
            }
        }).map(MyClass::getField1).collect(Collectors.toList());
        System.out.println(list1);
    }
}
