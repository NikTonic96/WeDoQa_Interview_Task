package com.saucedemo.step_definitions;

import com.saucedemo.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.saucedemo.Utils.ButtonInteraction.clickButton;
import static com.saucedemo.Utils.JavaFakerActions.*;
import static com.saucedemo.Utils.SelectItemAction.randomClickOneElementByText;

public class Checkout_StepDefinitions extends CartPage {

    @When("the user adds an item from the list to the cart")
    public void theUserAddsAnItemFromTheListToTheCart() {
        randomClickOneElementByText("Add to cart");
    }

    @And("continues to the Checkout page")
    public void continuesToTheCheckoutPage() {
        clickButton(checkoutButton);
    }

    @And("completes the checkout form")
    public void completesTheCheckoutForm() {
        completeOrder(generateRandomName(), generateRandomSurname(), generateRandomPostalCode());
    }

    @And("completes the order")
    public void completesTheOrder() {
        clickButton(finishButton);
    }

    @Then("the order is completed successfully with the displayed message")
    public void theOrderIsCompletedSuccessfullyWithTheDisplayedMessage() {
        Assert.assertEquals("Message is incorrect !!",
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!", orderDispatchInfo.getText());
        Assert.assertEquals("Message is incorrect !!",
                "Thank you for your order!", completedOrderMessage.getText());

    }
}