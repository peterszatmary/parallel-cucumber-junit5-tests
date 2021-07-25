package com.szatmary.peter.parallel.cucumber.junit5.test;

import io.cucumber.java8.En;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CucumberSteps implements En {

    @Autowired
    private TestUtils testUtils;

    public CucumberSteps() {
        Given("^A", () -> {
            log.info("Step A");
            testUtils.waitForSeconds(2);
        });
        When("^B", () -> {
            testUtils.waitForSeconds(2);
            log.info("Step B");
        });
        Then("^C", () -> {
            log.info("Step C");
            testUtils.waitForSeconds(2);
        });
    }
}