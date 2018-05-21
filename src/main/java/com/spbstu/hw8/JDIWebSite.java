package com.spbstu.hw8;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.spbstu.hw8.pages.HomePage;
import com.spbstu.hw8.pages.LoginForm;
import org.openqa.selenium.support.FindBy;

@JSite("https://jdi-framework.github.io/")
public class JDIWebSite extends WebSite {

    public static HomePage homePage;
    public static LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User());
    }
}
