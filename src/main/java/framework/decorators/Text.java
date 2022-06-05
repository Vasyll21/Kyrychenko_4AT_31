package framework.decorators;

import framework.decorators.Element;
import org.openqa.selenium.WebElement;

public class Text extends Element {

    public Text(WebElement webElement){
        super(webElement);
    }

    public boolean isOnScreen() {
        System.out.println("Check if element is displayed");
        return webElement.isDisplayed();
    }

    public String getText() {
        return webElement.getText();
    }

}
