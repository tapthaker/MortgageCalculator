package com.tests;

import com.appModules.CalculateMortgagePayments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by amitsingh on 26/06/16.
 */
public class MortgageCalcsTest {

    public WebDriver driver;
    public String baseUrl;

    @BeforeTest
    public void launchSite() {
        baseUrl = "http://www.mortgagecalculator.org/";
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void mortagePaymentCalculator30YearFixed() {
        System.out.println("Before Test");
        CalculateMortgagePayments.calculatePayment(driver,300000.00, 4.5, 400000, 2500, 1500, 0.55);
        System.out.println("After Test");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
