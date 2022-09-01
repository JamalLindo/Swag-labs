package com.sparta.jl.pom.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CheckoutPage1 extends NavigationPage {
    WebDriver driver;

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");

    public CheckoutPage1(WebDriver driver) {
        this.driver = driver;
        setDriver(driver);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public CheckoutPage2 goToCheckoutPage2(String firstNameInput, String lastNameInput, String postalCodeInput) {
        driver.findElement(firstName).sendKeys(firstNameInput, Keys.TAB, lastNameInput, Keys.TAB, postalCodeInput, Keys.ENTER);
        return new CheckoutPage2();
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
    public String getURLFromTwitterLink() {
        return super.getURLFromTwitterLink();
    }

    @Override
    public String getURLFromFacebookLink() {
        return super.getURLFromFacebookLink();
    }

    @Override
    public String getURLFromLinkedinLink() {
        return super.getURLFromLinkedinLink();
    }

    @Override
    public String getURLFromAboutLink() {
        return super.getURLFromAboutLink();
    }

    @Override
    public LoginPage goToLoginPageFromSidebar() {
        return super.goToLoginPageFromSidebar();
    }

    @Override
    public String getUrlFromLogoutSideBar() {
        return super.getUrlFromLogoutSideBar();
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
