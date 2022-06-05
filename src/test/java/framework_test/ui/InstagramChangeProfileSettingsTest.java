package framework_test.ui;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import framework.BO.InstagramBO;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task_12.BaseUITest;
import task_13.CustomSuiteListener;
import task_13.CustomTestListener;
import task_14.AllureTestListener;

@Listeners({
        CustomTestListener.class,
        CustomSuiteListener.class,
        UniversalVideoListener.class,
        AllureTestListener.class
})
public class InstagramChangeProfileSettingsTest extends BaseUITest {
    @Test()
    @Video
    void InstagramPOTest() {
        String bio = "some bio";
        InstagramBO instagramBo = new InstagramBO(driver);

        instagramBo.goToSite();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        instagramBo.signIn();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        instagramBo.closeNotifications();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        instagramBo.goToSettings();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        instagramBo.changeBioText(bio);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        instagramBo.goToAccount();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        instagramBo.checkBioChange(bio);

    }

    @Test()
    @Video
    void InstagramPOErrorTest() {
        InstagramBO instagramBo = new InstagramBO(driver);

        instagramBo.goToSite();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        instagramBo.verifyHomePageIsOpen();
    }


    @AfterTest
    void CloseDriver(){
        driver.close();
        driver.quit();
    }

}