package com.szatmary.peter.parallel.cucumber.junit5.test;

import io.cucumber.java8.En;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CucumberSteps2 implements En {

    @Autowired
    private TestUtils testUtils;

    public CucumberSteps2() {
        Given("^A2", () -> {
            log.info("Step A2");
            testUtils.waitForSeconds(2);
        });
        When("^B2", () -> {
            testUtils.waitForSeconds(2);
            log.info("Step B2");
        });
        Then("^C2", () -> {
            log.info("Step C2");
            testUtils.waitForSeconds(2);
        });
    }
}