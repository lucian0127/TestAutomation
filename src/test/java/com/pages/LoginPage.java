package com.pages;

import com.qa.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class LoginPage {

    private WebDriver driver;

    //1. By Locators:
    private By usernameId = By.id("login_field");
    private By passwordId = By.id("password");
    private By signInLink = By.xpath("//a[contains(@class, 'HeaderMenu-link HeaderMenu-link--sign-in flex-shrink-0 no-underline d-block d-lg-inline-block border border-lg-0 rounded rounded-lg-0 p-2 p-lg-0')]");
    private By signInBTN = By.xpath("//input[contains(@class, 'btn btn-primary btn-block js-sign-in-button')]");
    private By newAccountLinkText = By.linkText("Create an account");
    private By forgotPwdLinkText = By.linkText("Forgot password?");
    private By avatarIcon = By.xpath("//img[contains(@class, 'avatar avatar-small circle')]");

    //2. Constructor of the page class:
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //3. Page actions: features(behavior) of the page the form of methods:
    public String getHomePageTitle()
    {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        return driver.getTitle();
    }

    public void clickSigninLink()
    {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(signInLink).click();
    }

    public String getSigninPageTitle()
    {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver.getTitle();
    }

    public boolean isCreateNewAccountExist()
    {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver.findElement(newAccountLinkText).isDisplayed();
    }
    public boolean isForgotPasswordExist()
    {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver.findElement(forgotPwdLinkText).isDisplayed();
    }

    public void enterUsername(String Username)
    {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(usernameId).sendKeys(Username);
    }

    public void enterPassword(String Password)
    {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(passwordId).sendKeys(Password);
    }

    public void clickSignInButton()
    {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(signInBTN).click();
    }

    public boolean isAvatarIconExist()
    {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(avatarIcon).isDisplayed();
    }

    public MyAccountPage doLogin(String un, String pwd)
    {
        out.println("Login using: " + un);
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(usernameId).sendKeys(un);

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(passwordId).sendKeys(pwd);

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(signInBTN).click();

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(avatarIcon).click();

        return new MyAccountPage(driver);
    }
}
