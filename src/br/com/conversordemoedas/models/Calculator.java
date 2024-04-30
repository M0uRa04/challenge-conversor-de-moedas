package br.com.conversordemoedas.models;


public class Calculator {

    public double convertCurrency(double amount, String sourceCurrency, String targetCurrency, Coins coins) {
            double targetRate = coins.getCoinValue(targetCurrency);
            double sourceRate = coins.getCoinValue(sourceCurrency);
            double convertedAmount = amount * (targetRate / sourceRate);
            return convertedAmount;

    }

}
