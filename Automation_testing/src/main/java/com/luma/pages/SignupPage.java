package com.luma.pages;

import com.luma.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupPage {
    //variables
    final private WebDriver driver;
    final private String signupURL = "https://magento.softwaretestingboard.com/customer/account/create/";
    final private String errorMassageForDuplicatedEmail = "There is already an account with this email address. If you are sure that it is your email address,";
    final private String successfulSignupMassage = "Thank you for registering with Main Website Store.";
    //locators
    final private By firstName = By.id("firstname");
    final private By lastName = By.id("lastname");
    final private By email = By.id("email_address");
    final private By password = By.id("password");
    final private By confirmPassword = By.id("password-confirmation");
    final private By createAccountButton = By.cssSelector("button[title='Create an Account']");
    final private By errorMassageLocator = By.cssSelector("div[data-bind*='prepareMessageForHtml']");

    //Constructor
    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }
    //Actions

    //Navigate to login page
    public void navigateToSignupPage()
    {
        driver.get(signupURL);
    }

    public  void enterFirstName(String firstName)
    {
        ElementActions.sendData(this.driver ,this.firstName,firstName );
    }

    public  void enterLastName(String lastName)
    {
        ElementActions.sendData(driver ,this.lastName,lastName);
    }

    public  void enterEmail(String email)
    {
        ElementActions.sendData(driver ,this.email,email);
    }

    public  void enterPassword(String password)
    {
        ElementActions.sendData(driver ,this.password,password);
        ElementActions.sendData(driver ,this.confirmPassword,password);
    }

    public void clickCreateAccountButton ()
    {
        ElementActions.clickElement(driver,createAccountButton);
    }

    public String getErrorMassage ()
    {
        return ElementActions.getText(this.driver,this.errorMassageLocator);
    }

    //Assertions

    public void assertSuccessfulSignup ()
    {
        String text = getErrorMassage();
        Assert.assertTrue(text.contains(successfulSignupMassage), "Successful Signup message not displayed or incorrect");
    }

    public void assertUnsuccessfulSignup ()
    {
        String text = getErrorMassage();
        Assert.assertTrue(text.contains(errorMassageForDuplicatedEmail), "Unsuccessful Signup not displayed or incorrect");
    }





}
