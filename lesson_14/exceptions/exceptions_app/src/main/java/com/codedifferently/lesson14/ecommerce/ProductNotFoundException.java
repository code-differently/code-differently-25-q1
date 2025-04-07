package com.codedifferently.lesson14.ecommerce;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(String message) {
    super(message);
  }
}
