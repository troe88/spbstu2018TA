package com.spbstu;

import com.spbstu.utils.PropertyLoader;
import com.spbstu.utils.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by dmitry on 28.02.2018.
 */
public class SimpleTest {

    private TestConfig cfg;

    @BeforeSuite(enabled = false)
    public void beforeSuite() {
        cfg = ConfigFactory.create(TestConfig.class);
    }

    @Test(enabled = false)
    public void simpleTest() {
        System.out.println(PropertyLoader.get("test.user.name"));
        System.out.println(PropertyLoader.get("test.user.password"));
    }

    @Test(enabled = false)
    public void simpleOwnerTest() {
        System.out.println(cfg.name());
        System.out.println(cfg.password());
    }
}
