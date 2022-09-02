package com.sparta.jl.tests;

import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.drivers.DriverFactory;
import com.sparta.jl.pom.drivers.DriverOptions;
import com.sparta.jl.pom.pages.CheckoutPage.CheckoutStepOnePage;
import com.sparta.jl.pom.pages.HomePage;
import com.sparta.jl.pom.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutStepOnePageTests {
    static WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CheckoutStepOnePage checkoutStepOnePage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    @BeforeAll
    static void setupAll() {
        POMUtils.setDriverLocation(DRIVER_LOCATION);
        driver = DriverFactory.getDriver(DriverOptions.CHROME);
    }

    @BeforeEach
    void setup() {
        loginPage = new LoginPage(driver);
        homePage = loginPage.goToHomePage();
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
    }

    @Test
    @DisplayName("Check that the URL is correct")
    void checkThatTheUrlIsCorrect(){
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", checkoutStepOnePage.getURL());
    }

    @Test
    @DisplayName("Check that clicking the cancel button sends you to the cart page")
    void checkThatClickingTheCancelButtonSendsYouToTheCartPage(){
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", checkoutStepOnePage.cancelCheckout(driver).getUrl());
    }

    @Test
    @DisplayName("Check that clicking the continue button sends you to checkout page 2")
    void checkThatClickingTheContinueButtonSendsYouToCheckoutPage2(){
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutStepOnePage.goToCheckoutPage2().getUrl());
    }

    @Test
    @DisplayName("check that you go to checkout page 2 by entering strings into the form and pressing continue")
    void checkThatYouGoToCheckoutPage2ByEnteringStringsIntoTheFormAndPressingContinue(){
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutStepOnePage.goToCheckoutPage2().getUrl());
    }

    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }
}