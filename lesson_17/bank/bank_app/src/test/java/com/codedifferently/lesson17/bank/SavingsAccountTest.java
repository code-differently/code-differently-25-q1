package com.codedifferently.lesson17.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

  private SavingsAccount classUnderTest;
  private HashSet<Customer> owners;

  @BeforeEach
  void setUp() {
    owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "John Doe"));
    owners.add(new Customer(UUID.randomUUID(), "Jane Smith"));
    classUnderTest = new SavingsAccount("123456789", owners, 100.0);
  }

  @Test
  void testHashCode() {
    int expected = classUnderTest.getAccountNumber().hashCode();
    int actual = classUnderTest.hashCode();
    assertEquals(expected, actual);
  }

  @Test
  void testEquals() {
    SavingsAccount other = new SavingsAccount("123456789", owners, 100.0);
    boolean expected = true;
    boolean actual = classUnderTest.equals(other);
    assertEquals(expected, actual);
  }

  @Test
  void testCheckWithdrawl() {
    Check check = new Check("123456789", 1000.0, classUnderTest);

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> {
              classUnderTest.withdraw(1000, check);
            });

    assertEquals("Cannot withdraw from a savings account using a check", exception.getMessage());
  }
}
