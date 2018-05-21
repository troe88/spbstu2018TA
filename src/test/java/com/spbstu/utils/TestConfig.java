package com.spbstu.utils;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.Sources;

/**
 * Created by dmitry on 28.02.2018.
 */

@Sources({
        "classpath:test.properties"
})
public interface TestConfig extends Config {

    @Key("test.user.name")
    String name();

    @Key("test.user.password")
    String password();

    @Key("test.user.displayName")
    String displayName();

    @Key("test.site.title")
    String title();

    @Key("test.site.homepage")
    String homepage();

    @Key("test.site.contactformpage")
    String contactformpage();

    @Key("webdriver.chrome.driver")
    String pathToDriver();

    @Key("remote.driver.url")
    String remoteDriverAddress();
}
