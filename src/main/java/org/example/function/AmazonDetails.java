package org.example.function;

import org.example.page.AmazonDetailsPage;

public class AmazonDetails{

    public  static AmazonDetailsPage amazonDetailsPage = new AmazonDetailsPage();
    public static void clickOnDeliveryTo() {
        AmazonDetailsPage.selectDifferentCountry();
    }

    public static void selectDifferentCountryFromDropDown(String listNumber) throws InterruptedException {
        amazonDetailsPage.selectDifferentCountryFromDropDown(listNumber);
    }

    public static void clickOnBtnDone() throws InterruptedException {
        AmazonDetailsPage.selectDoneButton();
    }
    public static String isSuccessfullyChangeTheCountry() {
       return AmazonDetailsPage.isSuccessfullyChangeTheCountry();
    }
    public static void searchGiftCards(String keyWord)  {
        AmazonDetailsPage.searchGiftCards(keyWord);
    }
    public static void selectGiftCard()  {
        AmazonDetailsPage.selectGiftCard();
    }
    public static void previewGiftCard() throws InterruptedException {
        AmazonDetailsPage.previewGiftCard();
    }
    public static String getSelectedImageSrc() {
        return AmazonDetailsPage.getSelectedImageSrc();
    }
    public static String getPreviewedImageSrc() {
        return AmazonDetailsPage.getPreviewedImageSrc();
    }
    public static void selectDifferentAmount()  {
        AmazonDetailsPage.selectDifferentAmount();
    }
    public static String getSelectedImageValue() {
        return AmazonDetailsPage.getSelectedImageValue();
    }
    public static String getPreviewedImageValue() {
        return AmazonDetailsPage.getPreviewedImageValue();
    }
}
