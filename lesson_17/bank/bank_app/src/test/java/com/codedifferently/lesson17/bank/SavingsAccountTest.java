package com.codedifferently.lesson17.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

  private SavingsAccount classUnderTest;
  private Set<Customer> owners;
  private double initialBalance = 100.0;
  private String accountNumber = "123456789";

  @BeforeEach
  void setUp() {
    owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "John Doe"));
    classUnderTest = new SavingsAccount(accountNumber, owners, initialBalance);
  }

  @Test
  void testIsClosed() {
    // Arrange
    Set<Customer> owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "Ezra Nyabuti"));
    SavingsAccount account = new SavingsAccount(accountNumber, owners, initialBalance);

    // Act
    IllegalStateException exception =
        assertThrows(IllegalStateException.class, () -> account.isClosed());

    // Assert
    assertEquals(
        "Cannot check if account is closed", exception.getMessage(), "Exception message mismatch");
  }

  @Test
  void testIsActive() {
    Set<Customer> owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "Ezra Nyabuti"));
    SavingsAccount account = new SavingsAccount(accountNumber, owners, initialBalance);
    // ssert
    assertTrue(account.isActive(), "Account should be active");
  }

  @Test
  void testCloseAccount() {
    // Arrange
    Set<Customer> owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "Ezra Nyabuti"));

    // Act
    SavingsAccount account = new SavingsAccount(accountNumber, owners, initialBalance);
    IllegalStateException exception =
        assertThrows(IllegalStateException.class, () -> account.closeAccount());
    // Assert
    assertEquals("Cannot close account with a positive balance", exception.getMessage());
  }
}
