package com.spbstu.hw1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

import static com.spbstu.hw1.EpamSiteTestEnum.*;

public class EpamSiteTestClass {
    private ChromeDriver driver;
    private SoftAssert sa;


    @BeforeTest
    public void beforeTest() {
        sa = new SoftAssert();
        driver = new ChromeDriver();
    }

    @Test
    public void epamLoginSimpleTest() throws InterruptedException {
        driver.navigate().to(EpamSiteTestEnum.EPAM_TEST_LINK);
        // не ждём одну секунду, а делаем хитрее -- ждём, пока браузер загрузится
        // Ссылка на C# код, но полиморфизм сохранён:
        // https://stackoverflow.com/questions/5868439/wait-for-page-load-in-selenium
        Wait<WebDriver> wait = new WebDriverWait(driver, 5);
        wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));

        driver.manage().window().maximize();

        // Проверяем, что заголовок страницы совпадает с ожидаемым
        Assert.assertEquals(driver.getTitle(), INDEX_PAGE,
                String.format("Actual: %s but expected: %s", driver.getTitle(), INDEX_PAGE));

        // выполняем клик по иконке пользователя
        WebElement element = driver.findElement(By.cssSelector(DROPDOWN_CSS_SELECTOR));
        element.click();
        // заполняем поле логин
        element = driver.findElement(By.cssSelector(LOGIN_CSS_SELECTOR));
        element.sendKeys(LOGIN);
        // заполняем поле пароля и нажимаем клавишу Enter
        element = driver.findElement(By.cssSelector(PASSWORD_CSS_SELECTOR));
        element.sendKeys(PASSWORD + Keys.ENTER);

        // проверяем, что имя пользователя совпадает с ожидаемым
        element = driver.findElement(By.cssSelector(USERNAME_CSS_SELECTOR));
        element.getText();
        sa.assertEquals(element.getText(), USER_FULL_DISPLAY_NAME
                ,String.format(DIAGNOSTIC_STRING, driver.getTitle(), INDEX_PAGE));

        // получаем массив картинок, и смотрим, что их количество соответствует ожидаемому
        sa.assertEquals(driver.getTitle(), INDEX_PAGE
                ,String.format(DIAGNOSTIC_STRING, driver.getTitle(), INDEX_PAGE));
        int sz = driver.findElements(By.cssSelector(ICONS_CSS_SELECTOR)).size();
        sa.assertEquals(sz, 4
                ,String.format(DIAGNOSTIC_STRING, sz, 4));

        // проверяем совпадения текста под фотографиями
        List<String> assertStrings = Arrays.asList(WISH1, WISH2, WISH3, WISH4);
        driver.findElements(By.cssSelector(".benefit-txt"))
                .stream().map(WebElement::getText).forEach(
                        text->sa.assertTrue(assertStrings.contains(text),
                                WISH_NOT_FOUND_DIAGNOSTIC_STRING + text)
                );

        // проверяем совпадения заголовка текста в теге h3 с ожидаемым
        sa.assertEquals(driver.findElement(By.cssSelector(TITLE_CSS_SELECTOR)).getText(),
                EPAM_FRAMEWORK_WISHES, DIAGNOSTIC_STRING);

        // проверяем основное содержимое страницы на совпадение с ожидаемым
        sa.assertEquals(driver.findElement(By.cssSelector( ANNOTATION_CSS_SELECTOR)).getText(),
                LOREM_IPSUM_DOLOR, DIAGNOSTIC_STRING);

        // выполняем SoftAssert
        sa.assertAll();
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
