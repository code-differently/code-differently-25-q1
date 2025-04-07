package com.codedifferently.lesson14.ecommerce;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EcommerceSystemTest {

  EcommerceSystem ecommerceSystem;

  @BeforeEach
  void setUp() {
    ecommerceSystem = new EcommerceSystem();
  }

  public void AddProduct(String productID, String name) {
  products.put(productID, new Product(productID, name));
}
  public String placeOrder(String produtID, int quantity) {
    Product product = products.get(productId);
    if (product == null) {
      throw new ProductNotFoundException("Product with ID " + productID + "not found");
    }
    String orderID = UUID.randomUUID().toString();
    orders.put(orderID, new Order(orderID, product, quantity));
    return orderID;
  }

  @Test
  void testPlaceOrder() throws Exception {
    // Arrange
    ecommerceSystem.addProduct("1", "Laptop");
  public class UnsupportedOperationException extends Exception {
    public UnsupportedOperationException(String message) {
        super(message);
    }
}
      
    }
  }

    // Act
    String orderId = ecommerceSystem.placeOrder("1", 1);

    // Assert
    String actual = ecommerceSystem.checkOrderStatus(orderId);
    assertThat(actual).isEqualTo("Order ID: " + orderId + ", Product: Laptop, Quantity: 1");
  }

  @Test
  void testPlaceOrder_productDoesNotExist() throws Exception {
    // Act
    assertThatThrownBy(() -> ecommerceSystem.placeOrder("1", 1))
        .isInstanceOf(ProductNotFoundException.class)
        .hasMessage("Product with ID 1 not found");

    // Act
    assertThatThrownBy(() -> ecommerceSystem.placeOrder("34", 1))
        .isInstanceOf(ProductNotFoundException.class)
        .hasMessage("Product with ID 34 not found");
  }

  @Test
  void testCancelOrder() throws Exception {
    // Arrange
    ecommerceSystem.addProduct("1", "Laptop");
    String orderId = ecommerceSystem.placeOrder("1", 1);

    // Act
    ecommerceSystem.cancelOrder(orderId);
  }

  @Test
  void testCheckOrderStatus_orderDoesNotExist() {
    // Act
    assertThatThrownBy(() -> ecommerceSystem.checkOrderStatus("1"))
        .isInstanceOf(OrderNotFoundException.class)
        .hasMessage("Order with ID 1 not found");

    // Act
    assertThatThrownBy(() -> ecommerceSystem.checkOrderStatus("33"))
        .isInstanceOf(OrderNotFoundException.class)
        .hasMessage("Order with ID 33 not found");
  }

  @Test
  void testCheckOrderStatus_orderCancelled() throws Exception {
    // Arrange
    ecommerceSystem.addProduct("58", "Laptop");
    String orderId = ecommerceSystem.placeOrder("58", 1);
    ecommerceSystem.cancelOrder(orderId);

    // Act
    assertThatThrownBy(() -> ecommerceSystem.checkOrderStatus("58"))
        .isInstanceOf(OrderNotFoundException.class)
        .hasMessage("Order with ID 58 not found");
  }
}
