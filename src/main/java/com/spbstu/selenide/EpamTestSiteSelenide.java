package com.spbstu.selenide;

import com.spbstu.selenide.pages.ContactFormPageSelenide;
import com.spbstu.selenide.pages.HomePageSelenide;

public class EpamTestSiteSelenide {

    public static HomePageSelenide homePageSelenide;
    public static ContactFormPageSelenide contactFormPageSelenide;

    public static void init() {
        homePageSelenide = new HomePageSelenide();
        contactFormPageSelenide = new ContactFormPageSelenide();

    }
}
