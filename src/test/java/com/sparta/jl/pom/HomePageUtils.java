package com.sparta.jl.pom;

import com.sparta.jl.pom.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class HomePageUtils {
    public static boolean PriceIsAscending (Double[] priceList) {
        return isSortedAscendingArray(priceList, priceList.length);
    }
    public static boolean PriceIsDescending (Double[] priceList) {
        return isSortedDescendingArray(priceList, priceList.length);
    }
    private static boolean isSortedAscendingArray(Double[] array, int n){
        if(n == 1 || n == 0) return true;
        return array[n-2] <= array[n-1] && isSortedAscendingArray(array, n-1);
    }
    private static boolean isSortedDescendingArray(Double[] array, int n){
        if(n == 1 || n == 0) return true;
        return array[n-2] >= array[n-1] && isSortedDescendingArray(array, n-1);
    }
}
