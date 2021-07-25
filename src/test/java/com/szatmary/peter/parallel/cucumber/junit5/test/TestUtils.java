package com.szatmary.peter.parallel.cucumber.junit5.test;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TestUtils {

    public void waitForSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
