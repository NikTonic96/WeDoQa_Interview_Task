package com.saucedemo.Utils;

import org.openqa.selenium.WebElement;

public class ButtonInteraction {

    public static void clickButton(WebElement elementBtn) {
        if (elementBtn.isDisplayed()) {
            elementBtn.click();
            System.out.println("Button Clicked !");
        } else {
            System.out.println("Button did not click !!");
        }
    }
}
