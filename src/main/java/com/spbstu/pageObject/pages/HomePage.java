package com.spbstu.pageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dmitry on 14.03.2018.
 */
public class HomePage {
    @FindBy(css = ".profile-photo")
    WebElement profilePhoto;

    @FindBy(css = "#Login")
    WebElement loginField;

    @FindBy(css = "#Password")
    WebElement passwordField;

    @FindBy(css = "form .btn-login")
    WebElement submit;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.click();
    }
}
