package ru.my.pages.step3;

import org.openqa.selenium.WebElement;
import ru.my.pages.elements.Element;

public interface Container extends Element {
    void init(WebElement wrappedElement);
}
