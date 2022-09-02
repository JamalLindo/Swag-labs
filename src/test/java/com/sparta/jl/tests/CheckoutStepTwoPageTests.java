package com.sparta.jl.tests;

import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.drivers.DriverFactory;
import com.sparta.jl.pom.drivers.DriverOptions;
import com.sparta.jl.pom.pages.CartPage;
import com.sparta.jl.pom.pages.CheckoutPage.CheckoutCompletePage;
import com.sparta.jl.pom.pages.CheckoutPage.CheckoutStepOnePage;
import com.sparta.jl.pom.pages.CheckoutPage.CheckoutStepTwoPage;
import com.sparta.jl.pom.pages.HomePage;
import com.sparta.jl.pom.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutStepTwoPageTests {
    static WebDriver driver;
    private HomePage homePage;
    private CheckoutStepTwoPage checkoutStepTwoPage;
    private CheckoutStepOnePage checkoutStepOnePage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";


    @BeforeAll
    static void setupAll() {
        POMUtils.setDriverLocation(DRIVER_LOCATION);
        driver = DriverFactory.getDriver(DriverOptions.CHROME);
    }

    @BeforeEach
    void setup() {
        LoginPage loginPage = new LoginPage(driver);
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
        CheckoutCompletePage checkoutCompletePage = checkoutStepTwoPage.goToFinish(driver);
        assertEquals("https://www.saucedemo.com/checkout-complete.html", checkoutCompletePage.getUrl());
    }

    @Test
    @DisplayName("Check that correct amount of items in cart")
    void checkThatCorrectAmountOfItemsInCart() {
        CartPage cartPage = homePage.gotoCartPage(driver);
        Assertions.assertEquals(0, checkoutStepTwoPage.listOfItems().size());
    }

    @Test
    @DisplayName("Check that clicking the cart icon takes you to the Cart page")
    void checkThatClickingTheCartIconTakesYouToTheCartPage() {
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", checkoutStepTwoPage.getUrlFromCartLink());
    }

    @Nested
    class SidebarTests{

        @Test
        @DisplayName("Check that the all items sidebar goes to homepage ")
        void checkThatTheAllItemsSidebarGoesToHomepage() {
            assertEquals("https://www.saucedemo.com/inventory.html", checkoutStepTwoPage.getURLFromAllItemsSidebarLink());
        }

        @Test
        @DisplayName("Check that the about sidebar link works")
        void checkThatTheAboutSidebarLinkWorks() {
            assertEquals("https://saucelabs.com/", checkoutStepTwoPage.getURLFromAboutSidebarLink());
        }

        @Test
        @DisplayName("Check that the logout sidebar link take you to the login page")
        void checkThatTheLogoutSidebarLinkTakeYouToTheLoginPage() {
            assertEquals("https://www.saucedemo.com/", checkoutStepTwoPage.getUrlFromLogoutSidebarLink());
        }

        @Test
        @DisplayName("Check that the reset app state sidebar link from homepage give correct url")
        void checkThatTheResetAppStateSidebarLinkGiveTheSameUrl() {
            assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutStepTwoPage.getUrlFromResetAppStateSidebarLink() );
        }

        @Test
        @DisplayName("Check that the reset app state sidebar link from the cart page stays on the same url")
        void checkThatTheResetAppStateSidebarLinkFromTheCartPageStaysOnTheSameUrl() {

            assertEquals("https://www.saucedemo.com/cart.html", checkoutStepTwoPage.goToCheckoutPageFromCartIcon().getUrlFromResetAppStateSidebarLink());
        }
    }

    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }
}
