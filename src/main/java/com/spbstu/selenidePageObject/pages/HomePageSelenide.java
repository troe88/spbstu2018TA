package com.spbstu.selenidePageObject.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.spbstu.selenidePageObject.entities.User;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.exactText;

/**
 * Created by dmitry on 21.03.2018.
 */
public class HomePageSelenide {
    @FindBy(css = ".profile-photo")
    SelenideElement profilePhoto;

    @FindBy(css = "#Login")
    SelenideElement loginField;

    @FindBy(css = "#Password")
    SelenideElement passwordField;

    @FindBy(css = "form .btn-login")
    SelenideElement submit;

    public HomePageSelenide() {
        Selenide.page(this);
    }

    @Step("Open JDI test site")
    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
    }

    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.click();
    }

    public void checkUserLogIn(String userName) {
        profilePhoto.shouldHave(exactText(userName));
    }

    @Step("Verify user has logged in")
    public void checkUserLogIn(User user) {
        checkUserLogIn(user.getName());
    }

    @Step("Login as certain user")
    public void login(User user) {
        login(user.getLogin(), user.getPassword());
    }
}
