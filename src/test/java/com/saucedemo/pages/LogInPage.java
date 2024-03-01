package com.saucedemo.pages;

import com.saucedemo.Utils.ConfigurationReader;
import com.saucedemo.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class LogInPage {

    public static String username = ConfigurationReader.getProperty("username");
    public static String password = ConfigurationReader.getProperty("password");

    public LogInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user-name")
    private WebElement loginPageUserName;

    @FindBy(id = "password")
    private WebElement loginPagePassword;

    @FindBy(id = "login-button")
    private WebElement submitLoginButton;

    @FindBy(xpath = "//*[text()='Epic sadface: Sorry, this user has been locked out.']")
    public WebElement lockedOutErrorMessage;

    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(70), Duration.ofMillis(400));

    WebDriverWait wait(int timeUnit) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofMillis(timeUnit), Duration.ofMillis(500));
    }

    public void logInPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("saucedemo.url"));
    }

    public void loginUser(String username, String password) {
        fillInUsername(username);
        fillInPassword(password);
        clickLoginSubmitButton();
    }

    private void fillInUsername(String username) {
        waitUntilElementIsClickable(loginPageUserName, 1000);
        loginPageUserName.sendKeys(username);
    }

    /**
     * Fill in password
     */
    private void fillInPassword(String password) {
        loginPagePassword.sendKeys(password);
    }

    /**
     * Click on login submit button
     */
    private void clickLoginSubmitButton() {
        waitUntilElementIsClickable(submitLoginButton);
        submitLoginButton.click();
    }

    public void waitUntilElementIsClickable(WebElement element, int time) {
        wait(time).until(ExpectedConditions.elementToBeClickable(element));
        checkJavascriptIsReady();
    }

    public void waitUntilElementIsClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        checkJavascriptIsReady();
    }

    private void checkJavascriptIsReady() {

        //This loop will rotate for 25 times to check If page Is ready after every 2 second.
        try {
            //label for outer loop
            outer:
            for (int a = 0; a < 3; a++) {
                for (int i = 0; i < 25; i++) {
                    try {
                        Objects.requireNonNull(Driver.getDriver()).manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
                    } catch (Exception e) {
                        System.err.println("Hit problem while waiting for JavaScript to load: " + e.getMessage());
                    }
                    //To check page ready state.
                    if (Driver.getDriver() != null && ((RemoteWebDriver) (Driver.getDriver())).executeScript("return document.readyState").toString().equals("complete")) {
                        break outer;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Timeout Exception Thrown during checkJavascriptIsReady() \n");
            e.printStackTrace();
        }
    }
}