package com.spbstu.hw4.pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.codeborne.selenide.CollectionCondition.texts;

public class DatesPage {

    @FindBy(css = "#Name")
    SelenideElement inputName;
    @FindBy(css = "#LastName")
    SelenideElement inputLastName;
    @FindBy(css = "#Description")
    SelenideElement inputDescription;
    @FindBy(css = ".range-from > input")
    ElementsCollection inputRange;
    @FindBy(css = ".image-upload > input")
    SelenideElement inputImage;
    @FindBy(css = "#datepicker > input")
    SelenideElement pickDay;
    @FindBy(css = "#timepicker")
    SelenideElement pickTime;
    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliderHandle;
    @FindBy(css = ".ui-slider-range")
    private SelenideElement sliderRange;
    @FindBy(css = ".logs > li")
    private ElementsCollection logEntries;

    private Deque<String> log; // записываем лог событий

    public DatesPage() {
        log = new LinkedList<>();
    }

    private void shiftSlide(SelenideElement slide, Keys direction, int count) {
        if ( count < 0) // || max < 0 rejected by IDE
            throw new IllegalArgumentException("count must be nonnegative");
        //slide.setSelected(true); // выбираем ползунок
        StringBuilder cmd = new StringBuilder();
        for (int i = 0; i < count; i++)
            cmd.append(direction);
        slide.sendKeys(cmd);
    }

    private String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void waitForLoad() {
        // ждём загрузки страницы
        FluentWait<WebDriver> fw = Selenide.Wait();
        fw.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
    }

    private void dragSlide(SelenideElement slide, int count) {
        // 200 equivalent to +75
        //Selenide.actions().dragAndDropBy(slide, -2 + 200, 0).perform();
        //Actions act = Selenide.actions().dragAndDropBy(slide, -2 + count*8/3, 0).perform();
        Selenide.actions().clickAndHold(slide).moveByOffset(-2 + count*8/3, 0)
                .release().build().perform();
    }

    public void dragSliderRange(int min, int max) {
        if ( min > max || min < 0 || min > 100 || max > 100) // || max < 0 rejected by IDE
            throw new IllegalArgumentException("min must be less than max, min and max should be whole digit from 0 to 100.");

        SelenideElement minSlider = sliderHandle.get(0);
        SelenideElement maxSlider = sliderHandle.get(1);

        int currentMin = Integer.valueOf(minSlider.text());
        int currentMax = Integer.valueOf(maxSlider.text());

        String timeMax, timeMin;
        boolean reverse = false;
        if (max > currentMax) {
            dragSlide(maxSlider, max - currentMax);
            timeMax =  getCurrentTime();
            dragSlide(minSlider, min - currentMin);
            timeMin =  getCurrentTime();
        } else {
            dragSlide(minSlider, min - currentMin);
            timeMin =  getCurrentTime();
            dragSlide(maxSlider, max - currentMax);
            timeMax =  getCurrentTime();
            reverse = true;
        }

        // assert later
        String sMin = String.format("%s Range 2(From):%s link clicked", timeMin, minSlider.text());
        String sMax = String.format("%s Range 2(To):%s link clicked", timeMax, maxSlider.text());
        if (reverse) {
            log.addFirst(sMin);
            log.addFirst(sMax);
        } else {
            log.addFirst(sMax);
            log.addFirst(sMin);
        }
        // maybe extra assert for actual getting value?
    }

    public void changeSliderRange(int min, int max) {
        if ( min > max || min < 0 || min > 100 || max > 100) // || max < 0 rejected by IDE
            throw new IllegalArgumentException("min must be less than max, min and max should be whole digit from 0 to 100.");

        SelenideElement minSlider = sliderHandle.get(0);
        SelenideElement maxSlider = sliderHandle.get(1);

        int currentMin = Integer.valueOf(minSlider.text());
        int currentMax = Integer.valueOf(maxSlider.text());

        final String LEFT_CS = "" + (char)KeyEvent.VK_LEFT;
        final String RIGHT_CS = "" + (char)KeyEvent.VK_RIGHT;

        if (max > currentMax) {
            shiftSlide(maxSlider, Keys.RIGHT, max - currentMax);
            if (min > currentMin) {
                shiftSlide(minSlider, Keys.RIGHT, min - currentMin);
            } else {
                shiftSlide(minSlider, Keys.LEFT, currentMin - min);
            }
        } else {
            if (min > currentMin) {
                shiftSlide(minSlider, Keys.RIGHT, min - currentMin);
            } else {
                shiftSlide(minSlider, Keys.LEFT, currentMin - min);
            }
            shiftSlide(maxSlider, Keys.LEFT, currentMax - max);
        }
    }

    public void checkLogOutput() {
        logEntries.shouldHave(texts(new ArrayList<>(log)));
    }

    public void scrollToSliderRange() {
        sliderRange.scrollTo();
    }

}
