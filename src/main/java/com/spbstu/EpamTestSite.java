package com.spbstu;

import com.spbstu.pageObject.ContactFormPage;
import com.spbstu.pageObject.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EpamTestSite {
    public static ContactFormPage contactFormPage;
    public static HomePage homePage;

    public static void init(WebDriver driver) {
        homePage = PageFactory.initElements(driver, HomePage.class);
        contactFormPage = PageFactory.initElements(driver, ContactFormPage.class);
    }
}
