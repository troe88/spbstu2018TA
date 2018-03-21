package com.spbstu.selenide;

import com.spbstu.selenidePageObject.EpamTestSiteSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.spbstu.selenidePageObject.enums.HOME_PAGE_DATA.*;

/**
 * Created by dmitry on 21.03.2018.
 */
public class SelenideTest extends BaseSelenideTest {

    @BeforeClass
    public void beforeClass() {
        EpamTestSiteSelenide.init();
    }

    @Test
    public void selenideTest() {
        EpamTestSiteSelenide.homePageSelenide.open();
        EpamTestSiteSelenide.homePageSelenide.login(LOGIN.toString(), PASSWORD.toString());

        EpamTestSiteSelenide.homePageSelenide.checkUserLogIn(USER_NAME.toString());
    }

}
