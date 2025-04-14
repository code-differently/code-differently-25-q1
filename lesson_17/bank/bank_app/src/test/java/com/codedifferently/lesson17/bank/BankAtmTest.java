package com.codedifferently.lesson17.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.codedifferently.lesson17.bank.exceptions.AccountNotFoundException;
import com.codedifferently.lesson17.bank.exceptions.CheckVoidedException;
import com.codedifferently.lesson17.bank.exceptions.InvalidBusinessAccountException;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAtmTest {

  private BankAtm classUnderTest;
  private BankAccount checkingAccount1;
  private BankAccount checkingAccount2;
  private BankAccount savingsAccount1;
  private BankAccount savingsAccount2;
  private Customer customer1;
  private Customer customer2;

  @BeforeEach
  void setUp() {
    classUnderTest = new BankAtm();
    customer1 = new Customer(UUID.randomUUID(), "John Doe", false);
    customer2 = new Customer(UUID.randomUUID(), "Jane Smith", false);
    checkingAccount1 = new CheckingAccount("12345", Set.of(customer1), 100.0);
    checkingAccount2 = new CheckingAccount("54321", Set.of(customer1, customer2), 200.0);
    savingsAccount1 = new SavingsAccount("56789", Set.of(customer1), 100.0);
    savingsAccount2 = new SavingsAccount("98765", Set.of(customer1, customer2), 200.0);
    customer1.addAccount(checkingAccount1);
    customer1.addAccount(checkingAccount2);
    customer2.addAccount(checkingAccount1);
    customer2.addAccount(checkingAccount2);
    customer1.addAccount(savingsAccount1);
    customer1.addAccount(savingsAccount2);
    customer2.addAccount(savingsAccount1);
    customer2.addAccount(savingsAccount2);
    classUnderTest.addAccount(checkingAccount1);
    classUnderTest.addAccount(checkingAccount2);
    classUnderTest.addAccount(savingsAccount1);
    classUnderTest.addAccount(savingsAccount2);
  }

  @Test
  void testAddAccount() {
    // Arrange
    Customer customer3 = new Customer(UUID.randomUUID(), "Alice Johnson", false);
    BankAccount checkingAccount3 = new CheckingAccount("555555555", Set.of(customer3), 300.0);
    BankAccount savingsAccount3 = new SavingsAccount("666666666", Set.of(customer3), 300.0);
    customer3.addAccount(checkingAccount3);
    customer3.addAccount(savingsAccount3);

    // Act
    classUnderTest.addAccount(checkingAccount3);
    classUnderTest.addAccount(savingsAccount3);

    // Assert
    Set<BankAccount> accounts = classUnderTest.findAccountsByCustomerId(customer3.getId());
    assertThat(accounts).contains(checkingAccount3);
    assertThat(accounts).contains(savingsAccount3);
  }

  @Test
  void testBusinessCheckingAccount_WithBusinessOwner_Succeeds() {
    // Arrange
    Customer businessCustomer = new Customer(UUID.randomUUID(), "Business LLC", true);
    Customer individualCustomer = new Customer(UUID.randomUUID(), "Regular Joe", false);
    Set<Customer> owners = Set.of(businessCustomer, individualCustomer);

    // Act
    BusinessCheckingAccount businessAccount = new BusinessCheckingAccount("BUS123", owners, 1000.0);

    // Assert
    assertThat(businessAccount.getBalance()).isEqualTo(1000.0);
    assertThat(businessAccount.getOwners()).contains(businessCustomer);
  }

  @Test
  void testBusinessCheckingAccount_WithoutBusinessOwner_ThrowsException() {
    // Arrange
    Customer c1 = new Customer(UUID.randomUUID(), "Person One", false);
    Customer c2 = new Customer(UUID.randomUUID(), "Person Two", false);
    Set<Customer> owners = Set.of(c1, c2);

    // Act & Assert
    assertThatThrownBy(() -> new BusinessCheckingAccount("BUS999", owners, 500.0))
        .isInstanceOf(InvalidBusinessAccountException.class)
        .hasMessage("At least one owner must be a business.");
  }

  @Test
  void testFindAccountsByCustomerId() {
    // Act
    Set<BankAccount> accounts = classUnderTest.findAccountsByCustomerId(customer1.getId());

    // Assert
    assertThat(accounts).contains(checkingAccount1, checkingAccount2);
    assertThat(accounts).contains(savingsAccount1, savingsAccount2);
  }

  @Test
  void testDepositFunds() {
    // Act
    classUnderTest.depositFunds(checkingAccount1.getAccountNumber(), 50.0);
    classUnderTest.depositFunds(savingsAccount1.getAccountNumber(), 50.0);

    // Assert
    assertThat(checkingAccount1.getBalance()).isEqualTo(150.0);
    assertThat(savingsAccount1.getBalance()).isEqualTo(150.0);
  }

  @Test
  void testDepositFunds_Check() throws Exception {
    // Arrange
    Check check = new Check("12345", 100.0, checkingAccount1);

    // Act
    classUnderTest.depositFunds("54321", check);

    // Assert
    assertThat(checkingAccount1.getBalance()).isEqualTo(0);
    assertThat(checkingAccount2.getBalance()).isEqualTo(300.0);
    assertThatThrownBy(() -> new Check("88888", 100.0, savingsAccount1))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Cannot write a check from a savings account");
  }

  @Test
  void testDepositFunds_DoesntDepositCheckTwice() throws Exception {
    Check check = new Check("987654321", 100.0, checkingAccount1);

    classUnderTest.depositFunds("54321", check);

    assertThatExceptionOfType(CheckVoidedException.class)
        .isThrownBy(() -> classUnderTest.depositFunds("54321", check))
        .withMessage("Check is voided");
  }

  @Test
  void testWithdrawFunds() throws Exception {
    // Act
    classUnderTest.withdrawFunds(checkingAccount2.getAccountNumber(), 50.0);

    // Assert
    assertThat(checkingAccount2.getBalance()).isEqualTo(150.0);
  }

  @Test
  void testWithdrawFunds_AccountNotFound() {
    String nonExistingAccountNumber = "999999999";

    // Act & Assert
    assertThatExceptionOfType(AccountNotFoundException.class)
        .isThrownBy(() -> classUnderTest.withdrawFunds(nonExistingAccountNumber, 50.0))
        .withMessage("Account not found");
  }
}
