package com.codedifferently.lesson17.bank;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class BusinessCheckingAccountTest {
  @Test
  public void testAddBusinessCheckingAccountWithBusinessOwner() {

    BankAtm atm = new BankAtm();

    UUID customerId = UUID.randomUUID();

    BusinessCustomer businessCustomer = new BusinessCustomer(UUID.randomUUID(), "Business1");
    Customer personalCustomer = new Customer(UUID.randomUUID(), "Personal1");

    Set<Customer> owners = new HashSet<>();
    owners.add(businessCustomer);
    owners.add(personalCustomer);

    BusinessCheckingAccount businessAccount = new BusinessCheckingAccount("12345", owners, 2000.00);
    atm.addAccount(businessAccount);
    assertNotNull((atm.findAccountsByCustomerId(customerId)));
  }

  @Test
  public void testAddBusinessCheckingAccountWithoutBusinessOwner() {

    BankAtm atm = new BankAtm();

    Customer personalCustomer1 = new Customer(UUID.randomUUID(), "Personal1");
    Customer personalCustomer2 = new Customer(UUID.randomUUID(), "Personal2");

    Set<Customer> owners = new HashSet<>();
    owners.add(personalCustomer1);
    owners.add(personalCustomer2);

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              BusinessCheckingAccount businessAccount =
                  new BusinessCheckingAccount("12345", owners, 2000.00);
              atm.addAccount(businessAccount);
            });
  }
}
