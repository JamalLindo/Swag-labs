package com.sparta.jl.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckoutPage{
    WebDriver driver;

    By burgerMenu = new By.ById("react-burger-menu-btn");
    By inventorySidebarLink = new By.ById("react-burger-menu-btn");
    By continueShoppingBtn = new By.ById("continue-shopping");
    By inventoryItemName = new By.ById("inventory_item_name");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;

        //remove after driver can be passed
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/cart.html"); //remove this after
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
    public HomePage gotoContinueShopping(WebDriver driver) {
        driver.findElement(continueShoppingBtn).click();
//        System.out.println(driver.getCurrentUrl());
//        return null;
        return new HomePage(driver);
    }

    public List listOfItems() {
        List<WebElement> items = driver.findElements();
        return items;
    }

    public List listOfRemoveItemBtn() {
        List<WebElement> removeBtns = driver.findElements(By)
    }


//    public HomePage gotoAllItemsPage(WebDriver driver) {
//        driver.findElement(burgerMenu).click();
//        driver.findElement(inventorySidebarLink).click();
//        return new HomePage(driver);
//    }




}
