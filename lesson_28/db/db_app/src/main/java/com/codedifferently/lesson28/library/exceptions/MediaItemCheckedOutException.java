package com.codedifferently.lesson28.library.exceptions;

public class MediaItemCheckedOutException extends RuntimeException {
  public MediaItemCheckedOutException(String message) {
    super(message);
  }
}
