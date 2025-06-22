package com.luma.tests;


import com.luma.pages.SignupPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.luma.driver.DriverSetup.driverSetup;

public class SignupTest
{
    private WebDriver driver;
    SignupPage signupPage;

    String firstName = "Dody";
    String lastName = "Ayman";

    String email = "Dody.Ayman@gmail.com";
    String password = "Dody.Ayman";

    @BeforeMethod
    public void setup()
    {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        signupPage = new SignupPage(driver);
        signupPage.navigateToSignupPage();
    }

    @Test
    public void successfulSignup() {
        signupPage.enterFirstName(firstName);
        signupPage.enterLastName(lastName);
        signupPage.enterEmail(email);
        signupPage.enterPassword(password);
        signupPage.clickCreateAccountButton();
        signupPage.assertSuccessfulSignup();
    }
    @Test
    public void UnsuccessfulSignup() {
        signupPage.enterFirstName(firstName);
        signupPage.enterLastName(lastName);
        signupPage.enterEmail(email);
        signupPage.enterPassword(password);
        signupPage.clickCreateAccountButton();
        signupPage.assertUnsuccessfulSignup();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
