package com.saucedemo.step_definitions;

import com.saucedemo.Utils.ConfigurationReader;
import com.saucedemo.Utils.Driver;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LogInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.saucedemo.Utils.ButtonInteraction.clickButton;
import static com.saucedemo.Utils.TextInputMethods.textInput;


public class Login_StepDefinitions {

    LogInPage logInPage = new LogInPage();
    HomePage homePage = new HomePage();

    @Given("user is on the saucedemo login page")
    public void user_is_on_the_saucedemo_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("saucedemo.url"));
    }

    @When("the user enters {string} username")
    public void the_user_enters_username(String username) {
        textInput(logInPage.username, username);
    }

    @When("the user enters {string} password")
    public void the_user_enters_password(String password) {
        textInput(logInPage.password, password);
        clickButton(logInPage.logInButton);
    }

    @Then("the user should see the dashboard")
    public void the_user_should_see_the_dashboard() {
        Assert.assertEquals("Incorrect page!", "Products", homePage.homePageHeader.getText());
        Assert.assertEquals("Not on expected url", Driver.getDriver().getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html");
    }

    @Then("the user should see the error message")
    public void the_user_should_see_the_error_message() {
        Assert.assertEquals("Incorrect error message !!", "Epic sadface: Sorry, this user has been locked out.",
                logInPage.lockedOutErrorMessage.getText());
    }
}