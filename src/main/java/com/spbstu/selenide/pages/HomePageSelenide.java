package com.spbstu.selenide.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Condition.text;

// Page Object
public class HomePageSelenide {

    @FindBy(css = ".profile-photo")
    private SelenideElement profilePhoto;

    @FindBy(css = "#Login")
    private SelenideElement loginField;

    @FindBy(css = "#Password")
    private SelenideElement passwordField;

    @FindBy(css = "form .btn-login")
    private SelenideElement submit;

    public HomePageSelenide() {
        Selenide.page(this);
    }

    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests");
    }

    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.pressEnter();
    }

    public void checkUserLogIn(String userName) {
        profilePhoto.should(have(text(userName)));
    }
}
