package ru.temp136;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Attachment;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

/**
 * Даннымй класс показывает пример организации работы с PageObject(вариант 1 - PageObject в стиле Selenide)
 * источник 1: http://ru.selenide.org/documentation/page-objects
 * источник 2: https://github.com/selenide-examples/selenide-allure-junit/blob/master/pom.xml
 *
 * В мире тестирования очень популярен шаблон Page Objects.
 * Суть его в том, что для каждой страницы тестируемого приложения создаётся отдельный объект,
 * методы которого инкапсулируют логику работы с отдельными элементами.
 * Считается, что Page Object позволяет избежать дублирования локаторов в тестах.
 * А Selenide позволяет писать более короткие и читаемые Page Objects.
 *
 * Никаких PageFactory, никаких initElements и прочего мусора. Ваш Page Object содержит только вашу логику.

 Вот как выглядит Page Object с Selenide.
 */
public class WithPageObjectGoogleSearchTest {

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\SourceCode\\Java\\Selenium\\chrome\\chromedriver.exe");
        com.codeborne.selenide.Configuration.browser = "chrome";
        //Разв ернуть страницу браузера
        com.codeborne.selenide.Configuration.startMaximized = true;
    }

    /**
     * Для запуска тест -имя метода должно заканчиваться на test
     */
    @DisplayName("Search for the word 'selenide'")
    @Test
    public void exampleTest(){
        //GoogleSearchPage searchPage = open("/login", GoogleSearchPage.class);
        GoogleSearchPage searchPage = open("http://google.com", GoogleSearchPage.class);
        GoogleResultsPage resultsPage = searchPage.search("selenide");
        //resultsPage.results().shouldHave(size(10));
        /**
         * Проверяем, что среди найденных элментов есть элмент, у которого адрес: selenide.org
         */
        resultsPage.results().get(0).shouldHave(text("selenide.org"));
    }
}