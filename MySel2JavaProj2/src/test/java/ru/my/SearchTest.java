package ru.my;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.my.pages.SearchPage;
import ru.my.pages.YandexPage;
import ru.my.pages.step3.ExtendedSearchPage;
import ru.my.pages.step3.ExtendedSearchPageAnother;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class SearchTest {

    private WebDriver driver;

    @Title("Поиск по параметрам")
    @Description("Ввод параметров поиска и проверка количества элементов на странице")
    @Test(dataProvider = "pageObjects")
    public void testSearch(final SearchPage searchPage){
        searchPage.init(driver);
        driver.get("https://yandex.ru/");
        searchPage.search("Маркет");
        /**
         * Пока метод search не универсален
         * поэтому ищется только Маркет
         */
        //searchPage.search("Авто.ру");
        //searchPage.search("Телепрограмма");
    }

    @DataProvider
    private Object[][] pageObjects() {
        return new Object[][]{
                {new YandexPage()}/*,
                {new ExtendedSearchPageAnother()},
                {new ExtendedSearchPage()},
                {new SearchPageWithSearchForm()}*/
        };
    }

    @BeforeClass
    public void beforeClass() {
        //System.setProperty("webdriver.gecko.driver","./src/resources/drivers/firefox/geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:\\SourceCode\\Java\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","./src/test/drivers/chrome/chromedriver.exe");
        //driver = new ChromeDriver();
    }

    //Закрыть браузер
    /*
    @AfterClass
    public void afterClass() {
        driver.quit();
    }*/
}
