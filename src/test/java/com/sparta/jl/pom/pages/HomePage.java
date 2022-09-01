package com.sparta.jl.pom.pages;


public class HomePage extends NavigationPage{

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends NavigationPage {
    private WebDriver driver;

    private final By prices = new By.ByClassName("inventory_item_price");
    private final By title = new By.ByClassName("title");
    private final By productNames = new By.ByClassName("inventory_item_name");
    private final By productDescriptions = new By.ByClassName("inventory_item_desc");

    private final By addToCartRedTShirtButton = new By.ById("add-to-cart-test.allthethings()-t-shirt-(red)");
    private final By addToCartOnesieButton = new By.ById("add-to-cart-sauce-labs-onesie");
    private final By addToCartFleeceJacketButton = new By.ById("add-to-cart-sauce-labs-fleece-jacket");
    private final By addToCartBoltTShirtButton = new By.ById("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By addToCartBikeLightButton = new By.ById("add-to-cart-sauce-labs-bike-light");
    private final By addToCartBackpackButton = new By.ById("add-to-cart-sauce-labs-backpack");

    private final By removeFromCartRedTShirtButton = new By.ById("remove-test.allthethings()-t-shirt-(red)");
    private final By removeFromCartOnesieButton = new By.ById("remove-sauce-labs-onesie");
    private final By removeFromCartFleeceJacketButton = new By.ById("remove-sauce-labs-fleece-jacket");
    private final By removeFromCartBoltTShirtButton = new By.ById("remove-sauce-labs-bolt-t-shirt");
    private final By removeFromCartBikeLightButton = new By.ById("remove-sauce-labs-bike-light");
    private final By removeFromCartBackpackButton = new By.ById("remove-sauce-labs-backpack");

    private final By productSortByMenu = new By.ByClassName("product_sort_container");
    private final By sortByNameAZ = new By.ByCssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(1)");
    private final By sortByNameZA = new By.ByCssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(2)");
    private final By sortByPriceLowHigh = new By.ByCssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(3)");
    private final By sortByPriceHighLow = new By.ByCssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(4)");
    private final By shoppingCartLink = new By.ByClassName("shopping_cart_link");
    private final By shoppingCartAmountBadge = new By.ByClassName("shopping_cart_badge");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addRedTShirtToCart() {
        driver.findElement(addToCartRedTShirtButton).click();
        System.out.println(driver.findElement(shoppingCartAmountBadge).getText());
    }
    public void addOnesieToCart() {
        driver.findElement(addToCartOnesieButton).click();
    }
    public void addFleeceJacketToCart() {
        driver.findElement(addToCartFleeceJacketButton).click();
    }
    public void addBoltTShirtToCart() {
        driver.findElement(addToCartBoltTShirtButton).click();
    }
    public void addBikeLightToCart() {
        driver.findElement(addToCartBikeLightButton).click();
    }
    public void addBackpackToCart() { driver.findElement(addToCartBackpackButton).click(); }

    public void removeRedTShirtFromCart() {
        driver.findElement(removeFromCartRedTShirtButton).click();
    }
    public void removeOnesieFromCart() {
        driver.findElement(removeFromCartOnesieButton).click();
    }
    public void removeFleeceJacketFromCart() {
        driver.findElement(removeFromCartFleeceJacketButton).click();
    }
    public void removeBoltTShirtFromCart() {
        driver.findElement(removeFromCartBoltTShirtButton).click();
    }
    public void removeBikeLightFromCart() {
        driver.findElement(removeFromCartBikeLightButton).click();
    }
    public void removeBackpackFromCart() { driver.findElement(removeFromCartBackpackButton).click(); }

}
