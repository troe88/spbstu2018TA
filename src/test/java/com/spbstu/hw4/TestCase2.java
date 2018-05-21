package com.spbstu.hw4;

import com.spbstu.allure.ScreenshotAttachmentListener;
import com.spbstu.selenide.BaseSelenideTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

// TODO is that really necessary ?
import java.util.Arrays;
import java.util.List;
// !TODO

import static com.spbstu.hw4.HomeWork4Site.datesPage;
import static com.spbstu.hw4.HomeWork4Site.homePage;
import static com.spbstu.utils.PropertyLoader.get;

@Listeners(ScreenshotAttachmentListener.class)
@Features({"Selenide Test Suite"})
@Stories({"Slider tests"})
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
        // TODO hm..., HomePage.class should incapsulate the whole information about page.
        // TODO it was not really good to pass part of url there...
        // TODO anyway, this test looks pretty good, wel done !
        homePage.open(get(TEST_SITE_HOMEPAGE));
        homePage.logout();
        homePage.login(get(TEST_USER_NAME), get(TEST_USER_PASSWORD));
        homePage.checkUserLogIn(get(TEST_USER_DISPLAY_NAME));

        homePage.openSidebarSubmenu();
        homePage.openDatesPage();
        // второй вариант, как можно перейти на страницу: непосредственное открытие
        //HomeWork4Site.elementsPage.open(get("test.site.elementspage"));

        datesPage.waitForLoad();
        // единственное, что может активировать логирование слайда -- скролл до него
        datesPage.scrollToSliderRange();

        // TODO thats okay, but you can do it a bit easier via java script.
        // TODO take a look on documentations for this angular element...
        datesPage.dragSliderRange(0, 100);
        datesPage.dragSliderRange(0, 0);
        datesPage.dragSliderRange(100, 100);
        datesPage.changeSliderRange(65, 100); // необходимая строка, так как в самом логгере присутствует ошибка
        datesPage.dragSliderRange(30, 70);

        datesPage.checkLogOutput(); // the unified assert
    }
}
