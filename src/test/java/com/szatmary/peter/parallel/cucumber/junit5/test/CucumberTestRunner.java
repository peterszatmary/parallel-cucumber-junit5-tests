package com.szatmary.peter.parallel.cucumber.junit5.test;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report.html", "json:target/cucumber-report.json" })
@Cucumber
@SpringBootTest
class CucumberTestRunner {

}
