package com.luma.tests;

import com.luma.pages.LoginPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    LoginPage loginPage;
    String email = "tony.stark@gmail.com";
    String password = "Tony@stark";

    @BeforeMethod
    public void setup() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
    }

    @Test
    public void successfulLogin() {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
        loginPage.assertSuccessfulLogin();
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
