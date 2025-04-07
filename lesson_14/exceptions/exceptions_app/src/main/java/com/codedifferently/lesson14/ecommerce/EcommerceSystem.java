package com.codedifferently.lesson14.ecommerce;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EcommerceSystem {
  private Map<String, Product> products;
  private Map<String, Order> orders;

  public EcommerceSystem() {
    products = new HashMap<>();
    orders = new HashMap<>();
  }

  public void addProduct(String productId, String name) {
    products.put(productId, new Product(productId, name));
  }

  // Tells the method that it should expect to throw an exception
  public String placeOrder(String productId, int quantity) throws ProductNotFoundException {

    Product product = products.get(productId);
    String orderId = UUID.randomUUID().toString();

    if (product == null) {
      throw new ProductNotFoundException("Product with ID " + productId + " not found");
    }

    orders.put(orderId, new Order(orderId, product, quantity));
    return orderId;
  }

  public void cancelOrder(String orderId) {
    orders.remove(orderId);
  }

  // Modified the method declaration to tell this method to expect and Exception.
  public String checkOrderStatus(String orderId) throws OrderNotFoundException {
    Order order = orders.get(orderId);

    // Checks if the user has entered nothing
    if (order == null) {
      // Throws and error and sends back a message
      throw new OrderNotFoundException("Order with ID " + orderId + " not found");
    }

    return "Order ID: "
        + orderId
        + ", Product: "
        + order.getProduct().getName()
        + ", Quantity: "
        + order.getQuantity();
  }
}
