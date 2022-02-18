package task_3.exeption;

import task_2.Calculator;

public class MainException {
    //1) Make your own Exception implementation. Use it in your CalcApp
    public static void main(String[] args) {
        System.out.println(Calculator.div(10, 0));
    }
}
