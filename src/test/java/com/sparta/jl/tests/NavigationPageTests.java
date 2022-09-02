package com.sparta.jl.tests;


import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.pages.HomePage;
import com.sparta.jl.pom.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationPageTests {

    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    private static LoginPage loginPage;
    static WebDriver driver;
    static HomePage homePage;

    @BeforeAll
    static void setupAll() {

        POMUtils.setDriverLocation(DRIVER_LOCATION);
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setup() {
        loginPage = new LoginPage(driver);
        homePage = loginPage.goToHomePage();
    }

    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }

    @Nested
    class FooterTests {

        @Test
        @DisplayName("Check that the Facebook link is correct")
        void checkThatTheFacebookLinkIsCorrect() {
            Assertions.assertEquals("https://www.facebook.com/saucelabs", homePage.getUrlFromFacebookLink());
        }

        @Test
        @DisplayName("Check that the twitter link is correct")
        void checkThatTheTwitterLinkIsCorrect() {
            Assertions.assertEquals("https://twitter.com/saucelabs", homePage.getUrlFromTwitterLink());
        }

        @Test
        @DisplayName("Check that the twitter link opens a new tab")
        void checkThatTheTwitterLinkOpensANewTab() {
            Assertions.assertNotEquals(driver.getWindowHandle(), homePage.getWindowHandleOfOpenedTwitterTab());
        }

        @Test
        @DisplayName("Check that the facebook link opens a new tab")
        void checkThatTheFacebookLinkOpensANewTab() {
            Assertions.assertNotEquals(driver.getWindowHandle(), homePage.getWindowHandleOfOpenedFacebookTab());
        }

        @Test
        @DisplayName("Check that the linkedin link opens a new tab")
        void checkThatTheLinkedinLinkOpensANewTab() {
            Assertions.assertNotEquals(driver.getWindowHandle(), homePage.getWindowHandleOfOpenedLinkedinTab());
        }

        @Test
        @DisplayName("Check that the footer img is the correct src")
        void checkThatTheFooterImgIsTheCorrectSrc() {
            Assertions.assertEquals("https://www.saucedemo.com/static/media/SwagBot_Footer_graphic.2e87acec.png", homePage.getSourceOfFooterImage());
        }
    }

    @Nested
    class SidebarTests {

        @Test
        @DisplayName("Check that the about sidebar link works")
        void checkThatTheAboutSidebarLinkWorks() {
            Assertions.assertEquals("https://saucelabs.com/", homePage.getURLFromAboutSidebarLink());
        }

        @Test
        @DisplayName("Check that the all items Side bar goes to homepage ")
        void checkThatTheAllItemsSideBarGoesToHomepage() {
            Assertions.assertEquals("https://www.saucedemo.com/inventory.html", homePage.getURLFromAllItemsSidebarLink());
        }

        @Test
        @DisplayName("Check that the logout sidebar link take you to the login page")
        void checkThatTheLogoutSidebarLinkTakeYouToTheLoginPage() {
            Assertions.assertEquals("https://www.saucedemo.com/", homePage.getUrlFromLogoutSidebarLink());
        }

        @Test
        @DisplayName("Check that the reset app state sidebar link from homepage give correct url")
        void checkThatTheResetAppStateSidebarLinkGiveTheSameUrl() {
            Assertions.assertEquals("https://www.saucedemo.com/inventory.html", homePage.getUrlFromResetAppStateSidebarLink());
        }

        @Test
        @DisplayName("Check that the reset app state sidebar link from the cart page stays on the same url")
        void checkThatTheResetAppStateSidebarLinkFromTheCartPageStaysOnTheSameUrl() {
            Assertions.assertEquals("https://www.saucedemo.com/cart.html", homePage.goToCheckoutPageFromCartIcon().getUrlFromResetAppStateSidebarLink());
        }

        @Test
        @DisplayName("Check that the reset app state removes cart badge")
        void checkThatTheResetAppStateRemovesCartBadge() {
            Assertions.assertThrows(NoSuchElementException.class, () -> homePage.addBikeLightToCart().goToResetAppStateSideBarLink().getBadgeFromShoppingCartIcon());
        }

        @Nested
        class CartIcon {

            @Test
            @DisplayName("Check that clicking the cart icon takes you to the Cart page")
            void checkThatClickingTheCartIconTakesYouToTheCartPage() {
                Assertions.assertEquals("https://www.saucedemo.com/cart.html", homePage.getUrlFromCartLink());
            }
        }
    }
}
