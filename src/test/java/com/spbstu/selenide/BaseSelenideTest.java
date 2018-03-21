package com.spbstu.selenide;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class BaseSelenideTest {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "CHROME";
        Configuration.timeout = 4000;
        Configuration.pollingInterval = 100; // "-Dselenide.pollingInterval=50"

        Configuration.reportsFolder = "build/reports/tests";


    }
}
