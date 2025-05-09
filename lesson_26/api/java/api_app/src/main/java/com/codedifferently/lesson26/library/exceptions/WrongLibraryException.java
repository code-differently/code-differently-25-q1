package com.codedifferently.lesson26.library.exceptions;

public class WrongLibraryException extends RuntimeException {
  public WrongLibraryException(String message) {
    super(message);
  }
}
