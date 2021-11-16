package com.banking;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class AccountMenu {

    private static BankAccount account;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        account = new BankAccount("John Tan", "abc123");
        showMenuIntroAndOptions(account);

    }

    private static void showMenuIntroAndOptions(BankAccount account) {
        try {
            System.out.println("Welcome " + account.getCustomerName());
            System.out.println("ID: " + account.getCustomerId());
            System.out.println("You have the following options: ");
            System.out.println("A: Get balance");
            System.out.println("B: Deposit");
            System.out.println("C: Withdraw");
            System.out.println("D: Check most recent transaction");
            System.out.println("E: Exit");

            char option;

            do {
                System.out.println("Select an option: ");
                option = toUpperCase(scanner.next().charAt(0));
                enterOption(option);
            } while (option != 'E');

        } catch (IllegalStateException e) {
            System.out.println("Invalid option!");
            showMenuIntroAndOptions(account);
        }
    }

    private static void enterOption(char option) throws IllegalStateException {
        try {
                switch (option) {
                    case 'A' -> System.out.println(account.getBalance());
                    case 'B' -> selectedDeposit();
                    case 'C' -> selectedWithdrawal();
                    case 'D' -> System.out.println(account.getPreviousTransaction());
                    case 'E' -> System.out.println("Goodbye!");
                    default -> throw new IllegalStateException("Unexpected value: " + option);
                }
        } catch (InvalidAmountException e) {
            System.out.println("Invalid input! Please try again.");
            enterOption(option);
        }
    }

    private static void selectedDeposit() throws InvalidAmountException {
        System.out.println("Enter the amount you wish to deposit: ");
        int depositAmount = scanner.nextInt();
        account.deposit(depositAmount);
        System.out.println("Deposit of " + depositAmount + " completed!");
    }

    private static void selectedWithdrawal() throws InvalidAmountException {
        System.out.println("Enter the amount you wish to withdraw: ");
        int withdrawalAmount = scanner.nextInt();
        account.withdraw(withdrawalAmount);
        System.out.println("Withdrawal of " + withdrawalAmount + " completed!");
    }
}
