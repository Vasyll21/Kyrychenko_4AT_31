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
    @FindBy(css =".b_nGN")
    Text text;

    @FindBy(css = "div.-MzZI:nth-child(1) > div:nth-child(1) > label:nth-child(1) > input:nth-child(2)")
    Input loginArea;

    @FindBy(css = "div.-MzZI:nth-child(2) > div:nth-child(1) > label:nth-child(1) > input:nth-child(2)")
    Input passwordArea;

    @FindBy(css = ".L3NKy")
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
