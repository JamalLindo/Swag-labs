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
    private HomePage homePage;
    private LoginPage loginPage;
    private CartPage cartPage;
    private CheckoutStepTwoPage checkoutPage2;
    private CheckoutStepOnePage checkoutPage1;
    private CheckoutCompletePage checkoutCompletePage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver";

    @BeforeAll
    static void setupAll() {
        POMUtils.setDriverLocation(DRIVER_LOCATION);
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setup() {
        /*
        loginPage = new LoginPage(driver);
        homePage = loginPage.goToHomePage();
        checkoutPage2 = new CheckoutPage2(driver);
        */

        loginPage = new LoginPage(driver);
        homePage = loginPage.goToHomePage();
        cartPage = homePage.gotoCartPage(driver);
        checkoutPage1 = cartPage.gotoCheckoutPage1(driver);
        checkoutPage2 = checkoutPage1.goToCheckoutPage2("Leonardo", "DiCaprio", "XYZ", driver);
    }

    @Test
    @DisplayName("Check that checkoutPage2 link is correct")
    void checkThatCheckoutPage2LinkIsCorrect() {
        assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutPage2.getUrl());
    }

    @Test
    @DisplayName("Check cancel button returns to HomePage")
    void checkCancelButtonReturnsToHomePage() {
        homePage = checkoutPage2.goToCancel(driver);
        assertEquals("https://www.saucedemo.com/inventory.html", homePage.getUrl());
    }

    @Test
    @DisplayName("Check finish shopping button goes to CheckoutComplete page")
    void checkFinishButtonReturnsToCheckoutCompletePage() {
        checkoutCompletePage = checkoutPage2.goToFinish(driver);
        assertEquals("https://www.saucedemo.com/checkout-complete.html", checkoutCompletePage.getUrl());
    }

    @Test
    @DisplayName("Check that correct amount of items in cart")
    void checkThatCorrectAmountOfItemsInCart() {
        cartPage = homePage.gotoCartPage(driver);
        homePage.addBikeLightToCart();
        homePage.addBoltTShirtToCart();
        Assertions.assertEquals(2, checkoutPage2.listOfItems().size());
    }

    @Test
    @DisplayName("Check that clicking the cart icon takes you to the Cart page")
    void checkThatClickingTheCartIconTakesYouToTheCartPage() {
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", checkoutPage2.getUrlFromCartLink());
    }

    @Nested
    class SidebarTests{

        @Test
        @DisplayName("Check that the all items sidebar goes to homepage ")
        void checkThatTheAllItemsSidebarGoesToHomepage() {
            assertEquals("https://www.saucedemo.com/inventory.html", checkoutPage2.getURLFromAllItemsSidebarLink());
        }

        @Test
        @DisplayName("Check that the about sidebar link works")
        void checkThatTheAboutSidebarLinkWorks() {
            assertEquals("https://saucelabs.com/", checkoutPage2.getURLFromAboutSidebarLink());
        }

        @Test
        @DisplayName("Check that the logout sidebar link take you to the login page")
        void checkThatTheLogoutSidebarLinkTakeYouToTheLoginPage() {
            assertEquals("https://www.saucedemo.com/", checkoutPage2.getUrlFromLogoutSidebarLink());
        }

        @Test
        @DisplayName("Check that the reset app state sidebar link from homepage give correct url")
        void checkThatTheResetAppStateSidebarLinkGiveTheSameUrl() {
            assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutPage2.getUrlFromResetAppStateSidebarLink() );
        }

        @Test
        @DisplayName("Check that the reset app state sidebar link from the cart page stays on the same url")
        void checkThatTheResetAppStateSidebarLinkFromTheCartPageStaysOnTheSameUrl() {
            assertEquals("https://www.saucedemo.com/cart.html", checkoutPage2.goToCheckoutPageFromCartIcon().getUrlFromResetAppStateSidebarLink());
        }
    }

    @AfterAll
    static void tearDownAll() {
        //driver.quit();
    }
}
