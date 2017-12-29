package ru.my.pages.step3;

import org.openqa.selenium.WebElement;
import ru.my.pages.elements.Element;

public interface ElementFactory {
    <E extends Element> E create(Class<E> elementClass, WebElement wrappedElement);
}
