package com.spbstu.hw4;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelenideTest extends BaseSelenideTest {
    @BeforeTest
    public void beforeTest() {
        EpamTestSite.init();
    }

    @Test
    public void test() {
        EpamTestSite.homePage.open();
        EpamTestSite.homePage.login("epam", "1234");
        EpamTestSite.homePage.checkUserLogIn("PITER CHAILOVSKII");
        EpamTestSite.homePage.checkInterface();
        EpamTestSite.homePage.openSubmenu();
        EpamTestSite.homePage.openElementsPage();
        Selenide.Wait();
    }
}
