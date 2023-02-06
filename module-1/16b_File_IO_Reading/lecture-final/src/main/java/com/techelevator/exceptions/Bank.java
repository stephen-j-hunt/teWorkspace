package com.techelevator.exceptions;

public class Bank {
    CheckingAccount account = new CheckingAccount();
    public void helpCustomer() throws OverdraftException {
        account.withdraw(100);
    }
}
