package framework.PO;

import framework.decorators.Button;
import framework.decorators.MyFieldDecorator;
import framework.decorators.TextArea;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPO {
    @FindBy(css = "#pepBio")
    TextArea bio;

    @FindBy(css = ".L3NKy")
    Button submit;

    @FindBy(css = "._6q-tv")
    Button account;

    @FindBy (css = "a.-qQT3:nth-child(1)")
    Button accountPage;

    private WebDriver driver;

    public SettingsPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    public void changeBio(String bioText){
        bio.clear();
        bio.put(bioText);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        submit.click();

    }

    public AccountPO goToAccount() {
        account.click();
        accountPage.click();
        return new AccountPO(driver);
    }


}
