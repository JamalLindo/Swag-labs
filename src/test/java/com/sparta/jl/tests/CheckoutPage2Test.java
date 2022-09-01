package com.sparta.jl.tests;

import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.drivers.DriverFactory;
import com.sparta.jl.pom.drivers.DriverOptions;
import com.sparta.jl.pom.pages.CartPage;
import com.sparta.jl.pom.pages.CheckoutPage.CheckoutCompletePage;
import com.sparta.jl.pom.pages.CheckoutPage.CheckoutPage2;
import com.sparta.jl.pom.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutPage2Test {
    static WebDriver driver;
    private CartPage cartPage;
    private CheckoutPage2 checkoutPage2;
    private CheckoutCompletePage checkoutCompletePage;
    private HomePage homePage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver";

    @BeforeAll
    static void setupAll() {
        POMUtils.setDriverLocation(DRIVER_LOCATION);
    }

    @BeforeEach
    void setup() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user", Keys.TAB, "secret_sauce", Keys.ENTER);
        //homePage = new HomePage(driver);
        checkoutPage2 = new CheckoutPage2(driver);
    }

    @Test
    @DisplayName("Check cancel button returns to HomePage")
    void checkCancelButtonReturnsToHomePage() {
        driver.findElement(By.className("btn btn_secondary back btn_medium cart_cancel_link")).click();
        assertEquals("https://www.saucedemo.com/inventory.html", checkoutPage2.getUrl());
    }

    @Test
    @DisplayName("Check finish shopping button goes to CheckoutComplete page")
    void checkFinishButtonReturnsToCheckoutCompletePage() {
        driver.findElement(By.className("btn btn_action btn_medium cart_button")).click();
        assertEquals("https://www.saucedemo.com/checkout-complete.html", checkoutCompletePage.getUrl());
    }

    @Test
    @DisplayName("Check that correct amount of items in cart")
    void checkThatCorrectAmountOfItemsInCart() {
        homePage.addBikeLightToCart();
        homePage.addBoltTShirtToCart();
        int actual = cartPage.listOfItems().size();
    }
}
