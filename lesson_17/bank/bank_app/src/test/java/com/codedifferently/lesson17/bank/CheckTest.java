package com.codedifferently.lesson17.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.codedifferently.lesson17.bank.exceptions.CheckVoidedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckTest {

  private CheckingAccount account1;
  private CheckingAccount account2;
  private Check classUnderTest;

  @BeforeEach
  void setUp() {
    account1 = new CheckingAccount("123456789", null, 100.0);
    account2 = new CheckingAccount("987654321", null, 200.0);
    classUnderTest = new Check("123456789", 50.0, account1);
  }

  @Test
  void testDepositFunds() {
    // Act
    classUnderTest.depositFunds(account2);

    // Assert
    assertThat(account1.getBalance()).isEqualTo(50.0);
    assertThat(account2.getBalance()).isEqualTo(250.0);
  }

  @Test
  void testDepositFunds_CheckVoided() {
    // Arrange
    classUnderTest.voidCheck();

    // Act & Assert
    assertThatExceptionOfType(CheckVoidedException.class)
        .isThrownBy(() -> classUnderTest.depositFunds(account2))
        .withMessage("Check is voided");
  }

  @Test
  void testConstructor_CantCreateCheckWithNegativeAmount() {
    // Act & Assert
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new Check("123456789", -50.0, account1))
        .withMessage("Check amount must be positive");
  }

  @Test
  void testHashCode() {
    // Arrange
    Check otherCheck = new Check("123456789", 100.0, account1);

    // Assert
    assertThat(classUnderTest.hashCode()).isEqualTo(otherCheck.hashCode());
  }

  @Test
  void testEquals() {
    // Arrange
    Check otherCheck = new Check("123456789", 100.0, account1);
    Check differentCheck = new Check("987654321", 100.0, account1);

    // Assert
    assertThat(classUnderTest.equals(otherCheck)).isTrue();
    assertThat(classUnderTest.equals(differentCheck)).isFalse();
  }

  @Test
  void testToString() {
    // Assert
    assertThat(classUnderTest.toString())
        .isEqualTo("Check{checkNumber='123456789', amount=50.0, account=123456789}");
  }
}
