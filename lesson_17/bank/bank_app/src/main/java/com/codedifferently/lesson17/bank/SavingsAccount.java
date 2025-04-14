package com.codedifferently.lesson17.bank;

import java.util.Set;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;
// Removed redundant or incorrect import


/** Represents a savings account, which does not support check writing. */
public class SavingsAccount extends CheckingAccount {

    /**
     * Creates a new savings account.
     *
     * @param accountNumber  The account number.
     * @param owners         The owners of the account.
     * @param initialBalance The initial balance of the account.
     */
    public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
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
        // Use a protected setter or a method in parent class if balance is private
        super.withdraw(amount); // Use super if parent class has the logic
    }

    /**
     * Disallows writing checks from a savings account.
     *
     * @param check The amount to write on the check.
     * @throws UnsupportedOperationException Always, since savings accounts don't support checks.
     */
    public void writeCheck(Check check) {
        throw new UnsupportedOperationException("Savings accounts can't write checks.");
    }
}
