package com.codedifferently.lesson17.bank;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {

  private SavingsAccount account;
  private Set<Customer> owners;

  @BeforeEach
  void setUp() {
    owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "John Snow", CustomerType.INDIVIDUAL));
    owners.add(new Customer(UUID.randomUUID(), "Jamie Lannister", CustomerType.INDIVIDUAL));

    account = new SavingsAccount("123456789", owners, 100.0);
  }

  @Test
  void deposit() {
    account.deposit(100.0);
    assertEquals(200.0, account.getBalance());
  }

  @Test
  void withdraw() {
    account.withdraw(25.0);
    assertEquals(75.0, account.getBalance());
  }

  @Test
  void withdraw_withNegativeAmount() {
    assertThatExceptionOfType(IllegalStateException.class)
        .isThrownBy(() -> account.withdraw(-25.0))
        .withMessage("Withdrawal amount must be positive");
  }

  @Test
  void withdraw_withInsufficientBalance() {
    assertThatExceptionOfType(InsufficientFundsException.class)
        .isThrownBy(() -> account.withdraw(200.0))
        .withMessage("Account does not have enough funds for withdrawal");
  }

  @Test
  void closeAccount_withPositiveBalance() {
    assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> account.closeAccount());
  }

  @Test
  void isClosed() {
    assertFalse(account.isClosed());
    account.withdraw(100.0);
    account.closeAccount();
    assertTrue(account.isClosed());
  }
}
