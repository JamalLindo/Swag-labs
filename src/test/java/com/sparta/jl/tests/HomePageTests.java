package com.sparta.jl.tests;

import com.sparta.jl.pom.POMUtils;
import com.sparta.jl.pom.drivers.DriverFactory;
import com.sparta.jl.pom.drivers.DriverOptions;
import com.sparta.jl.pom.pages.HomePage;
import com.sparta.jl.pom.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class HomePageTests {
    private static WebDriver driver;
    private static HomePage homePage;
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
    }

    @Test
    @DisplayName("Products are sorted price ascending when sort by is price ascending")
    void productsAreSortedPriceAscendingWhenSortByIsPriceAscending(){
        Assertions.assertTrue(homePage.sortProductsByPriceAscending().isPriceAscending());
    }
    
    @Test
    @DisplayName("Products are sorted price ascending when sort by is price ascending")
    void productsAreSortedPriceDescendingWhenSortByIsPriceDescending(){
        Assertions.assertTrue(homePage.sortProductsByPriceDescending().isPriceDescending());
    }
    
    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }
}
