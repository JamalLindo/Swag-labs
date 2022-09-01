package com.sparta.jl.tests;

import com.sparta.jl.pom.pages.CartPage;
import com.sparta.jl.pom.pages.CheckoutPage1;
import com.sparta.jl.pom.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class CartPageTest {
    static WebDriver driver;
    private CartPage cartPage;
    private HomePage homePage;
    private  CheckoutPage1 checkoutPage1;

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
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setup() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user", Keys.TAB, "secret_sauce", Keys.ENTER);
        homePage = new HomePage(driver);
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
        List actual = cartPage.listOfInventoryItemNames();
        System.out.println(Arrays.toString(actual.toArray()));
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
        //driver.quit();
    }
}
