package com.banking;

import static java.lang.Math.abs;

public class BankAccount {

    private String customerId;
    private String customerName;
    private int balance;
    private int previousTransaction;


    public BankAccount() {
        customerName = "Xiao Ming";
        customerId = "123";
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void deposit(int depositAmount) throws InvalidAmountException {
        if (depositAmount <= 0) {
            throw new InvalidAmountException();
        }
        balance += depositAmount;
        previousTransaction = depositAmount;
    }

    public void withdraw(int withdrawAmount) throws InvalidAmountException {
        if (withdrawAmount > balance || withdrawAmount <= 0) {
            throw new InvalidAmountException();
        }
        balance -= withdrawAmount;
        previousTransaction = -withdrawAmount;
    }

    public String getBalance() {
        return "Balance: " + balance;
    }

    public String getPreviousTransaction() {
        if (previousTransaction > 0) {
            return "Previous transaction: deposit of " + previousTransaction;
        }
        return "Previous transaction: withdrawal of " + abs(previousTransaction);
    }
}
