package com.spbstu.hw4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.spbstu.hw4.utils.Color;
import com.spbstu.hw4.utils.Element;
import com.spbstu.hw4.utils.Metal;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;

public class ElementsPage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio > input")
    private ElementsCollection radiobuttons;

    @FindBy(css = ".colors>select")
    private SelenideElement dropdown;

    @FindBy(css = ".colors>select>option")
    private ElementsCollection dropdownItems;

    @FindBy(name = "Default Button")
    private SelenideElement defaultButton;

    @FindBy(css = "input.uui-button")
    private SelenideElement button;

    @FindBy(css = ".panel-body-list.results")
    private SelenideElement resultsOutput;

    @FindBy(css = ".panel-body-list.logs")
    private SelenideElement logOutput;

    @FindBy(css = ".logs > li")
    private ElementsCollection logEntries;

    @Getter
    private List<String> log;

    public ElementsPage() {
        log = new java.util.LinkedList<>();
    }

    private SelenideElement getElement(Element element) {
        return checkboxes.get(element.ordinal());
    }

    private SelenideElement getElementCheckbox(Element element) {
        return getElement(element).find(By.cssSelector("input"));
    }

    private String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private SelenideElement getMetal(Metal metal) {
        return radiobuttons.get(metal.ordinal());
    }

    private SelenideElement getColor(Color color) {
        return dropdownItems.get(color.ordinal());
    }

    @Step
    public void open(String page_url) {
        Selenide.open(page_url);
    }

    @Step
    public void checkPage() {
        checkboxes.shouldHave(size(4));
        radiobuttons.shouldHave(size(4));
        dropdown.should(exist);
        button.should(exist);
        defaultButton.should(exist);
        resultsOutput.should(exist);
        logOutput.should(exist);
    }

    @Step
    public void selectElement(Element element, boolean state) {
        SelenideElement selenideElement = getElementCheckbox(element);
        if (state != selenideElement.isSelected()) {
            selenideElement.setSelected(state);
            // log here, otherwise condition needn't to be changed
            log.add(0, String.format("%s %s: condition changed to %b", getCurrentTime(), element.getValue(), state));
        }
        // assert
        if (state) {
            selenideElement.shouldBe(checked);
        } else {
            selenideElement.shouldNotBe(checked);
        }
    }

    @Step
    public void selectMetal(Metal metal) {
        SelenideElement selenideElement = getMetal(metal);
        selenideElement.click();
        // log
        log.add(0, String.format("%s metal: value changed to %s", getCurrentTime(), metal.getValue()));
        // assert
        selenideElement.shouldBe(selected);
    }

    @Step
    public void selectColor(Color color) {
        SelenideElement selenideElement = getColor(color);
        dropdown.click();
        selenideElement.click();
        // log
        log.add(0, String.format("%s Colors: value changed to %s", getCurrentTime(), color.getValue()));
        // assert
        dropdown.shouldHave(value(color.getValue()));
    }

    @Step
    public void checkLogOutput() {
        logEntries.shouldHave(texts(log));
    }
}
