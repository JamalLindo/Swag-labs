package com.sparta.jl.tests;

import com.sparta.jl.pom.pages.CartPage;
import com.sparta.jl.pom.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartPageTest {
    static WebDriver driver;
    private CartPage cartPage;
    private HomePage homePage;

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

        homePage = cartPage.gotoContinueShopping(driver);
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", homePage.getUrl());
    }

    @Test
    @DisplayName("Check that when continue shopping and going back to cart items persists")
    void checkThatWhenContinueShoppingAndGoingBackToCartItemsPersists() {
        

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
        addAllItemToBasket();
        int actual = cartPage.listOfItems().size();
        Assertions.assertEquals(6,actual);
    }

    @Test
    @DisplayName("Check all remove buttons work")
    void checkAllRemoveButtonsWork() {
        addAllItemToBasket();
        cartPage.removeAllItems();
        int actual = cartPage.listOfItems().size();
        Assertions.assertEquals(0,actual);
    }

    @Test
    @DisplayName("Check that the remove buttons work")
    void checkThatTheRemoveButtonsWork() {
        addAllItemToBasket();
        cartPage.removeBackpack();
        System.out.println(cartPage.listOfItems().size());
    }
    @AfterAll
    static void tearDownAll() {
        //driver.quit();
    }

}
