package com.appModules;

import com.pageObjects.MortgagePaymentCalculator;
import org.openqa.selenium.WebDriver;

/**
 * Created by amitsingh on 10/07/16.
 */
public class CalculateMortgagePayments {

    public static void calculatePayment(WebDriver driver, double loanAmount, double interestRate, double homeValue, double annualTaxes, double annualInsurance, double pmi){
        MortgagePaymentCalculator mortgagePaymentCalculator = new MortgagePaymentCalculator(driver);
        mortgagePaymentCalculator.loadMortgagePaymentCalculatorPage();
        mortgagePaymentCalculator.clearInputFields();
        mortgagePaymentCalculator.inputInformation(loanAmount, interestRate, homeValue,annualTaxes,annualInsurance,pmi);
        mortgagePaymentCalculator.calculate();
    }
}
