package framework.decorators;

import org.openqa.selenium.WebElement;

public class TextArea extends Element{
    public TextArea(WebElement webElement) {
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
}
