package com.saucedemo.step_definitions;

import com.saucedemo.Utils.ConfigurationReader;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;


import static com.saucedemo.Utils.ButtonInteraction.clickButton;
import static com.saucedemo.Utils.SelectItemAction.*;
import static com.saucedemo.Utils.WebElementActions.getTextFromElements;

public class AddToCart_StepDefinition {
    Login_StepDefinitions loginStepDefinitions = new Login_StepDefinitions();
    HomePage homePage = new HomePage();
    CartPage cartPage = new CartPage();

    @Given("user is logged in")
    public void user_is_logged_in() {
        loginStepDefinitions.user_is_on_the_saucedemo_login_page();
        loginStepDefinitions.the_user_enters_username(ConfigurationReader.getProperty("username"));
        loginStepDefinitions.the_user_enters_password(ConfigurationReader.getProperty("password"));
    }
    @When("the user adds an item {string} to the cart")
    public void the_user_adds_an_item_to_the_cart(String item) {
        addItemIntoCart(item);
    }
    @When("the user opens another item’s {string} details page")
    public void theUserOpensAnotherItemSDetailsPage(String item) {
        selectItemByText(item);
    }
    @When("the user adds an another item from the list to the cart")
    public void the_user_adds_an_another_item_from_the_list_to_the_cart() {
        addItemIntoCart("sauce-labs-bolt-t-shirt");
        addItemIntoCart("sauce-labs-fleece-jacket");
    }

    @When("opens the cart")
    public void opens_the_cart() {
        clickButton(homePage.shoppingCartButton);
    }
    @When("removes the first item from the cart")
    public void removes_the_first_item_from_the_cart() {
        randomClickOneElementByText("Remove");
    }
    @When("opens another item’s details page")
    public void opens_another_item_s_details_page() {
        randomClickOneElement(homePage.products);
    }
    @When("adds the item to the cart")
    public void adds_the_item_to_the_cart() {
        selectItemByText("Add to cart");
    }

    @Then("the user should see the correct amount of items in the cart")
    public void the_user_should_see_the_correct_amount_of_items_in_the_cart() {
        Assert.assertEquals("Cart badge is not updated correctly !!", homePage.shoppingCartBadge.getText(), "1");
    }
    @Then("the correct items are present")
    public void the_correct_items_are_present() {
        Assert.assertEquals("The cart is incorrect !!", 2, cartPage.listOfItemsInCart.size());
    }

    @Then("the user should see the cart badge is correctly updated")
    public void the_user_should_see_the_cart_badge_is_correctly_updated() {
        Assert.assertEquals("Cart badge is not updated correctly !!", homePage.shoppingCartBadge.getText(), "1");
    }
    @Then("the user should see the cart is correctly updated")
    public void theUserShouldSeeTheCartIsCorrectlyUpdated() {
        List<String> elementTexts = getTextFromElements(cartPage.listOfItemsInCart);
        for (String text : elementTexts) {
            System.out.println(text);
            Assert.assertEquals("Incorrect items in cart !!", "Sauce Labs Fleece Jacket",text);
        }
    }

    @Then("the correct amount of items are present")
    public void theCorrectAmountOfItemsArePresent() {
        Assert.assertEquals("The cart is incorrect !!", 2, cartPage.listOfItemsInCart.size());

    }
}