package ru.my.pages.impl;

import org.openqa.selenium.WebElement;
import ru.my.pages.elements.Element;
import ru.my.pages.elements.LinkText;

public class LinkTextImpl extends AbstractElement implements LinkText {
    protected LinkTextImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        wrappedElement.click();
    }

    @Override
    public void type(final String text) {
        wrappedElement.sendKeys(text);
    }
}
