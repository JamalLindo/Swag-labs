package com.sparta.jl.pom.pages.CheckoutPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver driver;
    private static final By shoppingCartLink = new By.ByClassName("shopping_cart_link");
    private static final By checkoutBtn = new By.ById("checkout");
    private static final By firstName = By.id("first-name");
    private static final By lastName = By.id("last-name");
    private static final By postalCode = By.id("postal-code");
    private static final By continueBtn = new By.ById("continue");
    private static final By finishButton = new By.ById("finish");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(shoppingCartLink).click();
        driver.findElement(checkoutBtn).click();
        driver.findElement(firstName).sendKeys("Leonardo");
        driver.findElement(lastName).sendKeys("DiCaprio");
        driver.findElement(postalCode).sendKeys("XYZ");
        driver.findElement(continueBtn).click();
        driver.findElement(finishButton).click();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
