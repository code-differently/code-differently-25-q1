package com.codedifferently.lesson14.ecommerce;

public class OrderNotFoundException extends RuntimeException {
  public OrderNotFoundException(String message) {
    super(message);
  }
}
