package com.luma.tests;

import com.luma.pages.HomePage;
import com.luma.pages.LoginPage;
import com.luma.pages.SignupPage;
import com.luma.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static com.luma.utils.Waits.waitForElementClickable;

public class EndToEnd
{
    private WebDriver driver;
    LoginPage loginPage;
    SignupPage signupPage;
    HomePage homePage ;
    private SoftAssert softAssert;
    String email = "tony.stark@gmail.com";
    String password = "Tony@stark";
    By product = By.linkText("Voyage Yoga Bag");
    By addToCart = By.xpath("//button//span[text()='Add to Cart']/..");;
    By addToCartButton = By.id("product-addtocart-button");


    @BeforeClass
    public void setup() {
        softAssert = new SoftAssert();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver, softAssert);
        //homePage = new HomePage(driver);
        loginPage.navigateToLoginPage();
        signupPage = new SignupPage(driver);
        loginPage.navigateToLoginPage();

    }

    @Test
    public void successfulLogin() {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
        loginPage.assertSuccessfulLogin();
    }
    @Test(dependsOnMethods = "successfulLogin")
    public void addToCart()
    {


        homePage.navigateToHomePage();
        homePage.searchFor("bag");
        ElementActions.clickElement(driver,product);
        //driver.findElement(By.linkText("Voyage Yoga Bag")).click();
        ElementActions.clickElement(driver,addToCartButton);
//        Actions actions = new Actions(driver);
//        waitForElementClickable(driver,price);
//        WebElement product = driver.findElement(price);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(price));
//        actions.moveToElement(product).perform();

        homePage.successfulAddToCart();


    }
    @AfterClass
    public void tearDown()
    {
        softAssert.assertAll();
        driver.quit();
    }
}
