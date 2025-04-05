package com.codedifferently.lesson14.ecommerce;

public class Product {
  private String productId;
  private String name;

  public Product(String productId, String name) {
    this.productId = productId;
    this.name = name;
  }

  public String getProductId() {
    return productId;
  }

  public String getName() {
    return name;
  }
}
