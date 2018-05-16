package com.spbstu.hw4;

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

        homePage.openSidebarSubmenu();
        homePage.openDatesPage();
        // второй вариант, как можно перейти на страницу: непосредственное открытие
        //HomeWork4Site.elementsPage.open(get("test.site.elementspage"));

        datesPage.waitForLoad();
        // единственное, что может активировать логирование слайда -- скролл до него
        datesPage.scrollToSliderRange();

        datesPage.dragSliderRange(0, 100);
        datesPage.dragSliderRange(0, 0);
        datesPage.dragSliderRange(100, 100);
        datesPage.changeSliderRange(95, 100); // необходимая строка, так как в самом логгере присутствует ошибка
        datesPage.dragSliderRange(30, 70);

        datesPage.checkLogOutput(); // the unified assert
    }
}
