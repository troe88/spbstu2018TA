package com.spbstu.selenide;

import com.spbstu.selenidePageObject.EpamTestSiteSelenide;
import com.spbstu.selenidePageObject.entities.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.spbstu.selenidePageObject.enums.HOME_PAGE_DATA.*;

/**
 * Created by dmitry on 21.03.2018.
 */
public class SelenideTest extends BaseSelenideTest {

    @DataProvider(name = "usersDataProvider")
    public Object[] createData1() {
        return new Object[]{
                new User("epam", "1234", "PITER CHAILOVSKII"),
                new User("dima", "qwer", "lebedev"),
        };
    }

    @BeforeClass
    public void beforeClass() {
        EpamTestSiteSelenide.init();
    }

    @Test(dataProvider = "usersDataProvider")
    public void selenideTestDataProvider(User user) {
        EpamTestSiteSelenide.homePageSelenide.open();
        EpamTestSiteSelenide.homePageSelenide.login(user);

        EpamTestSiteSelenide.homePageSelenide.checkUserLogIn(user);
    }


    @Test(enabled = false)
    public void selenideTest() {
        EpamTestSiteSelenide.homePageSelenide.open();
        EpamTestSiteSelenide.homePageSelenide.login(LOGIN.toString(), PASSWORD.toString());

        EpamTestSiteSelenide.homePageSelenide.checkUserLogIn(USER_NAME.toString());
    }

}
