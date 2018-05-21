package com.spbstu.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

class HomeWork3Site {
    static HomePage homePage;

    static void init(WebDriver driver) {
        // вызов PageFactory необходим, чтобы аннотации FindBy подцепили необходимые элементы
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

}
