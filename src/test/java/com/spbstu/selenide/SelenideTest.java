package com.spbstu.selenide;

import com.spbstu.selenium.BaseSeleniumTest;
import org.bouncycastle.eac.EACCertificateBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelenideTest extends BaseSelenideTest {

    @BeforeClass
    public void beforeClass() {
        EpamTestSiteSelenide.init();
    }

    @Test
    public void selenideTest() {
        EpamTestSiteSelenide.homePageSelenide.open();
        EpamTestSiteSelenide.homePageSelenide.login("epam", "1234");
        EpamTestSiteSelenide.homePageSelenide.checkUserLogIn("PITER CHAILOVSKI");
    }

}
