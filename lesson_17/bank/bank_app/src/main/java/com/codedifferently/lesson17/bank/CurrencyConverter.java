package com.codedifferently.lesson17.bank;

public interface CurrencyConverter {
  double convert(double amount, String fromCurrency, String toCurrency);
}
