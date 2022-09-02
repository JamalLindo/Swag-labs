package com.sparta.jl.pom;

public class POMUtils {
    public static void setDriverLocation(String path) {
        System.setProperty("webdriver.chrome.driver", path);
    }
}
