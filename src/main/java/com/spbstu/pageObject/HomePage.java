package com.spbstu.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Page Object
public class HomePage {

    private WebDriver driver;

    @FindBy(css = ".profile-photo")
    private WebElement profilePhoto;

    @FindBy(css = "#Login")
    private WebElement loginField;

    @FindBy(css = "#Password")
    private WebElement passwordField;

    @FindBy(css = "form .btn-login")
    private WebElement submit;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.click();
    }
}
