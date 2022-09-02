package com.sparta.jl.tests;
import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.drivers.DriverFactory;
import com.sparta.jl.pom.drivers.DriverOptions;
import com.sparta.jl.pom.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
public class LoginPageTests {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    @BeforeAll
    static void setupAll() {
        POMUtils.setDriverLocation(DRIVER_LOCATION);
        driver = DriverFactory.getDriver(DriverOptions.CHROME);
    }
    @BeforeEach
    void setup() {
        driver.get("https://www.saucedemo.com/");
        driver = DriverFactory.getDriver(DriverOptions.CHROME);
        loginPage = new LoginPage(driver);
    }
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
    @AfterAll
    static void tearDownAll() {
       driver.quit();
    }
}