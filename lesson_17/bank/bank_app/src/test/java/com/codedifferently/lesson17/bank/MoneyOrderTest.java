package com.codedifferently.lesson17.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.codedifferently.lesson17.bank.exceptions.MoneyOrderVoidedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyOrderTest {

  private CheckingAccount account1;
  private CheckingAccount account2;
  private MoneyOrder classUnderTest;

  @BeforeEach
  void setUp() {
    account1 = new CheckingAccount("123456789", null, 200.0);
    account2 = new CheckingAccount("987654321", null, 300.0);
    classUnderTest = new MoneyOrder("123456789", 50.0, account1);
  }

  @Test
  void testInitializesProperly() {
    // Arrange
    double balanceAfterMoneyOrder = account1.getBalance();

    // Act - happened upon money order creation

    // Assert
    assertThat(balanceAfterMoneyOrder).isEqualTo(150.0);
  }

  @Test
  void testDepositFunds() {
    // Act
    classUnderTest.depositFunds(account2);

    // Assert
    assertThat(account1.getBalance()).isEqualTo(100.0);
    assertThat(account2.getBalance()).isEqualTo(350.0);
  }

  @Test
  void testDepositFunds_MoneyOrderVoided() {
    // Arrange
    classUnderTest.voidMoneyOrder();

    // Act & Assert
    assertThatExceptionOfType(MoneyOrderVoidedException.class)
        .isThrownBy(() -> classUnderTest.depositFunds(account2))
        .withMessage("Money order is voided");
  }

  @Test
  void testConstructor_CantCreateCheckWithNegativeAmount() {
    // Act & Assert
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new MoneyOrder("123456789", -50.0, account1))
        .withMessage("Money Order amount must be positive");
  }

  @Test
  void testHashCode() {
    // Arrange
    MoneyOrder otherMoneyOrder = new MoneyOrder("123456789", 100.0, account1);

    // Assert
    assertThat(classUnderTest.hashCode()).isEqualTo(otherMoneyOrder.hashCode());
  }

  @Test
  void testEquals() {
    // Arrange
    MoneyOrder otherCheck = new MoneyOrder("123456789", 25.0, account1);
    MoneyOrder differentCheck = new MoneyOrder("987654321", 25.0, account1);

    // Assert
    assertThat(classUnderTest.equals(otherCheck)).isTrue();
    assertThat(classUnderTest.equals(differentCheck)).isFalse();
  }

  @Test
  void testToString() {
    // Assert
    assertThat(classUnderTest.toString())
        .isEqualTo("Money Order{money Order Number='123456789', amount=50.0, account=123456789}");
  }
}
