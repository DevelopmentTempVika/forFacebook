package ru.temp9;


import ru.temp9.pages.AbstractPage;

/**
 * Класс управления браузерным окном
 */
public class BrowserManagement extends AbstractPage {
    /**
     * Разворачивает браузер на все окно
     * @return этот объект
     */
    public BrowserManagement windowMaximize(){
        driver.manage().window().maximize();
        return this;
    }
}