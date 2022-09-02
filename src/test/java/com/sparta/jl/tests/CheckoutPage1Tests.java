package com.sparta.jl.tests;

import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.pages.CheckoutPage.CheckoutPage1;
import com.sparta.jl.pom.pages.HomePage;
import com.sparta.jl.pom.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutPage1Tests {
    static WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CheckoutPage1 checkoutPage1;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver";

    @BeforeAll
    static void setupAll() {
        POMUtils.setDriverLocation(DRIVER_LOCATION);
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setup() {
        loginPage = new LoginPage(driver);
        homePage = loginPage.goToHomePage();
        checkoutPage1 = new CheckoutPage1(driver);
    }

    @Test
    @DisplayName("Check that the URL is correct")
    void checkThatTheUrlIsCorrect(){
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", checkoutPage1.getURL());
    }

    @Test
    @DisplayName("Check that clicking the cancel button sends you to the cart page")
    void checkThatClickingTheCancelButtonSendsYouToTheCartPage(){
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", checkoutPage1.cancelCheckout(driver).getUrl());
    }

    @Test
    @DisplayName("Check that clicking the continue button sends you to checkout page 2")
    void checkThatClickingTheContinueButtonSendsYouToCheckoutPage2(){
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutPage1.goToCheckoutPage2().getUrl());
    }

    @Test
    @DisplayName("check that you go to checkout page 2 by entering strings into the form and pressing continue")
    void checkThatYouGoToCheckoutPage2ByEnteringStringsIntoTheFormAndPressingContinue(){
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutPage1.goToCheckoutPage2().getUrl());
    }

    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }
}