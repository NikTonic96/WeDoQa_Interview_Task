package com.saucedemo.Utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SelectItemAction {

    public static void addItemIntoCart(String chooseByName){
        WebElement item =  Driver.getDriver().findElement(By.id("add-to-cart-"+chooseByName));
        item.click();
    }

    public static void selectItemByText(String itemName){
        WebElement item = Driver.getDriver().findElement(By.xpath("//*[text()='"+itemName+"']"));
        item.click();
    }

    public static void randomClickOneElementByText(String searchText) {
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//*[text()='" + searchText + "']"));
        Random random = new Random();
        int randomIndex = random.nextInt(elements.size());
        elements.get(randomIndex).click();
    }

    public static void randomClickOneElement(List<WebElement> element) {
        //List<WebElement> elements = Driver.getDriver().findElements(By.xpath(element.);
        Random random = new Random();
        int randomIndex = random.nextInt(element.size());
        element.get(randomIndex).click();
    }

    public static void clickElementByText( String searchText, int numberOfClicks) {
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//*[text()='" + searchText + "']"));

        int count = 0;
        for (WebElement element : elements) {
            if (count < numberOfClicks) {
                element.click();
                count++;
            } else {
                break;
            }
        }
    }

}
