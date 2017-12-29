package ru.my.pages.impl;

import org.openqa.selenium.WebElement;
import ru.my.pages.elements.Button;

class ButtonImpl extends AbstractElement implements Button {
    protected ButtonImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}