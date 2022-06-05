package framework.PO;

import framework.decorators.Button;
import framework.decorators.MyFieldDecorator;
import framework.decorators.Text;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePO {
    @FindBy(css = "h2._aacl")
    Text profileName;

    @FindBy(css = "div._ac7v:nth-child(1) > div:nth-child(1) > a:nth-child(1)")
    Button foto;

    @FindBy(css = "._aamz > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)")
    Button save;

    @FindBy(css = "div.oajrlxb2")
    Button close;

    private WebDriver driver;

    public ProfilePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    public String getProfileName(){
        return profileName.getText();
    }

    public void saveFoto(){
        foto.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        save.click();
        close.click();
    }

    public HomePO goHome(){
        driver.get("https://www.instagram.com/");
        return new HomePO(driver);
    }
}
