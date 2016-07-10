package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.concurrent.TimeUnit;

/**
 * Created by amitsingh on 20/06/16.
 */
public class MortgagePaymentCalculator {

    private WebDriver driver;

    public MortgagePaymentCalculator(WebDriver driver) {

        this.driver = driver;
    }

    //Locating all elements on the page

    private WebElement amount = driver.findElement(By.name("Amount"));
    private WebElement interest = driver.findElement(By.name("Interest"));
    private WebElement homeValue = driver.findElement(By.name("HomeValue"));
    private WebElement propertyTaxes = driver.findElement(By.name("PropertyTaxes"));
    private WebElement annualInsurance = driver.findElement(By.name("Insurance"));
    private WebElement pmi = driver.findElement(By.name("PMI"));
    private WebElement calculateButton = driver.findElement(By.name("calculate"));

    public void loadMortgagePaymentCalculatorPage() {

        Actions actions = new Actions(driver);
        WebElement elementMortgageCalcs = driver.findElement(By.linkText("Mortgage Calcs"));
        actions.moveToElement(elementMortgageCalcs).click().build().perform();
        WebElement element30YearFixed = driver.findElement(By.linkText("30 yr Fixed"));
        actions.moveToElement(element30YearFixed).click().build().perform();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

    }

    public void clearInputFields(){

        amount.clear();
        interest.clear();
        homeValue.clear();
        propertyTaxes.clear();
        annualInsurance.clear();
        pmi.clear();

    }

    public void inputInformation(double inputLoanAmount,double inputInterestRate,double inputHomeValue,double inputAnnualTaxes, double inputAnnualInsurance, double inputPmi){

        amount.sendKeys(Double.toString(inputLoanAmount));
        interest.sendKeys(Double.toString(inputInterestRate));
        homeValue.sendKeys(Double.toString(inputHomeValue));
        propertyTaxes.sendKeys(Double.toString(inputAnnualTaxes));
        annualInsurance.sendKeys(Double.toString(inputAnnualInsurance));
        pmi.sendKeys(Double.toString(inputPmi));

    }

    public void calculate(){
        calculateButton.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

}
