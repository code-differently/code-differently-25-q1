package com.codedifferently.lesson17.bank;

import java.util.Set;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;

public class BusinessAccount extends CheckingAccount {

    /**
     * Creates a new business account.
     *
     * @param accountNumber  The account number.
     * @param owners         The owners of the account.
     * @param initialBalance The initial balance of the account.
     */
    public BusinessAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
        super(accountNumber, owners, initialBalance);
    }

    /**
     * Withdraws funds from the account.
     *
     * @param amount The amount to withdraw.
     * @throws InsufficientFundsException If there are insufficient funds in the account.
     */
    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds in the account.");
        }
        super.withdraw(amount);
    }
    
}
