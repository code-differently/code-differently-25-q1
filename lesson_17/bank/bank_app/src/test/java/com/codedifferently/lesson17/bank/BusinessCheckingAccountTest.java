package com.codedifferently.lesson17.bank;

import static org.junit.jupiter.api.Assertions.*;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BusinessCheckingAccountTest {

  private BusinessCheckingAccount account;

  @BeforeEach
  void setUp() {
    Set<Customer> owners = new HashSet<>();
    owners.add(new Customer("Bryana Singleton-Barnhart", true));
    account = new BusinessCheckingAccount("001", owners, 1000.00, true);
  }

  @Test
  void testIsBusinessReturnsTrue() {
    assertTrue(account.isBusiness());
  }

  @Test
  void testWithdrawWithinBalance() throws InsufficientFundsException {
    account.withdraw(500.00);
    assertEquals(500.00, account.getBalance(), 0.01);
  }

  @Test
  void testWithdrawExactBalance() throws InsufficientFundsException {
    account.withdraw(1000.00);
    assertEquals(0.00, account.getBalance(), 0.01);
  }

  @Test
  void testWithdrawMoreThanBalanceThrowsException() {
    assertThrows(InsufficientFundsException.class, () -> account.withdraw(1500.00));
  }
}
