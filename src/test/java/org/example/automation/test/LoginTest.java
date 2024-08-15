package org.example.automation.test;
import org.example.Common.Constants;
import org.example.function.Login;
import org.testng.annotations.Test;


public class LoginTest {

        @Test
        public void testSearchAmazon()  {
             Login.login();
             Login.searchAmazonPage(Constants.PAGE_NAME);
             Login.selectAmazonPage();
        }
    }

