package task_3.exeption;

public class DivByZeroException extends  Exception{
    public DivByZeroException(String message) {
        super("my custom exception:" + message);
    }
}
