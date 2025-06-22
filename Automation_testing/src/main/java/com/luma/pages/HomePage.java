package com.luma.pages;

import com.luma.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class HomePage {
    //Variables
    private SoftAssert softAssert;
    private final WebDriver driver;
    private final String homePageURL = "https://magento.softwaretestingboard.com/";
    private final String JacketItemsURL = "https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html";
    private final String successfulAddToCartMassage = "You added";

    //
    //Locators
    private final By signInLink = By.linkText("Sign In");
    private final By createAccountLink = By.linkText("Create an Account");
    private final By searchBox = By.id("search");
    private final By cartIcon = By.cssSelector("a.action.showart");
    private final By AddToCartMassage = By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div > div");
    //Constructor

    public HomePage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
    }

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }
    //Actions
    public void navigateToHomePage()
    {
        driver.get(homePageURL);
    }
    public void navigateToProductItemPage()
    {
        driver.get(JacketItemsURL);
    }
    public void clickSignIn()
    {
        ElementActions.clickElement(driver, signInLink);
    }

    public void clickCreateAccount()
    {
        ElementActions.clickElement(driver, createAccountLink);
    }

    public void searchFor(String keyword)
    {
        ElementActions.clearInputField(driver,searchBox);
        ElementActions.sendData(driver,searchBox,keyword);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);

    }

    public void clickCartIcon()
    {
       ElementActions.clickElement(driver,cartIcon);
    }

    //Validation

    public void successfulAddToCart()
    {
        String actualMassage=ElementActions.getText(driver,AddToCartMassage);
        softAssert.assertTrue(actualMassage.contains(successfulAddToCartMassage),"Successful add to cart massage in not presented");

    }
}
