package task_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    public static void main(String[] args) {
        String driverPath = "C:\\Users\\Yenot\\IdeaProjects\\Kyrychenko_4AT_31\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get("https://stackoverflow.com/questions");

        //ChromeDriverManager.getInstance().setup();
        //WebDriver webDriver = new ChromeDriver();
        //webDriver.get("https://stackoverflow.com");

        WebElement tagsText = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/nav/ol/li[2]/ol/li[3]/a/div/div"));
        System.out.println(tagsText);
        System.out.println(tagsText.getText());
        System.out.println(tagsText.getLocation());

        WebElement activeText = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/a[2]/div"));
        System.out.println(activeText);
        System.out.println(activeText.getText());
        System.out.println(activeText.getLocation());

        WebElement tags = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/nav/ol/li[2]/ol/li[4]/a/div/div"));
        System.out.println(tags);
        System.out.println(tags.getText());
        System.out.println(tags.getLocation());

        WebElement askQuestionButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/div/a"));
        System.out.println(askQuestionButton);
        System.out.println(askQuestionButton.getText());
        System.out.println(askQuestionButton.getLocation());

        askQuestionButton.click();

        driver.close();
        driver.quit();
    }
}
