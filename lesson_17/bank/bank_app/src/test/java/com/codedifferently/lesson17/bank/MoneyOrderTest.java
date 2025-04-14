package test.java.com.codedifferently.lesson17.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codedifferently.lesson17.bank.CheckingAccount;

import main.java.com.codedifferently.lesson17.bank.MoneyOrder;
import main.java.com.codedifferently.lesson17.bank.exceptions.MoneyOrderVoidedException;

class MoneyOrderTest {
  private CheckingAccount account1;
  private CheckingAccount account2;
  private MoneyOrder classUnderTest;

  @BeforeEach
  void setUp() {
    account1 = new CheckingAccount("123456789", null, 100.0);
    account2 = new CheckingAccount("987654321", null, 200.0);
    classUnderTest = new MoneyOrder("123456789", 50.0, account1);
  }

  @Test
  void testDepositFunds() {
    // Act
    classUnderTest.depositFunds(account2);
    // Assert
    assertThat(account1.getBalance()).isEqualTo(0.0);
    assertThat(account2.getBalance()).isEqualTo(250.0);
  }

  @Test
  void testDepositFunds_MoneyOrderVoided() {
    // Arrange
    classUnderTest.voidMoneyOrder();

    // Act & Assert
    assertThatExceptionOfType(MoneyOrderVoidedException.class)
        .isThrownBy(() -> classUnderTest.depositFunds(account2))
        .withMessage("MoneyOrder is voided");
  }

  @Test
  void testConstructor_CantCreateMoneyOrderWithNegativeAmount() {
    // Act & Assert
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new MoneyOrder("123456789", -50.0, account1))
        .withMessage("MoneyOrder amount must be positive");
  }

  @Test
  void testHashCode() {
    // Arrange
    MoneyOrder otherMoneyOrder = new MoneyOrder("123456789", 50.0, account1);

    // Assert
    assertThat(classUnderTest.hashCode()).isEqualTo(otherMoneyOrder.hashCode());
  }

  @Test
  void testEquals() {
    // Arrange
    MoneyOrder otherMoneyOrder = new MoneyOrder("123456789", 50.0, account1);
    MoneyOrder differentMoneyOrder = new MoneyOrder("987654321", 100.0, account2);

    // Assert
    assertThat(classUnderTest.equals(otherMoneyOrder)).isTrue();
    assertThat(classUnderTest.equals(differentMoneyOrder)).isFalse();
  }

  @Test
  void testToString() {
    // Assert
    assertThat(classUnderTest.toString())
        .isEqualTo("MoneyOrder{moneyOrderNumber='123456789', amount=50.0, account=123456789}");
  }
}