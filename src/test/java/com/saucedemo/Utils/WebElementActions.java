package com.saucedemo.Utils;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class WebElementActions {

    /**
     * Gets text from element
     */
    public static List<String> getTextFromElements(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();
        for (WebElement element : elements) {
            texts.add(element.getText());
        }
        return texts;
    }
}