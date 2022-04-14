package test_aqa.ui.steckoverflow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import task_12.BaseUITest;

public class StackOverflowTest extends BaseUITest {

    @Test
    void stackOverflowTest() {

        driver.get("https://stackoverflow.com/questions");

        WebElement tagsText = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/nav/ol/li[2]/ol/li[3]/a/div/div"));

        WebElement activeText = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/a[2]/div"));

        WebElement tags = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/nav/ol/li[2]/ol/li[4]/a/div/div"));

        WebElement askQuestionButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/div/a"));

        Assert.assertTrue(tagsText.isDisplayed());
        Assert.assertTrue(activeText.isDisplayed());
        Assert.assertTrue(tags.isDisplayed());
        Assert.assertTrue(askQuestionButton.isDisplayed());

        Assert.assertEquals(tagsText.getText(), "Tags");
        Assert.assertEquals(activeText.getText(), "Active");
        Assert.assertEquals(tags.getText(), "Users");
        Assert.assertEquals(askQuestionButton.getText(), "Ask Question");
    }


    @AfterTest
    void CloseDriver(){
        driver.close();
        driver.quit();
    }
}
