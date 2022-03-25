package test_aqa.unit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import task_2.Calculator;

import java.util.Optional;


public class CalculatorTest {
    @DataProvider
    public static Object[][] addingDataProvider() {
        Object[][] res = new Object[4][3];

        res[0][0] = 1.0;  res[0][1] = 2.0;  res[0][2] = 3.0;
        res[1][0] = 4.0;  res[1][1] = 3.0;  res[1][2] = 7.0;
        res[2][0] = 4.0;  res[2][1] = -4.0;  res[2][2] = 0.0;
        res[3][0] = 1.0;  res[3][1] = 2.0;  res[3][2] = 4.0;

        return res;
    }

    @Test
    void divideTest(){
        Assert.assertEquals(Calculator.div(1, 1), 1d, "invalid dividing operation");
    }

    @Test(dataProvider = "addingDataProvider")
    void addTest(Double a, Double b, Double expectedResult){
        Assert.assertEquals(Calculator.add(a,b), expectedResult, "invalid adding operation");
    }

    @Test
    void mulTest(){
        Assert.assertEquals(Calculator.mul(1, 1), 1d, "invalid multiplying operation");
    }

    @Test
    void subTest(){
        Assert.assertEquals(Calculator.sub(1, 1), 0d, "invalid subtracting operation");
    }
}
