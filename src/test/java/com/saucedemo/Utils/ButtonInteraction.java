package com.saucedemo.Utils;

import org.openqa.selenium.WebElement;

import static com.saucedemo.Utils.Conditions.waitUntilElementIsClickableBool;

public class ButtonInteraction {

    /**
     * Clicks button by providing element
     */
    public static void clickButton(WebElement elementBtn) {
        waitUntilElementIsClickableBool(elementBtn);
        elementBtn.click();
        System.out.println("Button Clicked !");
    }
}