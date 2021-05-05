package com.banking;

import java.util.Scanner;

public class ATM {

    private static BankAccount account;

    public static void main(String[] args) {
        account = new BankAccount();

            showMenuIntroAndOptions(account);

    }

    private static void showMenuIntroAndOptions(BankAccount account) {
        System.out.println("Welcome " + account.getCustomerName());
        System.out.println("ID: " + account.getCustomerId());
        System.out.println("You have the following options: ");
        System.out.println("A: Get balance");
        System.out.println("B: Exit");

        enterOption();
    }

    private static void enterOption() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option: ");
        char option = scanner.next().charAt(0);

        switch (option) {
            case 'A':
                System.out.println(account.getBalance());
                break;
            case 'B':
                System.out.println("Goodbye!");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }
}
