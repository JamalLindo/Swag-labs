package com.sparta.jl.pom.pages.CheckoutPage;

import com.sparta.jl.pom.pages.CartPage;
import com.sparta.jl.pom.pages.HomePage;
import com.sparta.jl.pom.pages.LoginPage;
import com.sparta.jl.pom.pages.NavigationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutStepTwoPage extends NavigationPage {
    private WebDriver driver;
    private HomePage homePage;
    private static final By checkoutBtn = new By.ById("checkout");
    private static final By firstName = By.id("first-name");
    private static final By lastName = By.id("last-name");
    private static final By postalCode = By.id("postal-code");
    private static final By continueBtn = new By.ById("continue");

    private static final By cancelButton = new By.ById("cancel");
    private static final By finishButton = new By.ById("finish");
    private static final By cartItem = new By.ByClassName("cart_item");
    private static final By burgerMenuBtn = new By.ById("react-burger-menu-btn");
    private static final By allItemsSidebarLink = new By.ById("inventory_sidebar_link");
    private static final By aboutSidebarLink = new By.ById("about_sidebar_link");
    private static final By logoutSidebarLink = new By.ById("logout_sidebar_link");
    private static final By resetAppStateSidebarLink = new By.ById("reset_sidebar_link");
    private static final By shoppingCartLink = new By.ByClassName("shopping_cart_link");

    private static final By itemTotal = new By.ByClassName("summary_subtotal_label");
    private static final By tax = new By.ByClassName("summary_tax_label");
    private static final By total = new By.ByClassName("summary_total_label");

    public CheckoutStepTwoPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(shoppingCartLink).click();
        driver.findElement(checkoutBtn).click();

        driver.findElement(firstName).sendKeys("Leonardo");
        driver.findElement(lastName).sendKeys("DiCaprio");
        driver.findElement(postalCode).sendKeys("XYZ");
        driver.findElement(continueBtn).click();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public HomePage goToCancel(WebDriver driver) {
        driver.findElement(cancelButton).click();
        return new HomePage(driver);
    }

    public CheckoutCompletePage goToFinish(WebDriver driver) {
        driver.findElement(finishButton).click();
        return new CheckoutCompletePage(driver);
    }

    public CartPage goToCheckoutPageFromCartIcon() {
        driver.findElement(shoppingCartLink).click();
        return new CartPage(driver);
    }

    public List listOfItems() {
        List<WebElement> items = driver.findElements(cartItem);
        return items;
    }

    public HomePage goToHomePageFromAllItemsSidebarLink() {
        driver.findElement(burgerMenuBtn).click();
        driver.findElement(allItemsSidebarLink).click();
        return new HomePage(driver);
    }

    public String getURLFromAboutSidebarLink(){
        driver.findElement(burgerMenuBtn).click();
        driver.findElement(aboutSidebarLink).click();
        return driver.getCurrentUrl();
    }

    public LoginPage goToLoginPageFromSidebar(){
        driver.findElement(burgerMenuBtn).click();
        driver.findElement(logoutSidebarLink).click();
        return new LoginPage(driver);
    }

    public String getUrlFromLogoutSidebarLink() {
        driver.findElement(burgerMenuBtn).click();
        driver.findElement(logoutSidebarLink).click();
        return driver.getCurrentUrl();
    }

    public String getURLFromAllItemsSidebarLink(){
        driver.findElement(burgerMenuBtn).click();
        driver.findElement(allItemsSidebarLink).click();
        return driver.getCurrentUrl();
    }

    public String getUrlFromResetAppStateSidebarLink(){
        driver.findElement(burgerMenuBtn).click();
        driver.findElement(resetAppStateSidebarLink).click();
        return driver.getCurrentUrl();
    }
}
