package com.spbstu.cucumber.stepdefs;

import com.codeborne.selenide.Configuration;
import com.spbstu.selenidePageObject.EpamTestSiteSelenide;
import cucumber.api.java.Before;

/**
 * Created by dmitry on 04.04.2018.
 */
public class Hooks {
    @Before
    public void before() {
        Configuration.timeout = 5000;
        EpamTestSiteSelenide.init();
    }
}
