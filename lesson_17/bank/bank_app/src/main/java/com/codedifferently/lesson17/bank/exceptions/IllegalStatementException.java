package com.codedifferently.lesson17.bank.exceptions;

public class IllegalStatementException extends RuntimeException {

  public IllegalStatementException() {}

  public IllegalStatementException(String message) {
    super(message);
  }
}
