package com.saucedemo.step_definitions;

import com.saucedemo.Utils.Conditions;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LogInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {

    LogInPage logInPage = new LogInPage();
    HomePage homePage = new HomePage();

    @Given("user is on the saucedemo login page")
    public void user_is_on_the_saucedemo_login_page() {
        logInPage.logInPage();
    }

    @When("the user enters login credentials {string} {string} password")
    public void theUserEntersLoginCredentialsPassword(String username, String password) {
        logInPage.loginUser(username, password);
    }

    @Then("the user should see the dashboard")
    public void the_user_should_see_the_dashboard() {
        Assert.assertTrue(Conditions.isElementDisplayed(homePage.homePageHeader));
    }

    @Then("the user should see the error message")
    public void the_user_should_see_the_error_message() {
        Assert.assertTrue(Conditions.isElementDisplayed(logInPage.lockedOutErrorMessage));
    }
}