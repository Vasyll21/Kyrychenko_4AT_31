package task_3;

import java.util.Arrays;

public class MainArray {

    public static void main(String[] args) {
        //1) Find max number in array: 5, 9, 3, 2, 0, -4, -8.3, 3, -4
        double[] array_1 = {5, 9, 3, 2, 0, -4, -8.3, 3, -4};
        double max = array_1[0];

        for(double e: array_1) {
            if(e > max){
                max = e;
            }
        }

        System.out.println("Task 1");
        System.out.println("max = " + max);
        System.out.println();

        //2) Given array: {1, 6, 3, 3, 4, 5, 5, 6, 0}. Print array with only unique values, which are sorted.

        int[] array_2 = {1, 6, 3, 3, 4, 5, 5, 6, 0};
        int[] result_2 = new int[array_2.length];
        int i2 = 0;

        for(int e:array_2) {
            if(!contains(result_2, e)) {
                result_2[i2++] = e;
            }
        }

        System.out.println("Task 2");
        Arrays.sort(result_2);
        for(int i = 0; i < result_2.length; i++ ) {
            if(i != (result_2.length - 1)) {
                if (result_2[i] != result_2[i + 1]) {
                    System.out.print(result_2[i] + "\t");
                }
            } else {
                System.out.print(result_2[i]);
            }
        }
        System.out.println();
        System.out.println();

        //Given an array, e.g. "12", "23", "34", "12", "56", "67“. Replace all values “12” to “replaced”
        String[] array_3 = {"12", "23", "34", "12", "56", "67"};
        for(int i3 = 0; i3 < array_3.length; i3++){
            if(array_3[i3].equals("12")) {
                array_3[i3] = "replaced";
            }
        }

        System.out.println("Task 3");
        Arrays.stream(array_3).forEach(System.out::println);
        System.out.println();

        //Print any array in reverse mode (from the end)
        String[] array_4 = {"12", "23", "34", "12", "56", "67"};
        String[] res_4 = new String[array_4.length];

        for(int i4 = 0; i4 < array_4.length; i4++) {
            res_4[(res_4.length - i4) - 1] = array_4[i4];
        }

        System.out.println("Task 4");
        Arrays.stream(res_4).forEach(System.out::println);
    }

    private static boolean contains(int[] array, int test_element) {
        for(int e:array){
            if(test_element == e) {
                return true;
            }
        }
        return false;
    }

}
