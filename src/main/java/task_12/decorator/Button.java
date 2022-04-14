package task_12.decorator;

import org.openqa.selenium.WebElement;

public class Button extends Element{

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        System.out.println("Button click");
        webElement.click();
    }

    public boolean isOnScreen() {
        System.out.println("Check if element is displayed");
        return webElement.isDisplayed();
    }
}
