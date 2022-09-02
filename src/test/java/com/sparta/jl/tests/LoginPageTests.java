package com.sparta.jl.tests;

import com.sparta.jl.pom.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTests {
    private static WebDriver driver;
    private static LoginPage loginPage;

    @BeforeAll
    static void setupAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setup() {
        driver.get("https://www.saucedemo.com/");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }
/*
    @Test
    @DisplayName("Check that the login to home page works")
    void checkThatTheLoginToHomePageWorks(){
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", loginPage.goToHomePage().getUrl());
    }

    @Test
    @DisplayName("Check that login to problem user returns a home page")
    void checkThatLoginToProblemUserReturnsAHomePage(){
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", loginPage.goToProblemHomePage().getUrl());
    }

    @Test
    @DisplayName("Check that glitched user works")
    void checkThatGlitchedUserWorks(){
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", loginPage.performanceGlitchedUserLogin().getUrl());
    }

 */

    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }
}
