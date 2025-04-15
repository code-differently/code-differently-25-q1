package com.codedifferently.lesson17.bank;

public abstract class SavingsAccount extends BankAccount {
    @Override
    public void deposit(double amount, String method) {
        if("check".equalsIgnoreCase(method)) {
            throw new UnsupportedOperationException("Cannot withdraw checks from the savings account");
        }

        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
       throw new IllegalArgumentException("Insufficient funds"); 
    }
}
}