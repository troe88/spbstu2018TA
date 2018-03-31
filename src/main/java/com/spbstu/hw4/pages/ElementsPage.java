package com.spbstu.hw4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.spbstu.hw4.utils.Color;
import com.spbstu.hw4.utils.Element;
import com.spbstu.hw4.utils.Metal;
import org.openqa.selenium.support.FindBy;

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

    private SelenideElement getMetal(Metal metal) {
        switch(metal) {
            case GOLD:
                return radiobuttons.get(0);
            case SILVER:
                return radiobuttons.get(1);
            case BRONZE:
                return radiobuttons.get(2);
            case SELEN:
                return radiobuttons.get(3);
            default:
                throw new RuntimeException("No such metal exception");
        }
    }

    private SelenideElement getColor(Color color) {
        switch(color) {
            case RED:
                return dropdownItems.get(0);
            case GREEN:
                return dropdownItems.get(1);
            case BLUE:
                return dropdownItems.get(2);
            case YELLOW:
                return dropdownItems.get(3);
            default:
                throw new RuntimeException("No such color exception");
        }
    }

    public void selectElement(Element element, boolean state) {
        SelenideElement selenideElement = getElement(element);
        /*boolean checked = "true".equals(selenideElement.getAttribute("checked"));
        if (state != checked) selenideElement.click();
        selenideElement.shouldHave(attribute("checked", String.valueOf(state)));*/
        selenideElement.setSelected(state);
        /*if (state)
            selenideElement.shouldBe(checked);
        else
            selenideElement.shouldNotBe(checked);*/
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
