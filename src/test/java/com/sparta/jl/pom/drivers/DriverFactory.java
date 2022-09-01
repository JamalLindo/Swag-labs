package com.sparta.jl.pom.drivers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    private static ChromeDriver chromeDriver;
    private static SafariDriver safariDriver;
    private static FirefoxDriver firefoxDriver;

    public static WebDriver getDriver(DriverOptions driverOptions) {
        if (driverOptions.equals(DriverOptions.CHROME)) {
            chromeDriver = new ChromeDriver();
            return chromeDriver;

        } else if (driverOptions.equals(DriverOptions.SAFARI)) {
            safariDriver = new SafariDriver();
            return safariDriver;

        } else if(driverOptions.equals(DriverOptions.FIREFOX)) {
            firefoxDriver = new FirefoxDriver();
            return firefoxDriver;

        } else if (driverOptions.equals(DriverOptions.FIREFOX_IPHONE13)) {
            firefoxDriver.manage().window().setSize(new Dimension(390, 844));
            return firefoxDriver;
        }

        return null;
    }
}
