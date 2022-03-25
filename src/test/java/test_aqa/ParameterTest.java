package test_aqa;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    /**
     * Following method takes one parameter as input. Value of the
     * said parameter is defined at suite level.
     */
    @Parameters({ "suite-param" })
    @Test
    public void prameterTestOne(String param) {
        System.out.println("Test one suite param is: " + param);
    }
    /**
     * Following method takes one parameter as input. Value of the
     * said parameter is defined at test level.
     */
    @Parameters({ "test-two-param" })
    @Test
    public void prameterTestTwo(String param) {
        System.out.println("Test two param is: " + param);
    }

}
