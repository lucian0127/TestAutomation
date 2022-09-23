package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.System.out;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the threadlocal driver on the basis of given browser
     * @param browser
     * @return
     */

    public WebDriver init_driver(String browser)
    {
        out.println("Preparing \"" + browser.toUpperCase() + "\" browser...");

        if (browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());

            out.println("Launching \"" + browser.toUpperCase() + "\" browser...");
        }
        else if (browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());

            out.println("Launching \"" + browser.toUpperCase() + "\" browser...");
        }
        else if (browser.equals("safari"))
        {
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new EdgeDriver());

            out.println("Launching \"" + browser.toUpperCase() + "\" browser...");
        }
        else
        {
            out.println("Could not find the \"" + browser.toUpperCase() + "\" browser.");
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    /**
     * This is used to get the driver with ThreadLocal
     * @return
     */
    public static synchronized WebDriver getDriver()
    {
        return tlDriver.get();
    }
}
