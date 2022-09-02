package com.sparta.jl.pom.pages;

import com.sparta.jl.pom.pages.CheckoutPage.CheckoutStepOnePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class CartPage extends NavigationPage{
    WebDriver driver;
    final By continueShoppingBtn = new By.ById("continue-shopping");
    final By checkoutBtn = new By.ById("checkout");
    final By cartItem = new By.ByClassName("cart_item");
    final By inventoryItemName = new By.ByClassName("inventory_item_name");
    final By removeButton = new By.ByCssSelector(".btn.btn_secondary.btn_small.cart_button");
    final By removeBackpack = new By.ById("remove-sauce-labs-backpack");
    final By removeBikeLight = new By.ById("remove-sauce-labs-bike-light");
    final By removeBoltTShirt = new By.ById("remove-sauce-labs-bolt-t-shirt");
    final By removeFleeceJacket = new By.ById("remove-sauce-labs-fleece-jacket");
    final By removeOnesie = new By.ById("remove-sauce-labs-onesie");
    final By removeRedTShirt = new By.ById("remove-test.allthethings()-t-shirt-(red)");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        setDriver(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public HomePage clickContinueShopping(WebDriver driver) {
        driver.findElement(continueShoppingBtn).click();
        return new HomePage(driver);
    }

    public CheckoutStepOnePage clickCheckout(WebDriver driver) {
        driver.findElement(checkoutBtn).click();
        return new CheckoutStepOnePage(driver);
    }

    public List listOfItems() {
        List<WebElement> items = driver.findElements(cartItem);
        return items;
    }

    public void removeBackpack() {
        driver.findElement(removeBackpack).click();
    }

    public void removeAllItems() {
        driver.findElement(removeBackpack).click();
        driver.findElement(removeBikeLight).click();
        driver.findElement(removeBoltTShirt).click();
        driver.findElement(removeFleeceJacket).click();
        driver.findElement(removeOnesie).click();
        driver.findElement(removeRedTShirt).click();
    }
    
  public List listOfRemoveItemBtn() {
      List<WebElement> removeBtns = driver.findElements(removeButton);
      return removeBtns;
  }

  public List listOfItemNames() {
        List<WebElement> items = listOfItems();
        List<String> itemNames = new ArrayList<>();
      for (int i = 0; i < items.size(); i++) {
          itemNames.add(items.get(i).findElement(inventoryItemName).getText());
      }
        return itemNames;
  }
}
