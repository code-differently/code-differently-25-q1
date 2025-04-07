package com.codedifferently.lesson14.ecommerce;

public class Order {
  private final String id;
  private final Product product;
  private final int quantity;

  public Order(String id, Product product, int quantity) {
    this.id = id;
    this.product = product;
    this.quantity = quantity;
  }

  public String getId() {
    return id;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }
}
