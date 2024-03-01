package com.saucedemo.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SelectItemAction {

    /**
     * Adds item into cart by name
     */
    public static void addItemIntoCart(String chooseByName) {
        WebElement item = Driver.getDriver().findElement(By.id("add-to-cart-" + chooseByName));
        item.click();
    }

    /**
     * Selects item by text
     */
    public static void selectItemByText(String itemName) {
        WebElement item = Driver.getDriver().findElement(By.xpath("//*[text()='" + itemName + "']"));
        if (itemName.isEmpty()) {

        }
        item.click();
    }

    /**
     * Clicks on random element by providing String
     */
    public static void randomClickOneElementByText(String searchText) {
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//*[text()='" + searchText + "']"));
        randomClickOneElement(elements);
    }

    /**
     * Clicks on a random element from a list of fetched/provided elements
     *
     * @param element List of fetched web elements
     */
    public static void randomClickOneElement(List<WebElement> element) {
        Random random = new Random();
        int randomIndex = random.nextInt(element.size());
        element.get(randomIndex).click();
    }
}