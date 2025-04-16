package com.codedifferently.lesson17.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
  @Test
  void testSavingsAccountCreation() {
    Set<Customer> owners = Set.of(new Customer(null, "John Doe"));
    SavingsAccount savingsAccount = new SavingsAccount("123456789", owners, 1000.0);

    assertEquals("123456789", savingsAccount.getAccountNumber());
    assertEquals(owners, savingsAccount.getOwners());
    assertEquals(1000.0, savingsAccount.getBalance());
  }

  @Test
  void testDepositFunds() {
    Set<Customer> owners = Set.of(new Customer(null, "John Doe"));
    SavingsAccount savingsAccount = new SavingsAccount("123456789", owners, 1000.0);

    savingsAccount.deposit(500.0);
    assertEquals(1500.0, savingsAccount.getBalance());
  }
}
