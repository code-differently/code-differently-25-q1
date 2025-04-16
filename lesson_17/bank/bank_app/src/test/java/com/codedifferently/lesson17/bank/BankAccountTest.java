package com.codedifferently.lesson17.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
  @Test
  void testIsActive() {
    // Arrange
    Set<Customer> owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "John Doe"));
    BankAccount account = new CheckingAccount("123456789", owners, 100.0);
    // Act
    boolean isActive = account.isActive();
    // Assert
    assertThat(!isActive).isTrue();
  }

  @Test
  void testGetOwners() {
    // Act
    Set<Customer> owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "John Doe"));
    BankAccount account = new CheckingAccount("123456789", owners, 100.0);
    // Assert
    assertEquals(owners, account.getOwners());
  }

  @Test
  void testWithdrawFunds() {
    // Arrange
    double initialBalance = 100.0;
    double withdrawAmount = 50.0;
    double expectedBalance = initialBalance - withdrawAmount;

    // Act
    BankAccount account = new CheckingAccount("123456789", null, initialBalance);
    account.withdraw(withdrawAmount);

    // Assert
    assertThat(account.balance).isEqualTo(expectedBalance);
  }
}
