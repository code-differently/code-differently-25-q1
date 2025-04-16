package com.codedifferently.lesson17.bank;

import static org.junit.jupiter.api.Assertions.*;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyOrderTest {

  private BankAccount sourceAccount;

  @BeforeEach
  void setUp() {
    Set<Customer> owners = new HashSet<>();
    owners.add(new Customer("Bryana Singleton-Barnhart", true));
    sourceAccount = new BankAccount("A001", owners, 1000.00);
  }

  @Test
  void testMoneyOrderProcessesSuccessfully() throws InsufficientFundsException {
    MoneyOrder moneyOrder = new MoneyOrder(sourceAccount, 400.00);
    moneyOrder.process();

    assertEquals(600.00, sourceAccount.getBalance(), 0.01);
  }

  @Test
  void testMoneyOrderThrowsExceptionWhenInsufficientFunds() {
    MoneyOrder moneyOrder = new MoneyOrder(sourceAccount, 1200.00);

    assertThrows(InsufficientFundsException.class, moneyOrder::process);
  }

  @Test
  void testGetAmountAndGetSourceAccount() {
    MoneyOrder moneyOrder = new MoneyOrder(sourceAccount, 250.00);

    assertEquals(250.00, moneyOrder.getAmount());
    assertEquals(sourceAccount, moneyOrder.getSourceAccount());
  }
}
