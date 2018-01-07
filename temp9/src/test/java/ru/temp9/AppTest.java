package ru.temp9;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.AfterClass;
import org.junit.Assert;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.temp9.helpers.DriverManager;
import ru.temp9.pages.YandexSearchPage;
import ru.temp9.pages.market.YandexMarketPage;
import ru.temp9.pages.market.YandexMarketTabletsPage;
import ru.yandex.qatools.allure.annotations.Title;
//import static org.hamcrest.CoreMatchers.is;

public class AppTest extends TestCase {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private BrowserManagement browserManagement;
    private YandexSearchPage yandexSearchPage;
    private YandexMarketPage yandexMarketPage;
    private YandexMarketTabletsPage yandexMarketTabletsPage = new YandexMarketTabletsPage();

    public AppTest( String testName ){
        super( testName );
    }

    public static Test suite(){
        return new TestSuite( AppTest.class );
    }

    public void testApp(){
        assertTrue( true );
    }

    //Тоже работает.Неа:тесты не видит
    /*@BeforeClass
    public void setUp(){
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, 10);

    }

    @AfterClass
    public void tearDown() {
        DriverManager.getDriver().quit();
    }*/

    @Title("Поиск по параметрам")
    @Description("Ввод параметров поиска и проверка количества элементов на странице")
    @org.junit.Test
    public void test1() {
        //String message = new AppBean("Maven 2").sayHello();
        //Assert.assertEquals("Test Hello Machine", "Hello, Maven 2", message);

        browserManagement = new BrowserManagement();
        browserManagement.windowMaximize();

        yandexSearchPage = new YandexSearchPage();
        yandexSearchPage.load();
        yandexSearchPage.goToMarket();

        yandexMarketPage = new YandexMarketPage();
        yandexMarketPage.goToCategory("Компьютеры").goToTheSubcategory("Ноутбуки");


        yandexMarketTabletsPage.goToAllFilters().setPrice(20000, 25000)
                .showAllCompany()
                .setCompany("DELL")
                .setCompany("Acer")
                .submitFilters();
        // проверка на количество элементов
        //collector.checkThat(yandexMarketTabletsPage.amountOfElements(), is(10));
    }


}