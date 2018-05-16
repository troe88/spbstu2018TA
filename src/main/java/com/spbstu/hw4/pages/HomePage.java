package com.spbstu.hw4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Condition.text;

/**
 * URL: https://jdi-framework.github.io/tests
 */
public class HomePage {

    private static final String TEXT_TITLE = "EPAM FRAMEWORK WISHES…";
    private static final String TEXT_CONTENTS = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
    private static final List<String> LIST_OF_BENEFIT = Arrays.asList("To include good practices\nand ideas from successful\nEPAM projec",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    private static final String DIFFERENT_ELEMENTS = "Different elements";
    private static final String DATES = "Dates";
    @FindBy(css = ".profile-photo")
    private SelenideElement profilePhoto;

    @FindBy(css = "#Login")
    private SelenideElement loginField;

    @FindBy(css = "#Password")
    private SelenideElement passwordField;

    @FindBy(css = "form .btn-login")
    private SelenideElement submit;

    @FindBy(css = ".logout > .btn-login")
    private SelenideElement logout;

    @FindBy(css = ".main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection benefitIcons;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection benefitTxt;

    @FindBy(css = "ul.sidebar-menu > li.sub-menu > a")
    private SelenideElement serviceDropdownSidebar;

    @FindBy(css = ".m-l8>li>.dropdown-toggle")
    private SelenideElement serviceDropdownHeader;

    @FindBy(css = "ul.sidebar-menu > li.sub-menu > ul.sub > li > a")
    private ElementsCollection serviceDropdownSubmenuSidebar;

    @FindBy(css = "ul.dropdown-menu > li > a")
    private ElementsCollection serviceDropdownSubmenuHeader;

    public HomePage() {
        Selenide.page(this);
    }

    public void open(String page_url) {
        Selenide.open(page_url);
    }

    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.pressEnter();
    }

    public void openHeaderSubmenu() {
        serviceDropdownHeader.click();
    }

    public void openSidebarSubmenu() {
        serviceDropdownSidebar.click();
    }

    public void openElementsPage() {
        serviceDropdownSubmenuSidebar.stream()
                .filter(elm -> DIFFERENT_ELEMENTS.equals(elm.getText())).findFirst()
                .ifPresent(SelenideElement::click);
    }

    public void openDatesPage() {
        serviceDropdownSubmenuSidebar.stream()
                .filter(elm -> DATES.equals(elm.getText())).findFirst()
                .ifPresent(SelenideElement::click);
    }

    public void checkUserLogIn(String userName) {
        profilePhoto.should(have(text(userName)));
    }

    public boolean getIsLogined() {
        return !profilePhoto.text().isEmpty();
    }

    public void logout() {
        if (!getIsLogined())
            return;
        if(!logout.isDisplayed())
            profilePhoto.click();
        logout.click();
    }

    public void checkInterface() {
        mainTitle.should(have(text(TEXT_TITLE)));
        mainText.should(have(text(TEXT_CONTENTS)));
        benefitIcons.shouldHaveSize(4);
        benefitTxt.shouldHaveSize(4);
        benefitTxt.shouldHave(texts(LIST_OF_BENEFIT));
    }

    public void checkSidebarSubmenu(List<String> items) {
        serviceDropdownSubmenuSidebar.shouldHave(texts(items));
    }

    public void checkHeaderSubmenu(List<String> items) {
        serviceDropdownSubmenuHeader.shouldHave(texts(items));
    }
}
