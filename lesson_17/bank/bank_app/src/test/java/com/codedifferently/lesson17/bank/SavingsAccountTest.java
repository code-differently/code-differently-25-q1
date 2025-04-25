package com.codedifferently.lesson17.bank;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

  private SavingsAccount savingsAccount;
  private Set<Customer> accountOwners;

  @BeforeEach
  void setUp() {
    accountOwners = new HashSet<>();
    accountOwners.add(new Customer(UUID.randomUUID(), "John Doe"));
    savingsAccount = new SavingsAccount("987654321", accountOwners, 200.0);
  }

  @Test
  void shouldReturnAccountNumber() {
    assertEquals("987654321", savingsAccount.getAccountNumber());
  }

  @Test
  void shouldReturnAccountOwners() {
    assertEquals(accountOwners, savingsAccount.getOwners());
  }

  @Test
  void shouldDepositFundsSuccessfully() {
    savingsAccount.deposit(100.0);
    assertEquals(300.0, savingsAccount.getBalance());
  }

  @Test
  void shouldThrowExceptionForNegativeDeposit() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> savingsAccount.deposit(-20.0));
  }

  @Test
  void shouldWithdrawFundsSuccessfully() {
    savingsAccount.withdraw(50.0);
    assertEquals(150.0, savingsAccount.getBalance());
  }

  @Test
  void shouldThrowExceptionForNegativeWithdrawalAmount() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> savingsAccount.withdraw(-10.0))
        .withMessage("Withdrawal amount must be positive");
  }

  @Test
  void shouldThrowExceptionForInsufficientBalance() {
    assertThatExceptionOfType(InsufficientFundsException.class)
        .isThrownBy(() -> savingsAccount.withdraw(500.0))
        .withMessage("Account does not have enough funds for withdrawal");
  }

  @Test
  void shouldReturnBalance() {
    assertEquals(200.0, savingsAccount.getBalance());
  }

  @Test
  void shouldThrowExceptionWhenClosingAccountWithPositiveBalance() {
    assertThatExceptionOfType(IllegalStateException.class)
        .isThrownBy(() -> savingsAccount.closeAccount());
  }

  @Test
  void shouldBeClosedAfterWithdrawAndClose() {
    savingsAccount.withdraw(200.0);
    savingsAccount.closeAccount();
    assertTrue(savingsAccount.isClosed());
  }

  @Test
  void shouldCheckEqualityAndHashCode() {
    Set<Customer> owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "John Doe"));

    SavingsAccount account1 = new SavingsAccount("987654321", owners, 200.0);
    SavingsAccount account2 = new SavingsAccount("987654321", owners, 200.0);

    assertEquals(account1, account2);

    assertEquals(account1.hashCode(), account2.hashCode());
  }
}
