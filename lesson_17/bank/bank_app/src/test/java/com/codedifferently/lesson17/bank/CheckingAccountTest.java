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

class CheckingAccountTest {

  private CheckingAccount classUnderTest;
  private Set<Customer> owners;

  @BeforeEach
  void setUp() {
    owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "John Doe"));
    owners.add(new Customer(UUID.randomUUID(), "Jane Smith"));
    classUnderTest = new CheckingAccount("123456789", owners, 100.0);
  }

  @Test
  void getAccountNumber() {
    assertEquals("123456789", classUnderTest.getAccountNumber());
  }

  @Test
  void getOwners() {
    assertEquals(owners, classUnderTest.getOwners());
  }

  @Test
  void deposit() {
    classUnderTest.deposit(50.0);
    assertEquals(150.0, classUnderTest.getBalance());
  }

  @Test
  void deposit_withNegativeAmount() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> classUnderTest.deposit(-50.0));
  }

  @Test
  void withdraw() {
    classUnderTest.withdraw(50.0);
    assertEquals(50.0, classUnderTest.getBalance());
  }

  @Test
  void withdraw_withNegativeAmount() {
    assertThatExceptionOfType(IllegalStateException.class)
        .isThrownBy(() -> classUnderTest.withdraw(-50.0))
        .withMessage("Withdrawal amount must be positive");
  }

  @Test
  void withdraw_withInsufficientBalance() {
    assertThatExceptionOfType(InsufficientFundsException.class)
        .isThrownBy(() -> classUnderTest.withdraw(150.0))
        .withMessage("Account does not have enough funds for withdrawal");
  }

  @Test
  void getBalance() {
    assertEquals(100.0, classUnderTest.getBalance());
  }

  @Test
  void closeAccount_withPositiveBalance() {
    assertThatExceptionOfType(IllegalStateException.class)
        .isThrownBy(() -> classUnderTest.closeAccount());
  }

  @Test
  void isClosed() {
    assertFalse(classUnderTest.isClosed());
    classUnderTest.withdraw(100);
    classUnderTest.closeAccount();
    assertTrue(classUnderTest.isClosed());
  }

  @Test
  void equals() {
    CheckingAccount otherAccount = new CheckingAccount("123456789", owners, 200.0);
    assertEquals(classUnderTest, otherAccount);
  }

  @Test
  void hashCodeTest() {
    CheckingAccount otherAccount = new CheckingAccount("123456789", owners, 200.0);
    assertEquals(classUnderTest.hashCode(), otherAccount.hashCode());
  }

  @Test
  void toStringTest() {
    String expected = "CheckingAccount{accountNumber='123456789', balance=100.0, isActive=true}";
    assertEquals(expected, classUnderTest.toString());
  }
}
