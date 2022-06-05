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

    @FindBy(css = "._acrd > a:nth-child(1)")
    Button home;

    @FindBy(css = "span._aa8i")
    Button account;

    @FindBy(css = "a._abm4:nth-child(2)")
    Button saved;

    @FindBy(css = "a.oajrlxb2:nth-child(3)")
    Button settings;

    @FindBy(css = "div._abm4:nth-child(6)")
    Button logOut;

    @FindBy(css = "._aawh")
    Input search;

    @FindBy(css = "a._abm4:nth-child(1)")
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
