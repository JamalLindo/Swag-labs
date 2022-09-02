package com.sparta.jl.tests;

import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.drivers.DriverFactory;
import com.sparta.jl.pom.drivers.DriverOptions;
import com.sparta.jl.pom.pages.CheckoutPage.CheckoutCompletePage;
import com.sparta.jl.pom.pages.HomePage;
import com.sparta.jl.pom.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutCompletePageTests {
    static WebDriver driver;
    private CheckoutCompletePage checkoutCompletePage;

    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    @BeforeAll
    static void setupAll() {
        POMUtils.setDriverLocation(DRIVER_LOCATION);
        driver = DriverFactory.getDriver(DriverOptions.CHROME);
    }

    @BeforeEach
    void setup() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.goToHomePage();
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @Test
    @DisplayName("Check that checkoutCompletePage link is correct")
    void checkThatCheckoutCompletePageLinkIsCorrect() {
        assertEquals("https://www.saucedemo.com/checkout-complete.html", checkoutCompletePage.getUrl());
    }

    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }
}
