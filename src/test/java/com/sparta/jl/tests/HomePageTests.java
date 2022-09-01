package com.sparta.jl.tests;

import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.pages.HomePage;
import com.sparta.jl.pom.pages.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTests {
    private static WebDriver driver;
    private static HomePage homePage;
    private static LoginPage loginPage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    @BeforeAll
    static void setupAll() {
        POMUtils.setDriverLocation(DRIVER_LOCATION);
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = loginPage.goToHomePage();
    }

    @BeforeEach
    void setup() {

    }

    @Test
    @DisplayName("test")
    void test(){
    }
}
