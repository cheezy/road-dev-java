package com.agile.and.beyond;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void beforeScenario() {
        Hooks.driver = new ChromeDriver();
    }

    @After
    public void afterScenario() {
        Hooks.driver.quit();
    }
}