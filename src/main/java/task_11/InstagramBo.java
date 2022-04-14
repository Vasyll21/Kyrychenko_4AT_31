package task_11;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InstagramBo {
    private WebDriver driver;

    HomePO homePO;
    SignInPO signInPO;

    public InstagramBo(WebDriver driver) {
        this.driver = driver;
    }

    public void goToSite() {
        signInPO = new SignInPO(this.driver);
        signInPO.goToSite();
    }

    public void signIn() {
        homePO = signInPO.clickSignIn();
    }

    public void verifyHomePageIsOpen() {
        Assert.assertTrue(homePO.isOpen());
    }

}
