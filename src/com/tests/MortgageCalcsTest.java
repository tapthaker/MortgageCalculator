package com.tests;

import com.pageObjects.MortgagePaymentCalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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

        MortgagePaymentCalculatorPage mortgagePaymentCalculatorPage = new MortgagePaymentCalculatorPage(driver);
        mortgagePaymentCalculatorPage.calculate(300000.00, 4.5, 400000, 2500, 1500, 0.55);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Assert.assertEquals("Financial Analysis", driver.findElement(By.xpath("//*[@id=\"analysisDiv\"]/div/font/strong")).getText());
        Assert.assertEquals("$1,520.06",mortgagePaymentCalculatorPage.getMonthlyPrincipalPlusInterest());
        Assert.assertEquals("$208.33",mortgagePaymentCalculatorPage.getRealEstateTaxes());
        Assert.assertEquals("$125.00",mortgagePaymentCalculatorPage.getMonthlyInsurance());
        Assert.assertEquals("$1,853.39",mortgagePaymentCalculatorPage.getTotalMonthlyPayments());
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
