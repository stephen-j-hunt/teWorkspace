package com.techelevator.exceptions;

public class CheckingAccount {
    private int balance;

    public int withdraw(int amount) throws OverdraftException {

        if (balance - amount <= 0) {
            throw new OverdraftException("balance cannot be negative", amount);
        }

        // will not run if amount > balance
        balance -= amount;
        return balance;
    }
}
