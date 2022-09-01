package com.sparta.jl.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class LoginPage {
    private WebDriver driver;
    private static final String password = "secret_sauce";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToPage(String userName){
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
    public HomePage goToHomePage() {
        loginToPage("standard_user");
        return new HomePage();
    }

    public HomePage goToProblemHomePage() {
        loginToPage("problem_user");
        return new HomePage();
    }

    public HomePage performanceGlitchedUserLogin() {
        loginToPage("performance_glitch_user");
        return new HomePage();
    }

    public String lockedOutLogin() {
        loginToPage("locked_out_user");
        return driver.findElement(By.className("error-message-container error")).getText();
    }

    public String invalidLogin() {
        String inputtedUserName = "incorrect_user";
        String[] userNames = new String[] {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user"};
        boolean containsValidUserName = Arrays.asList(userNames).contains(inputtedUserName);
        if (containsValidUserName) {
            loginToPage(inputtedUserName);
        }
        return driver.findElement(By.className("error-message-container error")).getText();
    }
}