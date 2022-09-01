package com.sparta.jl.pom.pages.CheckoutPage;

import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
