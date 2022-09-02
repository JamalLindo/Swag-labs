package com.sparta.jl.tests;

import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.pages.CheckoutPage.CheckoutCompletePage;
import com.sparta.jl.pom.pages.HomePage;
import com.sparta.jl.pom.pages.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutCompletePageTest {
    static WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CheckoutCompletePage checkoutCompletePage;

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
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @Test
    @DisplayName("Check that checkoutCompletePage link is correct")
    void checkThatCheckoutCompletePageLinkIsCorrect() {
        assertEquals("https://www.saucedemo.com/checkout-complete.html", checkoutCompletePage.getUrl());
    }
}
