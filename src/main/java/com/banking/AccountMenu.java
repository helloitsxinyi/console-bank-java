package com.banking;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class AccountMenu {

    private static BankAccount account;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        account = new BankAccount();
        try {
            showMenuIntroAndOptions(account);
        } catch (InvalidAmountException e) {
            System.out.println("Invalid input! Please try again.");
        }
    }

    private static void showMenuIntroAndOptions(BankAccount account) throws InvalidAmountException {
        System.out.println("Welcome " + account.getCustomerName());
        System.out.println("ID: " + account.getCustomerId());
        System.out.println("You have the following options: ");
        System.out.println("A: Get balance");
        System.out.println("B: Deposit");
        System.out.println("C: Withdraw");
        System.out.println("D: Check most recent transaction");
        System.out.println("E: Exit");

        enterOption();
    }

    private static void enterOption() throws InvalidAmountException {
        char option;

        do {
            System.out.println("Select an option: ");
            option = scanner.next().charAt(0);

            switch (option) {
                case 'A':
                    System.out.println(account.getBalance());
                    break;
                case 'B':
                    selectedDeposit();
                    break;
                case 'C':
                    selectedWithdrawal();
                    break;
                case 'D':
                    System.out.println(account.getPreviousTransaction());
                    break;
                case 'E':
                    System.out.println("Goodbye!");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }
        } while (option != 'E');
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
