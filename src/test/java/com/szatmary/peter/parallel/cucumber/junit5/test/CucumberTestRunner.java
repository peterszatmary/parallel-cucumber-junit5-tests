package com.szatmary.peter.parallel.cucumber.junit5.test;

import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@Cucumber
@SpringBootTest
class CucumberTestRunner {

}
