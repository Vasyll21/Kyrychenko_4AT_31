package framework.PO;

import framework.decorators.Button;
import framework.decorators.MyFieldDecorator;
import framework.decorators.Text;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePO {
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div[1]/section/main/div/header/section/div[1]/h2")
    Text profileName;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div[1]/section/main/div/div[3]/article/div[1]/div/div[1]/div[1]/a")
    Button foto;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div/div/div[1]/div/div[3]/div/div/div/div/div[2]/div/article/div/div[2]/div/div/div[2]/section[1]/span[4]/div/div/button")
    Button save;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div/div/div[1]/div/div[2]/div")
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
