package ru.temp136;

import com.codeborne.selenide.ElementsCollection;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$$;

public class GoogleResultsPage {
    @Step
    public ElementsCollection results() {
        //return $$("#ires li.g");
        return $$("#ires .g");
    }
}
