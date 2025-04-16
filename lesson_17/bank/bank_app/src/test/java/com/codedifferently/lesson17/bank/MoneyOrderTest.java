package com.codedifferently.lesson17.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyOrderTest {

  private CheckingAccount sourceAccount;
  private CheckingAccount targetAccount;

  @BeforeEach
  void setUp() {
    Customer alice = new Customer(UUID.randomUUID(), "Alice");
    Customer bob = new Customer(UUID.randomUUID(), "Bob");

    sourceAccount = new CheckingAccount("SRC123", Set.of(alice), 0.0);
    targetAccount = new CheckingAccount("TRG456", Set.of(bob), 0.0);

    sourceAccount.deposit(1000.0);
  }

  @Test
  void testMoneyOrderWithdrawsImmediatelyFromSource() {
    double initialBalance = sourceAccount.getBalance();
    double amount = 250.0;

    MoneyOrder moneyOrder = new MoneyOrder(sourceAccount, amount);

    assertEquals(initialBalance - amount, sourceAccount.getBalance(), 0.001);
  }

  @Test
  void testMoneyOrderCanBeDepositedToAnotherAccount() {
    double amount = 300.0;

    MoneyOrder moneyOrder = new MoneyOrder(sourceAccount, amount);
    moneyOrder.depositFunds(targetAccount);

    assertEquals(amount, targetAccount.getBalance(), 0.001);
  }

  @Test
  void testMoneyOrderAmountIsCorrect() {
    MoneyOrder moneyOrder = new MoneyOrder(sourceAccount, 123.45);
    assertEquals(123.45, moneyOrder.getAmount(), 0.001);
  }
}
