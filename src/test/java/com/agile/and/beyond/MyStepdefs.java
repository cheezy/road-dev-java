package com.agile.and.beyond;

import static org.junit.Assert.*;
import com.agile.and.beyond.pages.LoginPage;
import com.agile.and.beyond.pages.WelcomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {

    private LoginPage loginPage;
    private WelcomePage welcomePage;

    public MyStepdefs() {

        loginPage = new LoginPage(Hooks.driver);
        welcomePage = new WelcomePage(Hooks.driver);
    }

    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() throws Throwable {
        loginPage.visit();
        loginPage.sleep(3);
    }

    @When("^I enter a valid username and password$")
    public void iEnterAValidUsernameAndPassword() throws Throwable {
        loginPage.login("user", "pass");
    }

    @Then("^I should see the welcome page$")
    public void iShouldSeeTheWelcomePage() throws Throwable {
        assertTrue(welcomePage.title().contains("Welcome"));
    }

    @When("^I enter an invalid username or password$")
    public void iEnterAnInvalidUsernameOrPassword() throws Throwable {
        loginPage.login("user", "badpass");
    }

    @Then("^I expect to be on the login page$")
    public void iExpectToBeOnTheLoginPage() throws Throwable {
        assertTrue(loginPage.title().contains("Login"));
    }

    @And("^I expect to see an error message$")
    public void iExpectToSeeAnErrorMessage() throws Throwable {
        assertTrue(loginPage.message().contains("Incorrect Username/Password"));
    }

    @When("^I am missing a username$")
    public void iAmMissingAUsername() throws Throwable {
        loginPage.login("", "pass");
    }

    @And("^I expect to see an missing field error$")
    public void iExpectToSeeAnMissingFieldError() throws Throwable {
        assertEquals("Missing Username", loginPage.message());
    }
}
