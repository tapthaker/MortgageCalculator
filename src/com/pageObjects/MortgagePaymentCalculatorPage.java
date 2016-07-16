package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.concurrent.TimeUnit;

public class MortgagePaymentCalculatorPage {

    private WebDriver driver;
    private WebElement amount;
    private WebElement interest;
    private WebElement homeValue;
    private WebElement propertyTaxes;
    private WebElement annualInsurance;
    private WebElement pmi;
    private WebElement calculateButton;

    public MortgagePaymentCalculatorPage(final WebDriver driver) {

        this.driver = driver;

    }

    public void locateElements() {
        amount = driver.findElement(By.name("Amount"));
        interest = driver.findElement(By.name("Interest"));
        homeValue = driver.findElement(By.name("HomeValue"));
        propertyTaxes = driver.findElement(By.name("PropertyTaxes"));
        annualInsurance = driver.findElement(By.name("Insurance"));
        pmi = driver.findElement(By.name("PMI"));
        calculateButton = driver.findElement(By.name("calculate"));
    }

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

    public void calculate(double inputLoanAmount, double inputInterestRate, double inputHomeValue, double inputAnnualTaxes, double inputAnnualInsurance, double inputPmi) {
        loadMortgagePaymentCalculatorPage();
        locateElements();
        clearInputFields();
        inputInformation(inputLoanAmount, inputInterestRate, inputHomeValue, inputAnnualTaxes, inputAnnualInsurance, inputPmi);
        calculateButton.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
