package task_12.decorator;

import org.openqa.selenium.WebElement;

public class Input extends Element{

    public Input(WebElement webElement) {
        super(webElement);
    }

    public void put(String str){
        System.out.println("Try to put " + str + " to input");
        webElement.sendKeys(str);
    }
}
