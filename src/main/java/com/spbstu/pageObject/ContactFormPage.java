package com.spbstu.pageObject;

import org.openqa.selenium.WebDriver;

public class ContactFormPage {

    private WebDriver driver;

    public ContactFormPage(WebDriver driver) {
        this.driver = driver;
    }

    void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/page1.htm");
    }
}
