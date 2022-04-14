package task_12.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task_12.BaseUITest;
import task_12.decorator.Button;
import task_12.decorator.MyFieldDecorator;

public class HomeFactoryPO {
    @FindBy(xpath = "/html/body/div[1]/section/nav/div[2]/div/div/div[3]/div/div[1]/div/a")
    Button home;

    private WebDriver driver;

    public HomeFactoryPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    public boolean isOpen() {
        return home.isOnScreen();
    }
}
