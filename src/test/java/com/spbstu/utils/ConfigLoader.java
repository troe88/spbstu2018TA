package com.spbstu.utils;

import org.aeonbits.owner.ConfigFactory;

import java.util.Objects;

/**
 * Created by dmitry on 04.04.2018.
 */
public class ConfigLoader {
    private static TestConfig config;

    public static TestConfig config() {
        if (Objects.isNull(config)) {
            config = ConfigFactory.create(TestConfig.class);
        }
        return config;
    }
}
