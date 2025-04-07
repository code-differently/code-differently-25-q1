package com.codedifferently.lesson14.ecommerce;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EcommerceSystem {

  private Map<String, Product> products;
  private Map<String, Order> orders;
  private Map<String, String> productToOrderId;

  public EcommerceSystem() {
    products = new HashMap<>();
    orders = new HashMap<>();
    productToOrderId = new HashMap<>();
  }

  public void addProduct(String productId, String name) {
    products.put(productId, new Product(productId, name));
  }

  public String placeOrder(String productId, int quantity) {
    Product product = products.get(productId);
    if (product == null) {
      throw new ProductNotFoundException("Product with ID " + productId + " not found");
    }
    String orderId = UUID.randomUUID().toString();
    Order order = new Order(orderId, product, quantity);
    orders.put(orderId, order);
    productToOrderId.put(productId, orderId); // so we can find the order by productId
    return orderId;
  }

  public void cancelOrder(String orderId) {
    orders.remove(orderId);
  }

  public String checkOrderStatus(String id) {
    // Check if this is a real order ID
    Order order = orders.get(id);
    if (order != null) {
      return "Order ID: "
          + id
          + ", Product: "
          + order.getProduct().getName()
          + ", Quantity: "
          + order.getQuantity();
    }

    // If a product ID was passed instead of an order ID, and it had a cancelled order
    if (productToOrderId.containsKey(id) && !orders.containsKey(productToOrderId.get(id))) {
      throw new OrderNotFoundException("Order with ID " + id + " not found");
    }

    // If not found at all
    throw new OrderNotFoundException("Order with ID " + id + " not found");
  }
}
