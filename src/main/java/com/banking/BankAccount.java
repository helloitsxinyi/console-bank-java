package com.banking;

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

    public int getBalance() {
        return balance;
    }

    public int getPreviousTransaction() {
        return previousTransaction;
    }
}
