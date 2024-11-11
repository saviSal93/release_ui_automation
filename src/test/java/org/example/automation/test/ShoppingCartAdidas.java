package org.example.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.example.page.LoginPage.driver;



public class ShoppingCartAdidas {
    public static final String SEARCH_WORD = "“SHOES”";

    @BeforeMethod
    public static void Login()
    {
        driver = new ChromeDriver();
        driver.get("https://www.adidas.co.uk/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public static void AfterEachMethod()
    {
        driver.quit();
    }

    @Test
    public static void verifySearch()
    {
        WebElement cookie = driver.findElement(By.xpath("//*[@id=\"glass-gdpr-default-consent-accept-button\"]/span[2]"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        cookie.click();
        WebElement search = driver.findElement(By.xpath("//div[@class='_wrapper_1f3oz_1']//input[@placeholder='Search']"));
        search.sendKeys("Shoes"+ Keys.ENTER);

        String title = String.valueOf(driver.findElement(By.xpath("//div[@class='heading_heading-wrapper__qPcba']//h1[@data-testid='search-heading-title']")).getText());
        Assert.assertEquals(title, SEARCH_WORD);

    }
}
