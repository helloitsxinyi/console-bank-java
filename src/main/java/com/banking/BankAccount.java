package com.banking;

public class BankAccount {

    private String customerId;
    private String customerName;


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
}
