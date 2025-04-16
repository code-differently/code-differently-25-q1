package com.codedifferently.lesson17.bank;

import java.util.Set;

/**
 * Represents a savings account that does not support check writing.
 */
public class SavingsAccount extends CheckingAccount {

    public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
        super(accountNumber, owners, initialBalance);
    }
}
