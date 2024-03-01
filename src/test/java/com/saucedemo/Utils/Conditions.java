package com.saucedemo.Utils;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Conditions {
    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(70), Duration.ofMillis(400));

    public static boolean waitUntilElementIsClickableBool(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (InvalidSelectorException e) {
            return false;
        }
    }
}