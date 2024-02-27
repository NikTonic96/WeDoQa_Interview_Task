package com.saucedemo.pages;

import com.saucedemo.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    public LogInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user-name")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement logInButton;

    @FindBy(xpath = "//*[text()='Epic sadface: Sorry, this user has been locked out.']")
    public WebElement lockedOutErrorMessage;
}