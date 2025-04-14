package com.codedifferently.lesson17.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
  @Test
  public void testDepositFunds() {
    // Create a customer
    Customer customer = new Customer(null, "John Doe");

    // Create a savings account
    SavingsAccount savingsAccount = new SavingsAccount("123456789", Set.of(customer), 1000.0);

    // Deposit funds into the account
    savingsAccount.deposit(500.0);

    // Assert that the balance is correct
    assertEquals(1500.0, savingsAccount.getBalance());
  }

  @Test
  public void testDepositCheck() {
    // Create a customer
    Customer customer = new Customer(null, "John Doe");

    // Create a savings account
    SavingsAccount savingsAccount = new SavingsAccount("123456789", Set.of(customer), 1000.0);

    // Attempt to deposit a check into the account
    assertThrows(
        UnsupportedOperationException.class,
        () -> {
          savingsAccount.depositFunds(new Check(null, 100.0, savingsAccount));
        });
  }
}
