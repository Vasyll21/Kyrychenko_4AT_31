package framework.PO;

import framework.decorators.MyFieldDecorator;
import framework.decorators.Text;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPO {
    @FindBy(css = "div._aacl:nth-child(3)")
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
