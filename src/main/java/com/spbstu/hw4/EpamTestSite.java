package com.spbstu.hw4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenidePageFactory;
import com.spbstu.hw4.pages.ElementsPage;
import com.spbstu.hw4.pages.HomePage;

public class EpamTestSite {
    public static HomePage homePage;
    public static ElementsPage elementsPage;

    public static void init() {
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        Selenide.page(elementsPage); // отправляем сразу в PageFactory
    }

}
