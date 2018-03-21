package com.spbstu.selenidePageObject;

import com.spbstu.selenidePageObject.pages.ContactFormPageSelenide;
import com.spbstu.selenidePageObject.pages.HomePageSelenide;

/**
 * Created by dmitry on 21.03.2018.
 */
public class EpamTestSiteSelenide {
    static public HomePageSelenide homePageSelenide;
    static public ContactFormPageSelenide contactFormPageSelenide;

    public static void init() {
        homePageSelenide = new HomePageSelenide();
        contactFormPageSelenide = new ContactFormPageSelenide();
    }
}
