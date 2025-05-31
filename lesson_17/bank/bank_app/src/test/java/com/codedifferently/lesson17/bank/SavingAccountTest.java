package com.codedifferently.lesson17.bank;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SavingAccountTest {

  private SavingAccount classUnderTest;
  private Set<Customer> owners;

  @BeforeEach
  void setUp() {
    owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "John Doe"));
    owners.add(new Customer(UUID.randomUUID(), "Jane Smith"));
    classUnderTest = new SavingAccount("123456789", owners, 100.0);
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
  void getBalance() {
    assertEquals(100.0, classUnderTest.getBalance());
  }

  @Test
  void closeAccount_withPositiveBalance() {
    assertThatExceptionOfType(IllegalStateException.class)
        .isThrownBy(() -> classUnderTest.closeAccount());
  }

  @Test
  void equals() {
    SavingAccount otherAccount = new SavingAccount("123456789", owners, 200.0);
    assertEquals(classUnderTest, otherAccount);
  }

  @Test
  void hashCodeTest() {
    SavingAccount otherAccount = new SavingAccount("123456789", owners, 200.0);
    assertEquals(classUnderTest.hashCode(), otherAccount.hashCode());
  }

  @Test
  void toStringTest() {
    String expected = "SavingAccount{accountNumber='123456789', balance=100.0, isActive=true}";
    assertEquals(expected, classUnderTest.toString());
  }
}
