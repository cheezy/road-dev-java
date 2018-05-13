package com.agile.and.beyond.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

    private By bookRecomendationLocation = By.className("btn-primary");

    public WelcomePage(WebDriver driver) { super(driver); }

}
