package com.sparta.jl.pom.pages.CheckoutPage;

import com.sparta.jl.pom.pages.CartPage;
import com.sparta.jl.pom.pages.HomePage;
import com.sparta.jl.pom.pages.LoginPage;
import com.sparta.jl.pom.pages.NavigationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CheckoutPage1 extends NavigationPage {
    WebDriver driver;

    private static final By firstName = By.id("first-name");
    private static final By lastName = By.id("last-name");
    private static final By postalCode = By.id("postal-code");
    private static final By checkoutBtn = new By.ById("checkout");
    private static final By shoppingCartLink = new By.ByClassName("shopping_cart_link");
    private static final By cancelButton = new By.ById("cancel");
    private static final By continueButton = By.id("continue");

    public CheckoutPage1(WebDriver driver) {
        this.driver = driver;
        driver.findElement(shoppingCartLink).click();
        driver.findElement(checkoutBtn).click();
        setDriver(driver);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public CartPage cancelCheckout(WebDriver driver) {
        driver.findElement(cancelButton).click();
        return new CartPage(driver);
    }

    public CheckoutPage2 goToCheckoutPage2() {
        driver.findElement(firstName).sendKeys("Alice");
        driver.findElement(lastName).sendKeys("Bob");
        driver.findElement(postalCode).sendKeys("123");
        driver.findElement(continueButton).click();
        return new CheckoutPage2(driver);
    }

    public String emptyFields() {
        if (driver.findElement(firstName).getText().isEmpty()) {
            return driver.findElement(By.id("error-message-container")).getText();
        } else if (driver.findElement(lastName).getText().isEmpty()) {
            return driver.findElement(By.id("error-message-container")).getText();
        } else if (driver.findElement(postalCode).getText().isEmpty()) {
            return driver.findElement(By.id("error-message-container")).getText();
        } else {
            return "good to go";
        }
    }

    @Override
    public CartPage goToCheckoutPageFromCartIcon() {
        return super.goToCheckoutPageFromCartIcon();
    }

    @Override
    public String getUrlFromCartLink() {
        return super.getUrlFromCartLink();
    }
}