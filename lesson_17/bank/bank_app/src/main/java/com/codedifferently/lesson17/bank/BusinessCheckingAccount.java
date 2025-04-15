package com.codedifferently.lesson17.bank;

import java.util.Set;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;

public class BusinessCheckingAccount extends BankAccount {
    private boolean isBusiness;

    public BusinessCheckingAccount(String accountNumber, Set<Customer> owners, double initialBalance, boolean isBusiness) {
        super(accountNumber, owners, initialBalance);
        this.isBusiness = isBusiness;
    }

    /**
     * Business accounts may have special conditions for checks, etc.
     */
    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // Business checking accounts can withdraw with more flexibility
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds in business checking account.");
        }
        balance -= amount;
    }

    public boolean isBusiness() {
        return isBusiness;
    }
}