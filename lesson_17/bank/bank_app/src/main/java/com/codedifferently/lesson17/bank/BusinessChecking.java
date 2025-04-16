package com.codedifferently.lesson17.bank;

import java.util.Set;

public class BusinessChecking extends CheckingAccount { 
    //By extending the checking account class it will call to the methods of the 

    public BusinessChecking(String accountNumber, Set<Customer> owners, double initialBalance) {
        super(accountNumber, owners, initialBalance);

        boolean hasBusinessOwner = false;
        for (Customer owner : owners) {
            if (owner.isBusiness()) {
                hasBusinessOwner = true;
                break;
            }
        }

        if (!hasBusinessOwner) {
            throw new IllegalArgumentException("Business account must have at least one business owner.");
        }
    }
}
