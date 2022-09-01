package com.sparta.jl.tests;

import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.pages.HomePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTests {
    private static WebDriver driver;
    private HomePage homePage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    @BeforeAll
    static void setupAll() {
        POMUtils.setDriverLocation(DRIVER_LOCATION);
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }

    @Test
    @DisplayName("test")
    void test(){
        homePage.addRedTShirtToCart();
    }
}
