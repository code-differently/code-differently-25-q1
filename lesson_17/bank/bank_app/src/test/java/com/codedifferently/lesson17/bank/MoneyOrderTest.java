package com.codedifferently.lesson17.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyOrderTest {

  private BankAccount sourceAccount;
  private BankAccount targetAccount;

  @BeforeEach
  void setUp() {
    sourceAccount = new SourceAccount("123", 500);
    targetAccount = new TargetAccount("456", 100);
  }

  @Test
  void testMoneyOrderWithdrawalOnCreation() {
    new MoneyOrder("MO-001", 200, sourceAccount);
    assertEquals(300, sourceAccount.getBalance(), 0.001);
  }

  @Test
  void testMoneyOrderRedeem() {
    MoneyOrder mo = new MoneyOrder("MO-002", 150, sourceAccount);
    mo.redeem(targetAccount);

    assertEquals(250, targetAccount.getBalance(), 0.001);
    assertTrue(mo.isRedeemed());
  }

  @Test
  void testRedeemAlreadyRedeemedMoneyOrderThrows() {
    MoneyOrder mo = new MoneyOrder("MO-003", 100, sourceAccount);
    mo.redeem(targetAccount);

    IllegalStateException exception =
        assertThrows(IllegalStateException.class, () -> mo.redeem(targetAccount));
    assertEquals("Money order already redeemed", exception.getMessage());
  }

  @Test
  void testInsufficientFundsOnCreation() {
    BankAccount lowFundsAccount = new SourceAccount("789", 50);
    assertThrows(
        InsufficientFundsException.class, () -> new MoneyOrder("MO-004", 100, lowFundsAccount));
  }
}
