package framework.PO;

import framework.decorators.Button;
import framework.decorators.MyFieldDecorator;
import framework.decorators.Text;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavedPO {

    @FindBy(css = "._aabd > a:nth-child(1)")
    Button foto;

    @FindBy(css = "._aaqt > div:nth-child(1) > span:nth-child(1) > a:nth-child(1)")
    Text account;

    private WebDriver driver;

    public SavedPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    public String getSavedAccount() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        foto.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return account.getText();
    }

}
