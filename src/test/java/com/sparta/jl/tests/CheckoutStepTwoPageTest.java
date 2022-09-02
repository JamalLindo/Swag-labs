package com.sparta.jl.tests;

import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.pages.CartPage;
import com.sparta.jl.pom.pages.CheckoutPage.CheckoutCompletePage;
import com.sparta.jl.pom.pages.CheckoutPage.CheckoutStepOnePage;
import com.sparta.jl.pom.pages.CheckoutPage.CheckoutStepTwoPage;
import com.sparta.jl.pom.pages.HomePage;
import com.sparta.jl.pom.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutStepTwoPageTest {
    static WebDriver driver;
    private static HomePage homePage;
    private static LoginPage loginPage;
    private static CartPage cartPage;
    private static CheckoutStepTwoPage checkoutStepTwoPage;
    private static CheckoutStepOnePage checkoutStepOnePage;
    private static CheckoutCompletePage checkoutCompletePage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";


    @BeforeAll
    static void setupAll() {
        POMUtils.setDriverLocation(DRIVER_LOCATION);
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setup() {
        loginPage = new LoginPage(driver);
        homePage = loginPage.goToHomePage();
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
    }

    @Test
    @DisplayName("Check that checkoutPage2 link is correct")
    void checkThatCheckoutPage2LinkIsCorrect() {
        assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutStepTwoPage.getUrl());
    }

    @Test
    @DisplayName("Check cancel button returns to HomePage")
    void checkCancelButtonReturnsToHomePage() {
        homePage = checkoutStepTwoPage.goToCancel(driver);
        assertEquals("https://www.saucedemo.com/inventory.html", homePage.getUrl());
    }

    @Test
    @DisplayName("Check finish shopping button goes to CheckoutComplete page")
    void checkFinishButtonReturnsToCheckoutCompletePage() {
        checkoutCompletePage = checkoutStepTwoPage.goToFinish(driver);
        assertEquals("https://www.saucedemo.com/checkout-complete.html", checkoutCompletePage.getUrl());
    }

    @Test
    @DisplayName("Check that correct amount of items in cart")
    void checkThatCorrectAmountOfItemsInCart() {
        cartPage = homePage.gotoCartPage(driver);
        assertEquals(0, checkoutStepTwoPage.listOfItems().size());
    }

    @Test
    @DisplayName("Check that clicking the cart icon takes you to the Cart page")
    void checkThatClickingTheCartIconTakesYouToTheCartPage() {
        assertEquals("https://www.saucedemo.com/cart.html", checkoutStepTwoPage.getUrlFromCartLink());
    }

    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }

    @AfterEach
    void tearDown() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
