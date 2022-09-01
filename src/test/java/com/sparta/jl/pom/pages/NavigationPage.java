package com.sparta.jl.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public abstract class NavigationPage {

    private static WebDriver driver;
    private static final By twitterSocial = new By.ByClassName("social_twitter");
    private static final By facebookSocial = new By.ByClassName("social_facebook");
    private static final By linkedinSocial = new By.ByClassName("social_linkedin");
    private static final By allItemsSidebarLink = new By.ById("inventory_sidebar_link");
    private static final By aboutSidebarLink = new By.ById("about_sidebar_link");
    private static final By logoutSidebarLink = new By.ById("logout_sidebar_link");
    private static final By resetSideBarLink = new By.ById("reset_sidebar_link");
    private static final By shoppingCartLink = new By.ByClassName("shopping_cart_link");
    private static final By footerImage = new By.ByClassName("footer_robot");


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

    public String getURLFromTwitterLink() {
        switchToOpenedTab(twitterSocial);
        return driver.getCurrentUrl();
    }

    public String getURLFromFacebookLink() {
        switchToOpenedTab(facebookSocial);
        return driver.getCurrentUrl();
    }

    public String getURLFromLinkedinLink() {
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

    public String getURLFromAboutLink(){
        driver.findElement(aboutSidebarLink).click();
        return driver.getCurrentUrl();
    }

    public LoginPage goToLoginPageFromSidebar(){
        driver.findElement(logoutSidebarLink).click();
        return new LoginPage();
        //return new LoginPage(driver);
    }

    public String getUrlFromLogoutSideBar() {
       goToLoginPageFromSidebar();
        return driver.getCurrentUrl();
    }

    public CheckoutPage goToCheckoutPageFromCartIcon() {
        driver.findElement(shoppingCartLink).click();
        return new CheckoutPage();
        //return new CheckoutPage(driver);
    }

    public String getUrlFromCartLink() {
        goToCheckoutPageFromCartIcon();
        return driver.getCurrentUrl();
    }

    public String getSourceOfFooterImage(){
        return driver.findElement(footerImage).getAttribute("src");
    }

}
