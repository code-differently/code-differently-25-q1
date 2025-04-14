package com.codedifferently.lesson17.bank;

public class CurrencyConverter {
    private final Map<Currency, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        exchangeRates.put(Currency.USD, 1.0); 
        exchangeRates.put(Currency.EUR, 1.1);
        exchangeRates.put(Currency.GBP, 1.3);
       
    }

    public double convert(double amount, Currency from, Currency to) {
        double usd = amount / exchangeRates.get(from);
        return usd * exchangeRates.get(to);
    }
}
