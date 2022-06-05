package framework.PO;

import framework.decorators.Button;
import framework.decorators.Input;
import framework.decorators.MyFieldDecorator;
import framework.decorators.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPO {
    @FindBy(xpath ="/html/body/div[1]/section/main/article/div[2]/div[3]/p")
    Text text;

    @FindBy(xpath = "/html/body/div[1]/section/main/article/div[2]/div[1]/div[2]/form/div/div[1]/div/label/input")
    Input loginArea;

    @FindBy(xpath = "/html/body/div[1]/section/main/article/div[2]/div[1]/div[2]/form/div/div[2]/div/label/input")
    Input passwordArea;

    @FindBy(xpath = "/html/body/div[1]/section/main/article/div[2]/div[1]/div[2]/form/div/div[3]/button")
    Button signInButton;

    private WebDriver driver;

    public SignInPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    @Step
    public void goToSite() {
        driver.get("https://www.instagram.com/");
    }

    @Step
    public HomePO clickSignIn() {
        this.insertLogin();
        this.insertPassword();
        signInButton.click();
        return new HomePO(driver);
    }

    @Step
    public void insertLogin() {
        loginArea.put("yenot.programer@gmail.com");
    }

    @Step
    public void insertPassword() {
        passwordArea.put("mp3np4lk78");
    }

    @Step
    public boolean isOpen() {
        return text.isOnScreen();
    }
}
