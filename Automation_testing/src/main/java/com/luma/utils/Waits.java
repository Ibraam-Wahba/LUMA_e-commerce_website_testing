package com.luma.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits
{
    // Prevent instantiation
    private Waits(){}

    //wait foe element to be present
    public static WebElement waitForElementPresent (WebDriver driver , By locator)
    {

        WebDriverWait wait= new WebDriverWait(driver , Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    //wait foe element to be visible
    public static WebElement waitForElementVisible (WebDriver driver , By locator)
    {

        WebElement element = waitForElementPresent (driver,locator);
        return element.isDisplayed() ? element : null;
    }

    //wait foe element to be clickable
    public static WebElement waitForElementClickable (WebDriver driver , By locator)
    {
        WebElement element =  waitForElementVisible ( driver ,  locator);
        return element.isEnabled() ? element : null;

    }
}
