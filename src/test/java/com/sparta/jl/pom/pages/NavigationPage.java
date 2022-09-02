package com.sparta.jl.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public abstract class NavigationPage {

    private static WebDriver driver;
    private static final By twitterSocial = new By.ByClassName("social_twitter");
    private static final By facebookSocial = new By.ByClassName("social_facebook");
    private static final By linkedinSocial = new By.ByClassName("social_linkedin");
    private static final By burgerMenuBtn = new By.ById("react-burger-menu-btn");
    private static final By allItemsSidebarLink = new By.ById("inventory_sidebar_link");
    private static final By aboutSidebarLink = new By.ById("about_sidebar_link");
    private static final By logoutSidebarLink = new By.ById("logout_sidebar_link");
    private static final By resetSideBarLink = new By.ById("reset_sidebar_link");
    private static final By shoppingCartLink = new By.ByClassName("shopping_cart_link");
    private static final By footerImage = new By.ByClassName("footer_robot");

    private static final By shoppingCartBadge = new By.ByClassName("shopping_cart_badge");


    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private void switchToOpenedTab(By locator) {
        String originalTab = driver.getWindowHandle();
        driver.findElement(locator).click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String tab : windowHandles) {
            if (!originalTab.equals(tab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }

    public String getUrlFromTwitterLink() {
        switchToOpenedTab(twitterSocial);
        return driver.getCurrentUrl();
    }

    public String getUrlFromFacebookLink() {
        switchToOpenedTab(facebookSocial);
        return driver.getCurrentUrl();
    }

    public String getUrlFromLinkedinLink() {
        switchToOpenedTab(linkedinSocial);
        return driver.getCurrentUrl();
    }

    public String getWindowHandleOfOpenedTwitterTab() {
        switchToOpenedTab(twitterSocial);
        return driver.getWindowHandle();
    }

    public String getWindowHandleOfOpenedFacebookTab() {
        switchToOpenedTab(facebookSocial);
        return driver.getWindowHandle();
    }

    public String getWindowHandleOfOpenedLinkedinTab() {
        switchToOpenedTab(linkedinSocial);
        return driver.getWindowHandle();
    }

    public String getURLFromAboutSidebarLink() {
        driver.findElement(burgerMenuBtn).click();
        driver.findElement(aboutSidebarLink).click();
        return driver.getCurrentUrl();
    }

    public LoginPage goToLoginPageFromSidebar() {
        driver.findElement(burgerMenuBtn).click();
        driver.findElement(logoutSidebarLink).click();
        return new LoginPage(driver);
    }

    public String getUrlFromLogoutSidebarLink() {
        goToLoginPageFromSidebar();
        return driver.getCurrentUrl();
    }

    public HomePage goToHomePageFromAllItemsSidebarLink() {
        driver.findElement(burgerMenuBtn).click();
        driver.findElement(allItemsSidebarLink).click();
        return new HomePage(driver);
    }

    public String getURLFromAllItemsSidebarLink() {
        goToHomePageFromAllItemsSidebarLink();
        return driver.getCurrentUrl();
    }

    public CartPage goToCheckoutPageFromCartIcon() {
        driver.findElement(shoppingCartLink).click();
        return new CartPage(driver);
    }

    public NavigationPage goToResetAppStateSideBarLink() {
        driver.findElement(burgerMenuBtn).click();
        driver.findElement(resetSideBarLink).click();
        return this;

    }

    public String getUrlFromResetAppStateSidebarLink() {
        goToResetAppStateSideBarLink();
        return driver.getCurrentUrl();
    }

    public String getUrlFromCartLink() {
        goToCheckoutPageFromCartIcon();
        return driver.getCurrentUrl();
    }

    public String getBadgeFromShoppingCartIcon() {
        return driver.findElement(shoppingCartBadge).getText();
    }

    public String getSourceOfFooterImage() {
        return driver.findElement(footerImage).getAttribute("src");
    }

}
