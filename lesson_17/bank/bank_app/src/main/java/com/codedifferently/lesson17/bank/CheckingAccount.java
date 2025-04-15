 package com.codedifferently.lesson17.bank;

import java.util.Set;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
        super(accountNumber, owners, initialBalance);
      }
    }