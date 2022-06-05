package task_12;

import framework.factory.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class BaseUITest {
    protected WebDriver driver = BrowserFactory.getChromedriver();
}
