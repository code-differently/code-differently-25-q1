

public class SavingsAccount extends BankAccount {

    @Override
    public boolean canWithdrawWithCheck() {
        return false; 
    }
}