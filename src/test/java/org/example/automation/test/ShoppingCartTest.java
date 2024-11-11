package org.example.automation.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.example.page.LoginPage.driver;

public class ShoppingCartTest {

    @BeforeMethod
    public void testLogin()
    {
        driver = new ChromeDriver();
        //open browser
        driver.get("https://spaceylon.in/");
    }
    @Test
    public void testVerifyAddItemToCart() {

        WebElement button = driver.findElement(By.xpath("//*[@id=\"HeaderMenu-shop-all\"]/span"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        button.click();

        WebElement ITEM = driver.findElement(By.xpath("//*[@id=\"quick-add-template--22576229548323__product-grid8949866201379-submit\"]"));
        ITEM.click();
    }
    @Test
    public void testVerifyItemPreview() {

        WebElement button = driver.findElement(By.xpath("//*[@id=\"HeaderMenu-shop-all\"]/span"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        button.click();

        String itemName = String.valueOf(driver.findElement(By.id("CardLink-template--22576229548323__product-grid-8949866201379")).getText());

        WebElement ITEM = driver.findElement(By.id("CardLink-template--22576229548323__product-grid-8949866201379"));
        ITEM.click();
        String previewItemName = String.valueOf(driver.findElement(By.xpath("//div[@class='product__title']")).getText());
        Assert.assertEquals(itemName, previewItemName);
    }
}
