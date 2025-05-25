package com.codedifferently.lesson17.bank.exceptions;

public class InvalidBusinessAccountException extends RuntimeException {
  public InvalidBusinessAccountException(String message) {
    super(message);
  }
}