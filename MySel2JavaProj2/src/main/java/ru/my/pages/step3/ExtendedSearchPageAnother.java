package ru.my.pages.step3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.my.pages.SearchPage;
import ru.my.pages.elements.LinkText;

public class ExtendedSearchPageAnother implements SearchPage {
    @FindBy(xpath = ".//a[text() = 'Компьютеры']")
    private LinkText linkText;

    @Override
    public void search(String query) {
        linkText.click();
    }

    @Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
    }
}
