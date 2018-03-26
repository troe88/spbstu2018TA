package com.spbstu.hw4.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Condition.text;

/**
 * URL: https://jdi-framework.github.io/tests
 */
public class HomePage {

    private static final String PAGE_URL = "https://jdi-framework.github.io/tests";

    @FindBy(css = ".profile-photo")
    private SelenideElement profilePhoto;

    @FindBy(css = "#Login")
    private SelenideElement loginField;

    @FindBy(css = "#Password")
    private SelenideElement passwordField;

    @FindBy(css = "form .btn-login")
    private SelenideElement submit;

    @FindBy(css = "ul.sidebar-menu > li.sub-menu > a")
    private SelenideElement serviceDropdownHeader;

    @FindBy(css = "ul.sidebar-menu > li.sub-menu > ul.sub > li > a")
    private List<SelenideElement> serviceDropdown;

    public HomePage() {
        Selenide.page(this);
    }

    public void open() {
        Selenide.open(PAGE_URL);
    }

    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.pressEnter();
    }

    public void openSubmenu() {
        serviceDropdownHeader.click();
    }

    public void checkUserLogIn(String userName) {
        profilePhoto.should(have(text(userName)));
    }
}
