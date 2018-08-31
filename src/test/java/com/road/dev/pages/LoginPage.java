package com.road.dev.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By submitLocator = By.id("submit");
    private By messageLocator = By.id("message");

    public LoginPage(WebDriver driver) {
        super(driver);
        url = "http://localhost:8085/login";
    }

    public void login(String username, String password) {
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(submitLocator);
    }

    public String message() {
        return find(messageLocator).getText();
    }
    
}
