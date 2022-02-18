package task_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        //3) Given: String with big text (more than 1000 words).
        // Write a method that calculates the numbers of words for each letter that starts the word.
        String inputString = "We need a measure to summarize the variability " +
                "of these two distributions. The summary metrics we've learned " +
                "so far don't tell us anything about variability. The mean, the " +
                "median, and the mode of distribution";
        Map<String, Integer> result = new HashMap<>();
        Arrays.stream(inputString.split(" ")).forEach(w -> {
            String key = String.valueOf(w.charAt(0));
            result.putIfAbsent(key, 0);
            result.put(key, result.get(key) + 1);
        });

        System.out.println("Task 3");
        System.out.println(result);
    }
}
