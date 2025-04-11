package com.codedifferently.lesson17.bank.exceptions;

public class InsufficientFundsException extends RuntimeException {

  public InsufficientFundsException() {}

  public InsufficientFundsException(String message) {
    super(message);
  }
}
