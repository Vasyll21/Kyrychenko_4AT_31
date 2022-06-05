package framework.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;

public class BrowserFactory {

    private static final ThreadLocal<WebDriver> INSTANCE = new InheritableThreadLocal<>();
    public static WebDriver getChromedriver() {
        if(null == INSTANCE.get()) {
            System.setProperty("webdriver.chrome.driver", "driver"+ File.separator + "chromedriver.exe");
            //ChromeDriverManager.getInstance().setup();
            INSTANCE.set(new ChromeDriver());
        }
        return INSTANCE.get();
    }

    public static WebDriver getOperadriver() {
        if(null == INSTANCE.get()) {
            System.setProperty("webdriver.opera.driver", "driver"+ File.separator + "operadriver.exe");
            //ChromeDriverManager.getInstance().setup();
            INSTANCE.set(new OperaDriver());
        }
        return INSTANCE.get();
    }
}
