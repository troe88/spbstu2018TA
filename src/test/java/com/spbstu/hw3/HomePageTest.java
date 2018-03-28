package com.spbstu.hw3;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import static com.spbstu.hw3.HomePageTestEnum.*;

public class HomePageTest {

    public static final int IMAGE_COUNT = 4;

    private ChromeDriver driver;
    private SoftAssert sa;
    private HomePage page;

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
        // разворачиваем на весь экран
        driver.manage().window().maximize();
        EpamTestSite.init(driver);
        // получаем страницу
        page = EpamTestSite.homePage;
    }

    @BeforeTest
    public void beforeTest() {
        sa = new SoftAssert();
    }

    @Test
    public void test() {
        // открываем страницу
        page.open();

        // Проверяем, что заголовок страницы совпадает с ожидаемым
        String title = page.getPageTitle();
        Assert.assertEquals(title, PAGE_TITLE.getValue(),
                String.format(ERROR_STR.getValue(), title,
                        PAGE_TITLE.getValue()));

        // Осуществляем вход в систему
        page.login(LOGIN.getValue(), PASSWORD.getValue());

        // проверяем, что имя пользователя совпадает с ожидаемым
        String username = page.getUserName();
        sa.assertEquals(username, USER_NAME.getValue(),
                String.format(ERROR_STR.getValue(),
                        username, USER_NAME.getValue()));

        // получаем массив картинок, и смотрим, что их количество соответствует ожидаемому
        int count = page.getIconsCount();
        sa.assertEquals(count, IMAGE_COUNT,
                String.format(ERROR_STR.getValue(), count, IMAGE_COUNT));

        // проверяем совпадения текста под фотографиями
        List<String> assertStrings = Arrays.asList(
                BENEFIT1.getValue(),
                BENEFIT2.getValue(),
                BENEFIT3.getValue(),
                BENEFIT4.getValue()
            );
        page.getBenefitsDescription().forEach(
                txt->sa.assertTrue(assertStrings.contains(txt)));

        // проверяем совпадения заголовка текста в теге h3 с ожидаемым
        String header = page.getPageHeader();
        sa.assertEquals(header, HEADER_TEXT.getValue(),
                String.format(ERROR_STR.getValue(), header,
                        HEADER_TEXT.getValue()));

        // проверяем основное содержимое страницы на совпадение с ожидаемым
        String annotation = page.getAnnotation();
        sa.assertEquals(annotation, ANNOTATION.getValue(),
                String.format(ERROR_STR.getValue(),
                        annotation, ANNOTATION.getValue()));

        // выполняем SoftAssert
        sa.assertAll();
    }


    @AfterSuite
    public void afterSuite() {
        driver.close();
    }
}
