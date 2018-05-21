package com.spbstu.hw8;

import com.epam.jdi.uitests.core.logger.JDILogger;
import com.epam.jdi.uitests.core.settings.JDISettings;
import com.epam.jdi.uitests.web.selenium.driver.SeleniumDriverFactory;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.spbstu.utils.PropertyLoader;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.uitests.core.settings.JDISettings.driverFactory;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class BaseJDITest {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {

        WebSettings.init();

        JDISettings.driverFactory = new SeleniumDriverFactory();
        JDISettings.driverFactory.setDriverPath(PropertyLoader.get("driver.path"));
        logger = new JDILogger();

        WebSite.init(JDIWebSite.class);
        JDISettings.driverFactory.getDriver();
        logger.info("Run Tests");
    }
}
