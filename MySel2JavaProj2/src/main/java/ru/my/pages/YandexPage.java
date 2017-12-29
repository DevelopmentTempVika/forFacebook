package ru.my.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.my.pages.elements.Element;
import ru.my.pages.elements.TextField;

import java.util.List;

public class YandexPage implements SearchPage {
    //Здесь определены элементы главной страницы Яндекс, а именно: Видео,Картинки,Новости,Карты,Маркет,Переводчик,Музыка,еще
    @FindBy(xpath = "//*[contains(@class, 'home-tabs__search')]")
    private List<WebElement> homeTabs;

    //Список элементов "Посещаемое"
    @FindBy(xpath = "//*[contains(@class,'link_black__yes')]")
    private List<WebElement> visited;

    //Телепрограмма
    @FindBy(xpath = "//*[contains(@class,'home_link_blue_yes')]")
    private WebElement teleprogramma;

    @Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    public void search(final String query) {
        //Среди элементов на главной странице Яндекс, определенных с помощью homeTabs находим элменет Маркет
        for (WebElement element : homeTabs){
            if (element.getText().equals(query)) {
                element.click();
                break;
            }
        }
        //return this;
    }

    /*@Override
    public void searchHomeTabs(final String query) {
        //Среди элементов на главной странице Яндекс, определенных с помощью homeTabs находим элменет Маркет
        for (WebElement element : visited){
            if (element.getText().equals(query)) {
                element.click();
                break;
            }
        }
        //return this;
    }*/
}
