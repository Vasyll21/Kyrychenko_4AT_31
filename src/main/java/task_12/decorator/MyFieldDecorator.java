package task_12.decorator;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;

public class MyFieldDecorator extends DefaultFieldDecorator {
    public MyFieldDecorator(SearchContext context) {
        super(new DefaultElementLocatorFactory(context));
    }

    public Object decorate(ClassLoader loader, Field field) {
        Class<?> decoratableClass = decoratableClass(field);

        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }
            return createElement(loader, locator, decoratableClass);
        }
        return super.decorate(loader, field);
    }

    protected <T> T createElement(ClassLoader loader, ElementLocator locator, Class<T> tClass) {
        WebElement proxy = proxyForLocator(loader, locator);
        return createInstance(tClass, proxy);
    }

    private <T> T createInstance(Class<T> tClass, WebElement element) {
        try {
            return tClass.getConstructor(WebElement.class).newInstance(element);
        } catch (Exception e) {
            throw new AssertionError(
                    "Web element can't be represent as " + tClass
            );
        }
    }

    private Class<?> decoratableClass(Field field) {
        Class<?> tClass = field.getType();

        try {
            tClass.getConstructor(WebElement.class);
        } catch (Exception e) {
            return null;
        }

        return tClass;
    }
}
