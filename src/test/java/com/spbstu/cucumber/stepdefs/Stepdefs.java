package com.spbstu.cucumber.stepdefs;

import com.spbstu.selenidePageObject.EpamTestSiteSelenide;
import com.spbstu.utils.ResourceLoader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by dmitry on 04.04.2018.
 */
public class Stepdefs {
    @Given("^Open EPAM test site$")
    public void openEPAMTestSite() throws Throwable {
        EpamTestSiteSelenide.homePageSelenide.open();
    }

    @When("^Login as user \"([^\"]*)\"$")
    public void loginAsUser(String userId) throws Throwable {
        EpamTestSiteSelenide.homePageSelenide.login(ResourceLoader.getUser(userId));
    }

    @Then("^Name of \"([^\"]*)\" displayed$")
    public void nameOfDisplayed(String userId) throws Throwable {
        EpamTestSiteSelenide.homePageSelenide.checkUserLogIn(ResourceLoader.getUser(userId));
    }
}
