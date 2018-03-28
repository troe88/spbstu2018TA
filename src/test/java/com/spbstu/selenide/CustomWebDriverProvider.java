package com.spbstu.selenide;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

import static com.spbstu.selenium.BaseSeleniumTest.config;

/**
 * Created by dmitry on 28.03.2018.
 */
public class CustomWebDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        capabilities.setCapability("screenResolution", "1920x1080x24");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create(String.format("http://%s/wd/hub", config.remoteDriverAddress())).toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().window().setSize(new Dimension(1920, 1080));
        return driver;
    }
}
