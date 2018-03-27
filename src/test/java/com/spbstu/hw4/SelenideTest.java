package com.spbstu.hw4;

import com.codeborne.selenide.Selenide;
import com.spbstu.hw4.utils.Color;
import com.spbstu.hw4.utils.Element;
import com.spbstu.hw4.utils.Metal;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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

        List<String> items = Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements");
        EpamTestSite.homePage.openHeaderSubmenu();
        EpamTestSite.homePage.checkHeaderSubmenu(items);
        EpamTestSite.homePage.openSidebarSubmenu();
        EpamTestSite.homePage.checkSidebarSubmenu(items);
        EpamTestSite.homePage.openElementsPage();

        //EpamTestSite.elementsPage.open();
        EpamTestSite.elementsPage.checkPage();
        EpamTestSite.elementsPage.selectElement(Element.WATER, true);
        EpamTestSite.elementsPage.selectElement(Element.WIND, true);
        EpamTestSite.elementsPage.selectMetal(Metal.SELEN);
        EpamTestSite.elementsPage.selectColor(Color.YELLOW);
        //Check in logs section selected values and status (true|false)
        EpamTestSite.elementsPage.selectElement(Element.WATER, false);
        EpamTestSite.elementsPage.selectElement(Element.WIND, false);

        Selenide.Wait();
    }
}
