package task_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePO {
    private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOpen() {
        return driver
                .findElement(By.xpath("/html/body/div[1]/section/nav/div[2]/div/div/div[3]/div/div[1]/div/a"))
                .isDisplayed();
    }
}
