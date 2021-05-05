package com.banking;

public class BankAccount {

    private String customerId;
    private String customerName;
    private int balance;


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
        if (depositAmount > 0) {
            balance += depositAmount;
        } else {
            throw new InvalidAmountException();
        }
    }

    public int getBalance() {
        return balance;
    }


}
