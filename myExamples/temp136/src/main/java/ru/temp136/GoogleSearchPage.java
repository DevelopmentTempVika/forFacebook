package ru.temp136;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GoogleSearchPage {
    @Step
    public GoogleResultsPage search(String query) {
        $(By.name("q")).setValue(query).pressEnter();
        return page(GoogleResultsPage.class);
    }
}
