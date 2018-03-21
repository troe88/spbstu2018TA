package com.spbstu.selenide;

import com.codeborne.selenide.Configuration;
import com.spbstu.selenium.BaseSeleniumTest;
import org.testng.annotations.BeforeSuite;

/**
 * Created by dmitry on 21.03.2018.
 */
public class BaseSelenideTest extends BaseSeleniumTest {
    @BeforeSuite
    public void beforeSuiteSelenide() {
        Configuration.browser = "CHROME";
        Configuration.timeout = 4000;
    }
}
