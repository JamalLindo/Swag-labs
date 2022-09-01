package com.sparta.jl.pom.pages.CheckoutPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage2 {
    private WebDriver driver;

    By cancelButton = new By.ById("cancel");
    By finishButton = new By.ById("finish");

    By inventorySidebarLink = new By.ById("react-burger-menu-btn");

    By inventoryItemName = new By.ByClassName("inventory_item_name");

    By itemTotal = new By.ByClassName("summary_subtotal_label");
    By tax = new By.ByClassName("summary_tax_label");
    By total = new By.ByClassName("summary_total_label");


    public CheckoutPage2(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }


    public List listOfItems() {
        List<WebElement> items = driver.findElements(inventoryItemName);
        return items;
    }



}
