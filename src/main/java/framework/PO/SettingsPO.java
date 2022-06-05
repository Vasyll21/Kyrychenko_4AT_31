package framework.PO;

import framework.decorators.Button;
import framework.decorators.MyFieldDecorator;
import framework.decorators.TextArea;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPO {
    @FindBy(xpath = "/html/body/div[1]/section/main/div/article/form/div[4]/div/textarea")
    TextArea bio;

    @FindBy(xpath = "/html/body/div[1]/section/main/div/article/form/div[10]/div/div/button")
    Button submit;

    @FindBy(xpath = "/html/body/div[1]/section/nav/div[2]/div/div/div[3]/div/div[6]/div[1]/span/img")
    Button account;

    @FindBy (xpath = "/html/body/div[1]/section/nav/div[2]/div/div/div[3]/div/div[6]/div[2]/div[2]/div[2]/a[1]")
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
