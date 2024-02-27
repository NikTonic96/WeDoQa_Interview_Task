package com.saucedemo.pages;

import com.saucedemo.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCartButton;

    @FindBy(className = "shopping_cart_badge")
    public WebElement shoppingCartBadge;

    @FindBy(xpath = "//*[text()='Products']")
    public WebElement homePageHeader;

    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    public List<WebElement> products;
}