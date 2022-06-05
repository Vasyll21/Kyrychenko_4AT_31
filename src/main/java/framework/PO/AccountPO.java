package framework.PO;

import framework.decorators.MyFieldDecorator;
import framework.decorators.Text;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPO {
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div[1]/section/main/div/header/section/div[2]/div")
    Text bio;

    private WebDriver driver;

    public AccountPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    public String checkBio() {
        System.out.println(bio.getText());
        return bio.getText();
    }
}
