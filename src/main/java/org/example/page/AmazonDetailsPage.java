package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import static org.example.page.LoginPage.driver;

public class AmazonDetailsPage {
    private static final By btnDeliveryTo = By.xpath("//*[@id=\"nav-global-location-popover-link\"]");
    private static final By btnDone = By.xpath("//*[@id=\"a-popover-1\"]/div/div[2]/span/span/span/button");
    private static final By ddlCountryList = By.xpath("//*[@id=\"GLUXCountryListDropdown\"]/span");
    private static final By lblDeliveryToCountry = By.xpath("//*[@id=\"glow-ingress-line2\"]");
    private static final By searchBar = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
    private static final By selectImage = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div[2]/span/a/div");
    private static final By previewImage = By.xpath("//*[@id=\"gc-standard-design-image\"]");
    private static final By selectedImage = By.xpath("//*[@id=\"gc-standard-design-image\"]");
    private static final By previewedImage = By.xpath("//*[@id=\"mainImageContainer\"]/img");
    private static final By btnDifferentAmount = By.xpath("//*[@id=\"a-autoid-28\"]");
    private static final By selectedImageValue = By.xpath("//*[@id=\"gc-live-preview-amount\"]");
    private static final By PreviewedImageValue = By.xpath("//*[@id=\"gc-preview-template-inner-wrapper\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td[1]/span[1]");


    private By ddlCountry(String listNumber) {
        return By.xpath("//*[@id='GLUXCountryList_" + listNumber + "']");
    }
    public static void selectDifferentCountry() {
        WebElement deliveryToButton = driver.findElement(btnDeliveryTo);
        deliveryToButton.click();
    }
    public void selectDifferentCountryFromDropDown(String listNumber) throws InterruptedException {
        Thread.sleep(5000);
        WebElement countryList = driver.findElement(ddlCountryList);
        countryList.click();
        Thread.sleep(5000);
        WebElement countryList1 = driver.findElement(this.ddlCountry(listNumber));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", countryList1);
        countryList1.click();
    }

    public static void selectDoneButton() throws InterruptedException {
        WebElement deliveryToButton = driver.findElement(btnDone);
        deliveryToButton.click();
        Thread.sleep(5000);
    }

    public static String isSuccessfullyChangeTheCountry() {
        WebElement DeliveryToCountry = driver.findElement(lblDeliveryToCountry);
        return DeliveryToCountry.getText();
    }

    public static void searchGiftCards(String keyWord) {
        WebElement searchElement = driver.findElement(searchBar);
        searchElement.sendKeys(keyWord);
        searchElement.sendKeys(Keys.ENTER);
    }
    public static void selectGiftCard() {
        WebElement designElement = driver.findElement(selectImage);
        designElement.click();
    }
    public static void previewGiftCard() throws InterruptedException {

        WebElement designElement = driver.findElement(previewImage);
        Thread.sleep(5000);
        designElement.click();
    }
    public static String getSelectedImageSrc() {
        return driver.findElement(selectedImage).getAttribute("src");
    }
    public static String getPreviewedImageSrc() {
        return driver.findElement(previewedImage).getAttribute("src");
    }
    public static void selectDifferentAmount() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement designElement = driver.findElement(btnDifferentAmount);
        js.executeScript("arguments[0].value='value';", designElement);
        designElement.click();
    }
    public static String getSelectedImageValue() {
        return driver.findElement(selectedImageValue).getText();
    }
    public static String getPreviewedImageValue() {
        return driver.findElement(PreviewedImageValue).getText();
    }

}
