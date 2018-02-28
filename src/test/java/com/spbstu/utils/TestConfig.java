package com.spbstu.utils;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

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

}
