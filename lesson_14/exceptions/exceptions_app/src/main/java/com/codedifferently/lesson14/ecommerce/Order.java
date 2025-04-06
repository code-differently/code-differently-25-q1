package com.codedifferently.lesson14.ecommerce;

public class Order {
  private String orderId;
  private Product product;
  private int quantity;

  public Order(String orderId, Product product, int quantity) {
    this.orderId = orderId;
    this.product = product;
    this.quantity = quantity;
  }

  public String getOrderId() {
    return orderId;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }
}
