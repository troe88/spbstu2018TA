package com.spbstu.selenide;

import com.spbstu.selenidePageObject.EpamTestSiteSelenide;
import com.spbstu.selenidePageObject.entities.User;
import com.spbstu.utils.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Title;

import static com.spbstu.selenidePageObject.enums.HOME_PAGE_DATA.*;

/**
 * Created by dmitry on 21.03.2018.
 */
@Features("JDI test site")
@Listeners(AllureAttachmentListener.class)
public class SelenideTest extends BaseSelenideTest {

    @DataProvider(name = "usersDataProvider")
    public Object[] createData1() {
        return new Object[]{
                new User("epam", "1234", "PITER CHAILOVSKII"),
        };
    }

    @BeforeClass
    public void beforeClass() {
        EpamTestSiteSelenide.init();
    }

    @Title("Login scenario")
    @Description("Scenario verify that user can login on JDI site")
    @Test(dataProvider = "usersDataProvider")
    public void selenideTestDataProvider(@Parameter("User") User user) {
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
