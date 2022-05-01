package test_aqa.ui.task_13;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task_12.BaseUITest;
import task_12.InstagramFactoryBO;
import task_13.CustomSuiteListener;
import task_13.CustomTestListener;

@Listeners({
        CustomTestListener.class,
        CustomSuiteListener.class,
        UniversalVideoListener.class
})
public class InstagramTask13Test extends BaseUITest{

    @Test()
    @Video
    void InstagramPOTest() {
        InstagramFactoryBO instagramBo = new InstagramFactoryBO(driver);

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

        instagramBo.verifyHomePageIsOpen();
    }


    @AfterTest
    void CloseDriver(){
        driver.close();
        driver.quit();
    }
}
