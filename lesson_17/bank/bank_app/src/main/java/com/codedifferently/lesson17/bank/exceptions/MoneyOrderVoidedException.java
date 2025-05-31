package com.codedifferently.lesson17.bank.exceptions;

public class MoneyOrderVoidedException extends RuntimeException {
    public MoneyOrderVoidedException() {}

    public MoneyOrderVoidedException(String message){
        super(message);
    }
}
