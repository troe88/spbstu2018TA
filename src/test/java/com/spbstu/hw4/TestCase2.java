package com.spbstu.hw4;

import com.codeborne.selenide.Selenide;
import com.spbstu.hw4.utils.Color;
import com.spbstu.hw4.utils.Element;
import com.spbstu.hw4.utils.Metal;
import com.spbstu.selenide.BaseSelenideTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.spbstu.hw4.HomeWork4Site.datesPage;
import static com.spbstu.hw4.HomeWork4Site.homePage;
import static com.spbstu.utils.PropertyLoader.get;

public class TestCase2 extends BaseSelenideTest {
    private static final String TEST_USER_NAME = "test.user.name";
    private static final String TEST_USER_PASSWORD = "test.user.password";
    private static final String TEST_USER_DISPLAY_NAME = "test.user.displayName";
    private static final List<String> SUBMENU_ITEMS = Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements");
    private static final String TEST_SITE_HOMEPAGE = "test.site.homepage";

    @BeforeTest
    public void beforeTest() {
        HomeWork4Site.init();
    }

    /**
     * Данный тест можно запустить следующими maven командами:
     * mvn clean package -Phome_work_4_runner
     * mvn verify -Phome_work_4_runner
     */
    @Test
    public void test() {
        homePage.open(get(TEST_SITE_HOMEPAGE));
        homePage.login(get(TEST_USER_NAME), get(TEST_USER_PASSWORD));
        homePage.checkUserLogIn(get(TEST_USER_DISPLAY_NAME));

        List<String> items = SUBMENU_ITEMS;
        homePage.openHeaderSubmenu();
        homePage.checkHeaderSubmenu(items);
        homePage.openSidebarSubmenu();
        homePage.checkSidebarSubmenu(items);
        homePage.openDatesPage();
        // второй вариант, как можно перейти на страницу: непосредственное открытие
        //HomeWork4Site.elementsPage.open(get("test.site.elementspage"));


        datesPage.dragSliderRange(0, 100);
        datesPage.dragSliderRange(0, 0);
        datesPage.dragSliderRange(100, 100);
        datesPage.dragSliderRange(30, 70);

        datesPage.checkLogOutput(); // the unified assert

        Selenide.Wait();
    }
}
