package com.codedifferently.lesson17.bank;

public class CurrencyConverterException extends RuntimeException {
  public CurrencyConverterException(String fromCurrency, String toCurrency) {
    super("Unsupported conversion from " + fromCurrency + " to " + toCurrency);
  }
}
