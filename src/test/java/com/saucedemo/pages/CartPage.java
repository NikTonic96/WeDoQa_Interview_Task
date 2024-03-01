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
    LogInPage logInPage = new LogInPage();

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> priceOfItem;

    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    public List<WebElement> itemDescription;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<WebElement> listOfItemsInCart;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(id = "first-name")
    public WebElement firstNameInput;

    @FindBy(id = "last-name")
    public WebElement lastNameInput;

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

    public void completeOrder(String firsName, String surname, String postCode) {
        firstNameField(firsName);
        lastNameField(surname);
        postCodeField(postCode);
        clickSubmitOrder();
    }

    private void firstNameField(String name) {
        logInPage.waitUntilElementIsClickable(firstNameInput, 1000);
        firstNameInput.sendKeys(name);
    }

    /**
     * Fill in password
     */
    private void lastNameField(String surname) {
        logInPage.waitUntilElementIsClickable(lastNameInput, 1000);
        lastNameInput.sendKeys(surname);
    }
    private void postCodeField(String postCode) {
        logInPage.waitUntilElementIsClickable(postalCodeField, 1000);
        postalCodeField.sendKeys(postCode);
    }

    /**
     * Click on login submit button
     */
    private void clickSubmitOrder() {
        logInPage.waitUntilElementIsClickable(continueButton);
        continueButton.click();
    }
}