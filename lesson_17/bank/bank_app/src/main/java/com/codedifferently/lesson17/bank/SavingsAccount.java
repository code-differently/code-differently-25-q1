package main.java.com.codedifferently.lesson17.bank;

import java.util.Set;

import org.assertj.core.api.ThrowableAssertAlternative;

import com.codedifferently.lesson17.bank.Customer;

public class SavingsAccount extends CheckingAccount {
  public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }

    public SavingsAccount(String string, Set<Customer> owners, double d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  @Override
  public int hashCode() {
    return getAccountNumber().hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof SavingsAccount other) {
      return this.getAccountNumber().equals(other.getAccountNumber());
    }
    return false;
  }

  @Override
  public String toString() {
    return "SavingsAccount{"
        + "accountNumber='"
        + getAccountNumber()
        + '\''
        + ", balance="
        + getBalance()
        + ", isActive="
        + getStatus()
        + '}';
  }

    public Object getAccountNumber() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getOwners() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deposit(double d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double getBalance() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void withdraw(double d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ThrowableAssertAlternative<IllegalStateException> closeAccount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isClosed() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
