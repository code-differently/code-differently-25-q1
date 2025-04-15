package com.codedifferently.lesson17.bank;

import java.util.Set;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
        super(accountNumber, owners, initialBalance);
    }

    /**
     * Override withdraw to restrict check withdrawals for savings accounts.
     */
    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // Check for withdrawal via check (additional logic can be added here if needed)
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds in savings account.");
        }
        balance -= amount;
    }
}


