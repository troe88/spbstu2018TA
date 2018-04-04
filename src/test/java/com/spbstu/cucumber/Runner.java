package com.spbstu.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by dmitry on 04.04.2018.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.spbstu.cucumber.stepdefs"}
)
public class Runner {
}
