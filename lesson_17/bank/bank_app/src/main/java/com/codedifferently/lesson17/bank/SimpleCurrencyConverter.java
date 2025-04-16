package com.codedifferently.lesson17.bank;

import java.util.Map;

public class SimpleCurrencyConverter implements CurrencyConverter {
  private final Map<String, Double> exchangeRates;

  public SimpleCurrencyConverter(Map<String, Double> exchangeRates) {
    this.exchangeRates = exchangeRates;
  }

  @Override
  public double convert(double amount, String fromCurrency, String toCurrency) {
    if (fromCurrency.equals(toCurrency)) return amount;

    String key = fromCurrency + "_TO_" + toCurrency;
    Double rate = exchangeRates.get(key);

    if (rate == null) {
      throw new CurrencyConverterException(fromCurrency, toCurrency);
    }

    return amount * rate;
  }
}
