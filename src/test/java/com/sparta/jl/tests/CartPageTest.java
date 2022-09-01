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
//        cartPage = new CartPage(driver);
    }

    @Test
    @DisplayName("Check continue shopping button returns to HomePage")
    void checkContinueShoppingButtonReturnsToHomePage() {
        driver.findElement(By.className("shopping_cart_link")).click();
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", cartPage.getUrl());
    }

    @Test
    @DisplayName("Check that correct amount of items in cart")
    void checkThatCorrectAmountOfItemsInCart() {
        homePage.addBikeLightToCart();
        homePage.addBoltTShirtToCart();
        int actual = cartPage.listOfItems().size();
    }


    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }

}
