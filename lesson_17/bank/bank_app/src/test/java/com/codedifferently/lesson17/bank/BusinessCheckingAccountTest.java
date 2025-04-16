package com.codedifferently.lesson17.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class BusinessCheckingAccountTest {

  public class BusinessCheckingTest {

    @Test
    public void testValidBusinessCheckingAccount() {
      Customer bob = new Customer(UUID.randomUUID(), "Bob", true); // is a business
      Set<Customer> owners = Set.of(bob);

      BusinessChecking account = new BusinessChecking("BUS-001", owners, 100.0);
      assertEquals("BUS-001", account.getAccountNumber());
    }

    @Test
    public void testInvalidBusinessCheckingAccountThrowsException() {
      Customer alice = new Customer(UUID.randomUUID(), "Alice", false); // personal
      Set<Customer> owners = Set.of(alice);

      Exception exception =
          assertThrows(
              IllegalArgumentException.class,
              () -> {
                new BusinessChecking("BUS-002", owners, 100.0);
              });

      assertEquals(
          "Business account must have at least one business owner.", exception.getMessage());
    }
  }
}
