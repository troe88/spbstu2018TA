package com.spbstu.selenide;

import com.spbstu.utils.HOME_PAGE_DATA;
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
        EpamTestSiteSelenide.homePageSelenide.login(HOME_PAGE_DATA.LOGIN.getValue(), HOME_PAGE_DATA.PASSWORD.getValue());
        EpamTestSiteSelenide.homePageSelenide.checkUserLogIn(HOME_PAGE_DATA.USER_NAME.getValue());
    }

}
