package com.spbstu.selenide;

import com.spbstu.selenium.BaseSeleniumTest;
import lombok.AllArgsConstructor;
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
    // TODO -- подключить плагин LOMBOK
    //@AllArgsConstructor
    enum HOME_PAGE_DATA {
        LOGIN("epam"), PASSWORD("1234"), USER_NAME("PITER_CHAILOVSKI");

        String value;

        // TODO -- убрать это с помощью LOMBOK
        HOME_PAGE_DATA(String value) {
            this.value = value;
        }
    }

    @Test
    public void selenideTest() {
        EpamTestSiteSelenide.homePageSelenide.open();
        EpamTestSiteSelenide.homePageSelenide.login(HOME_PAGE_DATA.LOGIN.toString(), HOME_PAGE_DATA.PASSWORD.toString());
        EpamTestSiteSelenide.homePageSelenide.checkUserLogIn(HOME_PAGE_DATA.USER_NAME.toString());
    }

}
