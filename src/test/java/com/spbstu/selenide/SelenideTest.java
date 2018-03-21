package com.spbstu.selenide;

import com.spbstu.selenium.BaseSeleniumTest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bouncycastle.eac.EACCertificateBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelenideTest extends BaseSelenideTest {

    @BeforeClass
    public void beforeClass() {
        EpamTestSiteSelenide.init();
    }

    // поставить плагин Lombok, чтобы заработал декоратор
    // dependency недостаточно. Он позволяет убирать констркутор
    @AllArgsConstructor
    @Getter
    enum HOME_PAGE_DATA {
        LOGIN("epam"), PASSWORD("1234"), USER_NAME("PITER CHAILOVSKI");

        String value;
    }

    @Test
    public void selenideTest() {
        EpamTestSiteSelenide.homePageSelenide.open();
        EpamTestSiteSelenide.homePageSelenide.login(HOME_PAGE_DATA.LOGIN.getValue(), HOME_PAGE_DATA.PASSWORD.getValue());
        EpamTestSiteSelenide.homePageSelenide.checkUserLogIn(HOME_PAGE_DATA.USER_NAME.getValue());
    }

}
