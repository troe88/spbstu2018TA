package com.spbstu.hw4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenidePageFactory;
import com.spbstu.hw4.pages.DatesPage;
import com.spbstu.hw4.pages.ElementsPage;
import com.spbstu.hw4.pages.HomePage;

public class HomeWork4Site {
    static HomePage homePage;
    static ElementsPage elementsPage;
    static DatesPage datesPage;

    public static void init() {
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        datesPage = new DatesPage();
        Selenide.page(elementsPage); // отправляем сразу в PageFactory
        Selenide.page(datesPage);
    }

}
