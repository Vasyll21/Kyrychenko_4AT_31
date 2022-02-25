package task_2;

import task_3.exeption.DivByZeroException;

public class Calculator {

    public static void main(String[] args) {
        //Task 1. Implement a simple calculator with 4 operations.
        //Each operation - different method.
        //Use it in the main method.


        double a = -2.66;
        double b = 10;

        System.out.println("a + b = " + add(a,b));
        System.out.println("a - b = " + sub(a,b));
        System.out.println("a * b = " + mul(a,b));
        System.out.println("a / b = " + div(a,b));
    }

    public static double div(double a, double b) {
        if(b == 0) try{
            throw new DivByZeroException("invalid dividor " + b);
        }catch (DivByZeroException e) {
            e.printStackTrace();
        }
        return a / b;
    }

    private static double mul(double a, double b) {
        return a * b;
    }

    private static double sub(double a, double b) {
        return a - b;
    }

    private static double add(double a, double b) {
        return a + b;
    }
}
