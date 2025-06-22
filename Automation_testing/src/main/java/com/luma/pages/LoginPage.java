package com.luma.pages;

import com.luma.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage
{
    //Variables
    final private  WebDriver driver ;
    final private String loginPageURL = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2NyZWF0ZS8%2C/";
    final private String successfulLoginURL = "https://magento.softwaretestingboard.com/customer/account/";
    final private String errorMassage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
    //locators
    final private By emailTextBox = By.id("email");
    final private By passwordTextBox = By.id("pass");
    final private By signInButton = By.id("send2");
    final private By errorMassageLocator =  By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div > div");

    //Navigate to login page
    public void navigateToLoginPage()
    {
        driver.get(loginPageURL);
    }

    //Actions

    public LoginPage(WebDriver driver)
    {
        this.driver = driver ;
    }

    public void enterEmail (String email)
    {
        ElementActions.sendData(this.driver,this.emailTextBox,email);
    }
    public void enterPassword (String password)
    {
        ElementActions.sendData(this.driver,this.passwordTextBox,password);
    }
    public void clickSignInButton ()
    {
        ElementActions.clickElement(driver,signInButton);
    }

    public String getErrorMassage ()
    {
        return ElementActions.getText(this.driver,this.errorMassageLocator);
    }
    //validation

    public void assertSuccessfulLogin ()
    {
        Assert.assertEquals(driver.getCurrentUrl(),successfulLoginURL);
    }

    public void assertUnsuccessfulLogin ()
    {
        Assert.assertEquals(getErrorMassage(),errorMassage );
    }
}
