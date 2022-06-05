package framework.decorators;

import org.openqa.selenium.WebElement;

public class Input extends Element {

    public Input(WebElement webElement) {
        super(webElement);
    }

    public void put(String str){
        System.out.println("Try to put " + str + " to input");
        webElement.sendKeys(str);
    }

    public void clear(){
        System.out.println("Try to clear input");
        webElement.clear();
    }

    public void submit(){
        webElement.submit();
    }

    public void click(){
        webElement.click();
    }
}
