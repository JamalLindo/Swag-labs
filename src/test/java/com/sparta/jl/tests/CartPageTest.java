package com.sparta.jl.tests;

import com.sparta.jl.pom.pages.CartPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartPageTest {
    static WebDriver driver;
    private CartPage checkoutPage;

    @BeforeAll
    static void setupAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setup() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    @Test
    @DisplayName("Check continue shopping button returns to HomePage")
    void checkContinueShoppingButtonReturnsToHomePage() {
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", checkoutPage.getUrl());
    }


    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }

}
