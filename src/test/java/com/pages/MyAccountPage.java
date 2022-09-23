package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class MyAccountPage {

    private WebDriver driver;

    private By accountMenuItems = By.cssSelector("div.Header-item.position-relative.mr-0 details-menu.dropdown-menu a.dropdown-item");
    private By avatarIcon = By.xpath("//img[contains(@class, 'avatar avatar-small circle')]");
    private By myAccountHeaderTitle = By.xpath("//a[contains(text(), 'Signed in as ')]");
    public MyAccountPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getMyAccountPopupTitle()
    {
        String myAccountHeaderText = driver.findElement(myAccountHeaderTitle).getText();

        return myAccountHeaderText;
    }

    public int getAccountMenuItemsCount()
    {
        int count = driver.findElements(accountMenuItems).size()-1;
        out.println("Total Items found: " + count);
        return  count;
    }

    public List<String> getAccountMenuItemsList()
    {
        List<String> itemsList = new ArrayList<>();
        List<WebElement> accountMenuItemsList = driver.findElements(accountMenuItems);

        for (WebElement e: accountMenuItemsList)
        {
            String text = e.getText();
            out.println(text);
            itemsList.add(text);
        }

        return itemsList;
    }

}
