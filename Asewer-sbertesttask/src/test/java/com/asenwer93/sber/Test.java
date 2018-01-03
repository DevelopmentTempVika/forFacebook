package com.asenwer93.sber;

import com.asenwer93.sber.helpers.DriverManager;
import com.asenwer93.sber.pages.market.YandexMarketPage;
import com.asenwer93.sber.pages.YandexSearchPage;
import com.asenwer93.sber.pages.market.YandexMarketTabletsPage;
import org.testng.annotations.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static org.hamcrest.CoreMatchers.is;


public class Test {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private BrowserManagement browserManagement;
    private YandexSearchPage yandexSearchPage;
    private YandexMarketPage yandexMarketPage;
    private YandexMarketTabletsPage yandexMarketTabletsPage = new YandexMarketTabletsPage();

    @Rule
    public ErrorCollector collector = new ErrorCollector();


    @BeforeClass
    public static void setUp(){
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, 10);

    }

    @AfterClass
    public static void tearDown() {
        DriverManager.getDriver().quit();
    }

    @Title("Поиск по параметрам")
    @Description("Ввод параметров поиска и проверка количества элементов на странице")
    @org.junit.Test
    public void test1(){
        browserManagement = new BrowserManagement();
        browserManagement.windowMaximize();

        yandexSearchPage = new YandexSearchPage();
        yandexSearchPage.load();
        yandexSearchPage.goToMarket();

        yandexMarketPage = new YandexMarketPage();
        yandexMarketPage.goToCategory("Компьютеры").goToTheSubcategory("Планшеты");


        yandexMarketTabletsPage.goToAllFilters().setPrice(20000, 25000)
                .showAllCompany()
                .setCompany("DELL")
                .setCompany("Acer")
                .submitFilters();
        // проверка на количество элементов
        collector.checkThat(yandexMarketTabletsPage.amountOfElements(), is(10));
    }

    @Title("Поиск по имени")
    @Description("Ввод названия первого найденного элемента в поисковую строку и проверка названия на соответствие" +
            " с первым элементом после поиска")
    @org.junit.Test
    public void test2(){
        String expected = yandexMarketTabletsPage.getNameElement(0);
        yandexMarketTabletsPage.search(expected);
        String actual = yandexMarketTabletsPage.getNameElement(0);

        collector.checkThat(expected, is(actual));
    }
}
