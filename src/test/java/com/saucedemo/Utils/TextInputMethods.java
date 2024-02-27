package com.saucedemo.Utils;

import org.openqa.selenium.WebElement;

public class TextInputMethods {

    public static void textInput(WebElement element, String text) {
        if (element.isDisplayed()) {
            element.sendKeys(text);
            System.out.println("Text was successfully entered !");
        } else {
            System.out.println("Text was not entered !!!");
        }
    }
}
