package com.agile.and.beyond.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageObject  {

    public static final int DEFAULT_TIMEOUT = 5;
    protected WebDriver driver;
    protected String url;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void visit() {
        if (null != url)
            driver.get(url);
    }

    public WebElement find(By locator) { return driver.findElement(locator); }

    public List<WebElement> findAll(By locator) { return driver.findElements(locator); }

    public void click(By locator) { find(locator).click(); }

    public void type(String inputText, By locator) { find(locator).sendKeys(inputText); }

    public void select(String dropdownItem, By locator) {
        WebElement selectList = find(locator);
        List<WebElement> options = selectList.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.getText().equals(dropdownItem)) {
                option.click();
                break;
            }
        }
    }

    public void submit(By locator) { find(locator).submit(); }

    public String title() { return driver.getTitle(); }

    public Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch(org.openqa.selenium.NoSuchElementException exception) {
            return false;
        }
    }

    public Boolean waitForIsDisplayed(By locator, Integer... timeout) {
        try {
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                    (timeoutValue(timeout)));
        } catch(org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    public void waitFor(ExpectedCondition<WebElement> condition, Integer... timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutValue(timeout));
        wait.until(condition);
    }

    // THIS IS NOT GOOD - ONLY FOR WORKSHOP
    public void sleep(Integer seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private Integer timeoutValue(Integer... timeout) {
        return timeout.length > 0 ? timeout[0] : DEFAULT_TIMEOUT;
    }
}
