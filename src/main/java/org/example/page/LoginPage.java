package org.example.page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
        public static WebDriver driver;

        // Locator for the Google search box
        private static final By searchBox = By.xpath("//*[@id=\"APjFqb\"]");
        // Locator for search results (Amazon link)
        private By amazonLink = By.xpath("//h3[contains(text(), 'Amazon')]");


        public static void loginPage(String url) {
                //set the path for webdriver
                WebDriverManager.chromedriver().setup();
                //initiate driver object
                driver = new ChromeDriver();
                //open browser
                driver.get("https://www.google.com");
        }

        public static void searchAmazonPage(String pageName) {
                WebElement searchElement = driver.findElement(searchBox);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                searchElement.sendKeys(pageName);
                searchElement.sendKeys(Keys.ENTER);
        }

        public static void selectAmazonLink() {
            try {
                // Navigate to Amazon
                driver.get("https://www.amazon.com");
                // Find all the links on the page
                java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

                // Check if there are any links
                if (!links.isEmpty()) {
                    // Click on the first link
                    links.get(0).click();
                } else {
                    System.out.println("No links found on the page.");
                }
            } finally {

            }
        }

}
