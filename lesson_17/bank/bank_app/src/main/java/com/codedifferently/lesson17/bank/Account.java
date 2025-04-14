package com.codedifferently.lesson17.bank;

import com.codedifferently.lesson17.bank.exceptions.InsufficientFundsException;
import java.util.Set;

public abstract class Account {
    private final Set<Customer> owners;
    private final String accountNumber;
    protected double balance;
    protected boolean isActive;

    /**
     * Constructs a new Account.
     * 
     * @param accountNumber The account number.
     * @param owners The owners of the account.
     * @param initialBalance The starting balance.
     */
    public Account(String accountNumber, Set<Customer> owners, double initialBalance) {
        this.accountNumber = accountNumber;
        this.owners = owners;
        this.balance = initialBalance;
        this.isActive = true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Set<Customer> getOwners() {
        return owners;
    }

    public void deposit(double amount) {
        if (isClosed()) {
            throw new IllegalStateException("Cannot deposit to a closed account");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (isClosed()) {
            throw new IllegalStateException("Cannot withdraw from a closed account");
        }
        if (amount <= 0) {
            throw new IllegalStateException("Withdrawal amount must be positive");
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Account does not have enough funds for withdrawal");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void closeAccount() {
        if (balance > 0) {
            throw new IllegalStateException("Cannot close account with a positive balance");
        }
        isActive = false;
    }

    public boolean isClosed() {
        return !isActive;
    }

    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account other) {
            return this.accountNumber.equals(other.accountNumber);
        }
        return false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", isActive=" + isActive +
                '}';
    }
}
