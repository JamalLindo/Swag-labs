package com.sparta.jl.tests;

import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.pages.CartPage;
import com.sparta.jl.pom.pages.CheckoutPage1;
import com.sparta.jl.pom.pages.HomePage;
import com.sparta.jl.pom.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class CartPageTest {
    static WebDriver driver;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    private CartPage cartPage;
    private HomePage homePage;
    private CheckoutPage1 checkoutPage1;
    private LoginPage loginPage;

    public void addAllItemToBasket() {
        homePage.addBackpackToCart();
        homePage.addBikeLightToCart();
        homePage.addBoltTShirtToCart();
        homePage.addFleeceJacketToCart();
        homePage.addOnesieToCart();
        homePage.addRedTShirtToCart();
        cartPage = homePage.gotoCartPage(driver);
    }

    @BeforeAll
    static void setupAll() {
        POMUtils.setDriverLocation(DRIVER_LOCATION);
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setup() {
        loginPage = new LoginPage(driver);
//        loginPage.loginToPage("standard_user");  //doesn't work
        homePage = loginPage.goToHomePage();
    }

    @Test
    @DisplayName("Check continue shopping button returns to HomePage")
    void checkContinueShoppingButtonReturnsToHomePage() {
        cartPage = homePage.gotoCartPage(driver);
        homePage = cartPage.clickContinueShopping(driver);
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", homePage.getUrl());
    }
    @Test
    @DisplayName("Check that when continue shopping and going back to cart items persists")
    void checkThatWhenContinueShoppingAndGoingBackToCartItemsPersists() {
        homePage.addAllItemsToCart();
        cartPage = homePage.gotoCartPage(driver);
        List expected = cartPage.listOfItems();
        homePage = cartPage.clickContinueShopping(driver);
        cartPage = homePage.gotoCartPage(driver);
        List actual = cartPage.listOfItems();
        Assertions.assertEquals(expected.size(), actual.size());
    }

    @Test
    @DisplayName("Check that return list item names are correct")
    void checkThatReturnListItemNamesAreCorrect() {
        homePage.addAllItemsToCart();
        cartPage = homePage.gotoCartPage(driver);
        List actual = cartPage.listOfItemNames();
        String expected = "[Test.allTheThings() T-Shirt (Red)" +
                ", Sauce Labs Onesie" +
                ", Sauce Labs Fleece Jacket" +
                ", Sauce Labs Bolt T-Shirt" +
                ", Sauce Labs Bike Light" +
                ", Sauce Labs Backpack]";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Check that correct amount of items in cart")
    void checkThatCorrectAmountOfItemsInCart() {
        homePage.addBikeLightToCart();
        homePage.addBoltTShirtToCart();
        cartPage = homePage.gotoCartPage(driver);
        int actual = cartPage.listOfItems().size();
        Assertions.assertEquals(2,actual);
    }
    @Test
    @DisplayName("Check that when all items added is correct amount")
    void checkThatWhenAllItemsAddedIsCorrectAmount() {
        homePage.addAllItemsToCart();
        cartPage = homePage.gotoCartPage(driver);
        int actual = cartPage.listOfItems().size();
        Assertions.assertEquals(6,actual);
    }
    @Test
    @DisplayName("Check all remove buttons work")
    void checkAllRemoveButtonsWork() {
        homePage.addAllItemsToCart();
        cartPage = homePage.gotoCartPage(driver);
        cartPage.removeAllItems();
        int actual = cartPage.listOfItems().size();
        Assertions.assertEquals(0,actual);
    }
    @Test
    @DisplayName("Check that the remove buttons work")
    void checkThatTheRemoveButtonsWork() {
        homePage.addAllItemsToCart();
        cartPage = homePage.gotoCartPage(driver);
        cartPage.removeBackpack();
        Assertions.assertEquals(5, cartPage.listOfItems().size());
    }

    @Test
    @DisplayName("Check list of remove buttons are correct numbers")
    void checkListOfRemoveButtonsAreCorrectNumbers() {
        homePage.addAllItemsToCart();
        cartPage = homePage.gotoCartPage(driver);
        Assertions.assertEquals(cartPage.listOfItems().size(), cartPage.listOfRemoveItemBtn().size());
    }

    @Test
    @DisplayName("Check Checkout button goes to correct url")
    void checkCheckoutButtonGoesToCorrectUrl() {
        checkoutPage1 = cartPage.clickCheckout(driver);
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", checkoutPage1.getURL());
    }
    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }
}
