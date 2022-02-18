package task_3;

import java.util.*;

public class CollectionPerformance {

    public static void main(String[] args) {
        //4) Check performance for some List operations (get(i), insertAfter(i), ..)
        // for different collection implementations.
        List<String> arrayList = new ArrayList<>(Arrays.asList(("We need a measure to summarize the variability " +
                "of these two distributions. The summary metrics we've learned " +
                "so far don't tell us anything about variability. The mean, the " +
                "median, and the mode of distribution").split(" ")));
        List<String> linkedList = new LinkedList<>(arrayList);

        arrayList = generateAdditional(arrayList);
        linkedList = generateAdditional(linkedList);

        //System.out.println(arrayList);
        //System.out.println(linkedList);

        System.out.println("Get performance:");
        System.out.println("arrayList:" + checkGet(arrayList));
        System.out.println("linkedList:" + checkGet(linkedList));

        System.out.println("Insert performance:");
        System.out.println("arrayList:" + checkInsert(arrayList));
        System.out.println("linkedList:" + checkInsert(linkedList));

        //System.out.println(checkInsert(arrayList));
    }

    private static long checkInsert(List<String> list) {
        long start = new Date().getTime();
        int size = list.size();

        for(int i = 0; i < 1000; i++) {
            int randIndex = new Random().nextInt(size);
            list.set(randIndex, "WAAAGH");
        }

        return new Date().getTime() - start;
    }

    private static List<String> generateAdditional(List<String> list) {
        for(int i = 0; i < 10; i++){
            list.addAll(list);
        }
        return list;
    }

    private static long checkGet(List<String> arrayList) {
        long start = new Date().getTime();
        int size = arrayList.size();

        for(int i = 0; i < 1000; i++) {
            int randIndex = new Random().nextInt(size);
            int wSize = arrayList.get(randIndex).length();
        }

        return new Date().getTime() - start;
    }
}
