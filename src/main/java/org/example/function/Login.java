package org.example.function;

import org.example.page.LoginPage;



public class Login {

        public static void login()  {
            LoginPage.loginPage("https://www.google.com");
        }
        public static void searchAmazonPage(String page)  {
        LoginPage.searchAmazonPage(page);
        }
        public static void selectAmazonPage()  {
        LoginPage.selectAmazonLink();
        }
}




