//Only Allows Deposits when accessing Atm on your Savings Account

public class SavingsAccount extends BankAccount {

    @Override
    public void deposit(double amount, String method) {
        if("check".equalsIgnoreCase(method)) {
            throw new UnsupportedOperationException("Deposit not allowed");
        }

        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
       throw new IllegalArgumentException("Insufficient funds"); 
    }
}