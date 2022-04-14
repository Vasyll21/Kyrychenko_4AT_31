package test_aqa.ui.task_12_factory;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import task_12.BaseUITest;
import task_12.InstagramFactoryBO;

public class InstagramFactoryPOTest extends BaseUITest {

    @Test()
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
