package framework.BO;

import framework.PO.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InstagramBO {
    private WebDriver driver;

    HomePO homePO;
    SignInPO signInPO;
    SettingsPO settingsPO;
    AccountPO accountPO;
    ProfilePO profilePO;
    SavedPO savedPO;

    public InstagramBO(WebDriver driver) {
        this.driver = driver;
    }

    public void goToSite() {
        signInPO = new SignInPO(this.driver);
        signInPO.goToSite();
    }

    public void signIn() {
        homePO = signInPO.clickSignIn();
    }

    public void closeNotifications(){
        homePO.closeNotification();
    }

    public void verifyHomePageIsOpen() {
        Assert.assertTrue(homePO.isOpen());
    }

    public void goToSettings() {
        settingsPO = homePO.openSettings();
    }

    public void changeBioText(String bio) {
        settingsPO.changeBio(bio);
    }

    public void goToAccount() {
        accountPO = settingsPO.goToAccount();
    }

    public void checkBioChange(String bio) {
        Assert.assertEquals(accountPO.checkBio(), bio);
    }

    public void goToProfile(String profileName) {profilePO = homePO.goToProfile(profileName);}

    public void checkProfile(String profile) {Assert.assertEquals(profilePO.getProfileName(), profile);}

    public void saveFoto() {profilePO.saveFoto();}

    public void goHome() {homePO = profilePO.goHome();}

    public void goToSaved() {savedPO = homePO.goToSaved();}

    public void checkFotoContaints(String profile) {Assert.assertEquals(savedPO.getSavedAccount(), profile);}

    public void  logOut(){
        signInPO = homePO.LogOut();
    }

    public void verifySignInPageIsOpen(){
        Assert.assertTrue(signInPO.isOpen());
    }


}
