package com.sparta.jl.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class LoginPage {
    private WebDriver driver;
    private static final String password = "secret_sauce";
    private By errorMessage = By.className("error-message-container");
    private By pageUserName = By.id("user-name");
    private By pagePassword = By.id("password");
    private By loginButton = By.id("login-button");



    public LoginPage(WebDriver driver) {
        driver.get("https://www.saucedemo.com/");
        this.driver = driver;
    }

    public void loginToPage(String userName){
        driver.findElement(By.id("user-name")).sendKeys(userName, Keys.TAB, password, Keys.ENTER);
//        driver.findElement(pagePassword).sendKeys(password);
//        driver.findElement(loginButton).click();
    }
    public HomePage goToHomePage() {
        loginToPage("standard_user");
        return new HomePage(driver);
    }

    public HomePage goToProblemHomePage() {
        loginToPage("problem_user");
        return new HomePage(driver);
    }

    public HomePage performanceGlitchedUserLogin() {
        loginToPage("performance_glitch_user");
        return new HomePage(driver);
    }

    public String lockedOutLogin() {
        loginToPage("locked_out_user");
        return driver.findElement(errorMessage).getText();
    }

    public String invalidLogin() {
        String inputtedUserName = "incorrect_user";
        String[] userNames = new String[] {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user"};
        boolean containsValidUserName = Arrays.asList(userNames).contains(inputtedUserName);
        if (containsValidUserName) {
            loginToPage(inputtedUserName);
        }
        return driver.findElement(By.className("error-message-container")).getAttribute("data-test");
    }
}