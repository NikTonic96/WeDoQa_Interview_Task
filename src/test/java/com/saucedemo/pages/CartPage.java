package com.saucedemo.pages;

import com.saucedemo.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> priceOfItem;

    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    public List<WebElement> itemDescription;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<WebElement> listOfItemsInCart;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(id = "postal-code")
    public WebElement postalCodeField;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    public WebElement totalPrice;

    @FindBy(xpath = "//h2[@class='complete-header']")
    public WebElement completedOrderMessage;

    @FindBy(xpath = "//div[@class='complete-text']")
    public WebElement orderDispatchInfo;

}