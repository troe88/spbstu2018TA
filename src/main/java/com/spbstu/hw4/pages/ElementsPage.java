package com.spbstu.hw4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.spbstu.hw4.utils.Color;
import com.spbstu.hw4.utils.Element;
import com.spbstu.hw4.utils.Metal;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;

public class ElementsPage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
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

    private List<String> log;

    public void open(String page_url) {
        Selenide.open(page_url);
    }

    public void checkPage() {
        checkboxes.shouldHave(size(4));
        radiobuttons.shouldHave(size(4));
        dropdown.should(exist);
        button.should(exist);
        defaultButton.should(exist);
        resultsOutput.should(exist);
        logOutput.should(exist);
    }

    private SelenideElement getElement(Element element) {
        return checkboxes.get(element.ordinal());
    }

    private SelenideElement getElementCheckbox(Element element) {
        return getElement(element).find(By.cssSelector("input"));
    }

    private SelenideElement getMetal(Metal metal) {
        return radiobuttons.get(metal.ordinal());
    }

    private SelenideElement getColor(Color color) {
        return dropdownItems.get(color.ordinal());
    }

    public void selectElement(Element element, boolean state) {
        SelenideElement selenideElement = getElementCheckbox(element);
        if (state != selenideElement.isSelected()) selenideElement.setSelected(state);
        if (state) {
            selenideElement.shouldBe(checked);
        } else {
            selenideElement.shouldNotBe(checked);
        }
    }
    
    public void selectMetal(Metal metal) {
        SelenideElement selenideElement = getMetal(metal);
        selenideElement.click();
        //selenideElement.shouldBe(selected);
    }

    public void selectColor(Color color) {
        SelenideElement selenideElement = getColor(color);
        dropdown.click();
        selenideElement.click();
    }
}
