package com.spbstu.hw3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {

    private WebDriver driver;

    @FindBy(css = ".profile-photo")
    private WebElement profilePhoto = null;

    @FindBy(css = "#Login")
    private WebElement loginInput = null;

    @FindBy(css = "#Password")
    private WebElement passwordInput = null;

    @FindBy(css = ".profile-photo > span")
    private WebElement username = null;

    @FindBy(css = ".main-content > h3")
    private WebElement pageHeader = null;

    @FindBy(css = ".main-content > p")
    private WebElement annotation = null;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefits = null;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> icons = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * открываем главную страницу EPAM тестирования
     */
    void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        // ждём загрузки страницы
        Wait<WebDriver> wait = new WebDriverWait(driver, 5);
        wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Осуществляем вход в систему используя пару логин и пароль.
     * @param login -- логин
     * @param password -- пароль
     */
    void login(String login, String password) {
        profilePhoto.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password + Keys.ENTER);
    }

    String getPageTitle() {
        return driver.getTitle();
    }

    String getPageHeader() {
        return pageHeader.getText();
    }

    String getUserName() {
        return username.getText();
    }

    String getAnnotation() {
        return annotation.getText();
    }

    int getIconsCount() {
        return icons.size();
    }

    List<String> getBenefitsDescription() {
        return benefits.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
