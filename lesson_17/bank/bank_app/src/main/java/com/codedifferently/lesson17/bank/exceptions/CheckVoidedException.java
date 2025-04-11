package com.codedifferently.lesson17.bank.exceptions;

public class CheckVoidedException extends RuntimeException {

  public CheckVoidedException() {}

  public CheckVoidedException(String message) {
    super(message);
  }
}
