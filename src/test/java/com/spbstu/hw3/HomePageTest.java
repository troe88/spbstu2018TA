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

public class HomePageTest {

    // constants
    private static final String LOGIN = "epam";
    private static final String PASSWORD = "1234";
    private static final String PAGE_TITLE = "Index Page";
    private static final String ERROR_STR = "Actual: %s but expected: %s";
    private static final String USER_NAME = "PITER CHAILOVSKII";
    private static final String HEADER_TEXT = "EPAM FRAMEWORK WISHES…";
    private static final String ANNOTATION = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
    private static final int IMAGE_COUNT = 4;

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
        Assert.assertEquals(title, PAGE_TITLE, String.format(ERROR_STR, title, PAGE_TITLE));

        // Осуществляем вход в систему
        page.login(LOGIN, PASSWORD);

        // проверяем, что имя пользователя совпадает с ожидаемым
        String username = page.getUserName();
        sa.assertEquals(username, USER_NAME, String.format(ERROR_STR, username, USER_NAME));

        // получаем массив картинок, и смотрим, что их количество соответствует ожидаемому
        int count = page.getIconsCount();
        sa.assertEquals(count, IMAGE_COUNT, String.format(ERROR_STR, count, IMAGE_COUNT));

        // проверяем совпадения текста под фотографиями
        List<String> assertStrings = Arrays.asList("To include good practices\nand ideas from successful\nEPAM projec",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        page.getBenefitsDescription().forEach(
                txt->sa.assertTrue(assertStrings.contains(txt)));

        // проверяем совпадения заголовка текста в теге h3 с ожидаемым
        String header = page.getPageHeader();
        sa.assertEquals(header, HEADER_TEXT, String.format(ERROR_STR, header, HEADER_TEXT));

        // проверяем основное содержимое страницы на совпадение с ожидаемым
        String annotation = page.getAnnotation();
        sa.assertEquals(annotation, ANNOTATION, String.format(ERROR_STR, annotation, ANNOTATION));

        // выполняем SoftAssert
        sa.assertAll();
    }


    @AfterSuite
    public void afterSuite() {
        driver.close();
    }
}
