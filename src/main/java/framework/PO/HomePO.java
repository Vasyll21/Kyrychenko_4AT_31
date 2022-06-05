package framework.PO;

import framework.decorators.Button;
import framework.decorators.Input;
import framework.decorators.MyFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePO {
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div/div/div[1]/div/div[2]/div/div/div/div/div/div/div/div[3]/button[2]")
    Button hideNotifications;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div[1]/section/nav/div[2]/div/div/div[3]/div/div[1]/div/a")
    Button home;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div[1]/section/nav/div[2]/div/div/div[3]/div/div[6]/div[1]/span")
    Button account;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div[1]/section/nav/div[2]/div/div/div[3]/div/div[6]/div[2]/div[2]/div[2]/a[2]")
    Button saved;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div[1]/section/nav/div[2]/div/div/div[3]/div/div[6]/div[2]/div[2]/div[2]/a[3]")
    Button settings;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div[1]/section/nav/div[2]/div/div/div[3]/div/div[6]/div[2]/div[2]/div[2]/div[2]")
    Button logOut;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div[1]/section/nav/div[2]/div/div/div[2]/input")
    Input search;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div[1]/section/nav/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/a")
    Button profile;

    private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    @Step
    public void closeNotification(){
        hideNotifications.click();
    }

    @Step
    public boolean isOpen() {
        return home.isOnScreen();
    }

    @Step
    public SignInPO LogOut(){
        account.click();
        logOut.click();
        return new SignInPO(driver);
    }

    @Step
    public SettingsPO openSettings(){
        account.click();
        settings.click();
        return new SettingsPO(driver);
    }

    @Step
    public ProfilePO goToProfile(String profLogin){
        search.put(profLogin);
        search.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        profile.click();
        return new ProfilePO(driver);
    }

    public SavedPO goToSaved(){
        account.click();
        saved.click();
        return new SavedPO(driver);
    }

}
