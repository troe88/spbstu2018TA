package com.spbstu.pageObject;

import com.spbstu.EpamTestSite;
import com.spbstu.selenium.BaseSeleniumTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTests extends BaseSeleniumTest {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        EpamTestSite.init(driver);
    }

    @Test
    public void loginTest() {
        EpamTestSite.homePage.open();
        EpamTestSite.homePage.login(config.name(), config.password());

        EpamTestSite.contactFormPage.open();
        // TODO assert
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }

}
