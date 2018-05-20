package com.spbstu.hw8;

import com.codeborne.selenide.Selenide;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.spbstu.selenide.BaseSelenideTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.spbstu.hw8.JDIWebSite.login;
import static com.spbstu.hw8.JDIWebSite.homePage;

public class TestCase extends BaseJDITest {

    @Test
    public void loginExample() {
        homePage.open();
        login();
        homePage.checkOpened();
    }
}
