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

    public void deposit(int depositAmount) {
        balance += depositAmount;
    }

    public int getBalance() {
        return balance;
    }

}
