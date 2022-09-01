package com.sparta.jl.tests;

import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.pages.HomePage;
import com.sparta.jl.pom.pages.LoginPage;
import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        @DisplayName("Check that the twitter link opens on a new tab")
        void checkThatTheTwitterLinkOpensOnANewTab() {

        }

        @Test
        @DisplayName("Check that the Facebook link is correct")
        void checkThatTheFacebookLinkIsCorrect() {
            Assertions.assertEquals("https://www.facebook.com/saucelabs", homePage.getURLFromFacebookLink());

        }

        @Test
        @DisplayName("Check that the Linkedin link is correct")
        void checkThatTheLinkedinLinkIsCorrect() {
            Assertions.assertEquals("https://www.linkedin.com/company/sauce-labs/", homePage.getURLFromLinkedinLink());

        }

        @Test
        @DisplayName("Check that the twitter link is correct")
        void checkThatTheTwitterLinkIsCorrect() {
            Assertions.assertEquals("https://twitter.com/saucelabs", homePage.getURLFromTwitterLink());

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
    }

    @Nested
    class SidebarTests{

        @Test
        @DisplayName("Check that the about sidebar link works")
        void checkThatTheAboutSidebarLinkWorks() {
            Assertions.assertEquals("https://saucelabs.com/", homePage.getURLFromAboutLink());
        }

    }




}
