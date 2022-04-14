package test_aqa.ui.instagram_po;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import task_11.InstagramBo;
import task_12.BaseUITest;

public class InstagramPOTest extends BaseUITest {

    @Test()
    void InstagramPOTest() {
        InstagramBo instagramBo = new InstagramBo(driver);

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
