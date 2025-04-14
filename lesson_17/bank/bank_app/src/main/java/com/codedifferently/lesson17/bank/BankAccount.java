package com.codedifferently.lesson17.bank;
/*  We want to support a Savings Account that works just like CheckinAccount,
 *  But will not allow you to write checks aainst the account.
 * 
 *  We want the BankAtm class to support the concept of a Business Checking Account
 *  A business acount will require that at least ne of the owning accoutns is a business account.
 *  
 */

public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    public abstract void deposit(double amount, String method);
    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    //Follows LSP 
    public interface depositable {
        void deposit(double amount, String method);
    }
    public interface withdrawable {
        void withdraw(double amount);
    }
}