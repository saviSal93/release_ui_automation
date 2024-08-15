package org.example.automation.test;

import org.example.Common.Constants;
import org.example.function.AmazonDetails;
import org.example.function.Login;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.example.page.LoginPage.driver;

public class AmazonDetailsTest {

    @BeforeMethod
    public void testSearchAmazon()  {
        Login.login();
        Login.searchAmazonPage(Constants.PAGE_NAME);
        Login.selectAmazonPage();
    }
    @AfterMethod
    public void tearDown() {
        // quit the browser
        driver.quit();
    }

    @Test(alwaysRun = true, priority = 1)
    public void testVerifySearchDifferentCounty() throws InterruptedException {
        AmazonDetails.clickOnDeliveryTo();
        AmazonDetails.selectDifferentCountryFromDropDown(Constants.COUNTRY_ID);
        AmazonDetails.clickOnBtnDone();
        Assert.assertEquals(AmazonDetails.isSuccessfullyChangeTheCountry(),Constants.DELIVERY_TO_COUNTRY_NAME);
    }

    @Test(alwaysRun = true, priority = 2)
    public void testVerifySearchEGiftCards() throws InterruptedException {
        AmazonDetails.searchGiftCards(Constants.SEARCH_KEY_WORD);
        // verify preview image with selected image
        AmazonDetails.selectGiftCard();
        String selectedImageSrc = AmazonDetails.getSelectedImageSrc();
        AmazonDetails.previewGiftCard();
        String PreviewedImageSrc = AmazonDetails.getPreviewedImageSrc();
        Assert.assertEquals(selectedImageSrc,PreviewedImageSrc,"not matching selected image with previewed image");
    }

    @Test(alwaysRun = true, priority = 3)
    public void testVerifySelectDifferentAmount() throws InterruptedException {
        AmazonDetails.searchGiftCards(Constants.SEARCH_KEY_WORD);
        // verify preview image value with selected image value
        AmazonDetails.selectGiftCard();
        AmazonDetails.selectDifferentAmount();
        String selectedImageValue = AmazonDetails.getSelectedImageValue();
        AmazonDetails.previewGiftCard();
        String previewedImageValue = AmazonDetails.getPreviewedImageValue();
        Assert.assertEquals(selectedImageValue,previewedImageValue,"not matching selected image value with previewed image value");
    }
}
